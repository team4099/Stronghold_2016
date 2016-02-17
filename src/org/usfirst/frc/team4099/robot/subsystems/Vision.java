
/*
 * Vision subsystem - communicates with the external processor for actual data
 */

package org.usfirst.frc.team4099.robot.subsystems;
import org.usfirst.frc.team4099.lib.util.Constants;
import edu.wpi.first.wpilibj.command.Command;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/*
 * Interface to integrate with external imaging processing 
 */
class Vision
{
    private int acquiredTarget;
    private float verticalAngle, firingAcceleration, lateralAngle;

    public Vision() {
    }

    /* 
     * Checks for new vision data from the vision processor 
     * */ 
    public void updateVisionData() {
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
                this.lateralAngle = angle_args[0];
                this.verticalAngle = angle_args[1];
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*
     * Returns true if the bot is in range to land a shot
     */
    public int getTargetAcquired() {
        return this.acquiredTarget;
    }

    /*
     * Returns the lateral angle the bot/shooter must rotate laterally to land the shot
     */
    public float getLateralAngle() {
        return this.lateralAngle;
    }

    /*
     * Returns the vertical angle the shooting arm must be in to land the shot
     */
    public float getVerticalAngle() {
        return this.verticalAngle;
    }

    /*
     * Return the acceleration the shooter must shoot at to land the shot
     */
    public float getFiringAcceleration() {
        return this.firingAcceleration;
    }
}
