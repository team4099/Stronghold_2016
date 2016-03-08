
/*
 * Vision subsystem - communicates with the external processor for actual data
 */

package org.usfirst.frc.team4099.robot.subsystems;
import org.usfirst.frc.team4099.lib.util.Constants;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.AnalogInput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Vision extends Subsystem {
    private boolean acquiredTarget;
    private boolean canShoot;
    private float verticalAngle, firingAcceleration, lateralAngle;
    private AnalogInput distanceSensor;

    public Vision() {
        distanceSensor = new AnalogInput(3);
    }

    /**
     * Requests udoo vision for the angle needed to land a shot
     */
    public void pointToGoal() {
        this.verticalAngle = 0;
        this.lateralAngle = 0;
        this.acquiredTarget = false;
        
        try {
            URL udoo = new URL(Constants.UDOO_RESTFUL_ENDPOINT);
            HttpURLConnection connection = (HttpURLConnection) udoo.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            inputLine = in.readLine();
            String[] angle_args = inputLine.split(",");
            if (angle_args.length <= 1) {
                this.acquiredTarget = false;
            } else {
                this.acquiredTarget = true;
                this.lateralAngle = Float.parseFloat(angle_args[0]);
                this.verticalAngle = Float.parseFloat(angle_args[1]);
                System.out.println("Vision angles: " + this.lateralAngle + " " + this.verticalAngle);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculates the necessary angle to land a goal. Assumes the ramp is 
     * currently lined up to face the center of the goal
     *
     * See https://en.wikipedia.org/wiki/Trajectory_of_a_projectile#Angle_required_to_hit_coordinate_.28x.2Cy.29
     *
     * @return If the bot can even make the shot at that distance
     */
    public boolean aimShot() {
        // The distance sensor seems to return in values of tenths of an inch
        double distance = (distanceSensor.getAverageValue() / 10) * 2.54 / 100.0;

        // TODO:Find this experimentally
        double initialvelocity = 2;

        /* 
         * The height will be hard-coded instead of calculated for competition> 
         * We're including this calculation for the future if anyone wants to 
         * shoot to an arbitrary goal
         */
        double height = Math.sin(CommandBase.ramp.getCurrentAngle()) * distance;  

        double range = Math.sqrt(distance*distance - height*height);

        double determinant = Math.pow(initialvelocity, 4) - 9.8*(9.8 * Math.pow(range, 2) + 2 * height * Math.pow(initialvelocity, 2));
        this.canShoot = false;

        if (determinant < 0) {
            this.verticalAngle = 0;
            return false;
        }

        double highangle = Math.toDegrees(Math.atan((Math.pow(initialvelocity, 2) + Math.sqrt(determinant)) / (9.8*range)));
        double lowangle = Math.toDegrees(Math.atan((Math.pow(initialvelocity, 2) - Math.sqrt(determinant)) / (9.8*range)));

        double moveAngle = 0;

        for (double angle : new double[] {highangle, lowangle}) {
            if (angle > Constants.RAMP_LOWER_LIMIT && angle < Constants.RAMP_UPPER_LIMIT) {
                this.canShoot = true;

                // Pick the angle that requires the least movement of the ramp
                if (Math.abs(moveAngle) > Math.abs(angle - CommandBase.ramp.getCurrentAngle()) || moveAngle == 0) {
                    moveAngle = angle - CommandBase.ramp.getCurrentAngle();
                }
            }
        }

        this.verticalAngle = (float) moveAngle;
        return true;
        
        /*
        // Test code to report values since qdriverstation sucks
        try {
            URL test = new URL("http://10.40.99.210:5000/test?val=" + verticalAngle + "&distance=" + distance + "&angle=" + CommandBase.ramp.getCurrentAngle() + "&lowangle=" + lowangle + "&highangle=" + highangle);
            HttpURLConnection connection = (HttpURLConnection) test.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            inputLine = in.readLine();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

    @Override
    protected void initDefaultCommand() {
    }
    
    /**
     * @return true if the bot is in range to land a shot
     */
    public boolean getTargetAcquired() {
        return this.acquiredTarget;
    }

    /**
     * @return the lateral angle the bot/shooter must rotate laterally to land the shot
     */
    public float getLateralAngle() {
        return this.lateralAngle;
    }

    /**
     * @return the vertical angle the shooting arm must be in to land the shot
     */
    public float getVerticalAngle() {
        return this.verticalAngle;
    }

    /**
     * @return the acceleration the shooter must shoot at to land the shot
     */
    public float getFiringAcceleration() {
        return this.firingAcceleration;
    }

}
