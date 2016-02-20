package org.usfirst.frc.team4099.robot.commands;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class TurnAngle extends CommandBase {

    private double angle;
    private double startingAngle;
    private boolean turnRight;

    private double encoderThreshold;
    private double incrementAmount;
    
    private double angleThreshold;

    /**
     * @param angle The amount to turn in degrees
     *              TODO: figure out if this is really degrees or it is radians
     */
    public TurnAngle(double angle) {
        encoderThreshold = 2.5;
        incrementAmount = 0.01;
        angleThreshold = 3;
        this.angle = angle;
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
        System.out.println("trying to turn angle: " + angle);
        startingAngle = navX.getAngle();
        turnRight = angle > 0;
        if(turnRight) driveTrain.turnRight();
        else driveTrain.turnLeft();
    }

    @Override
    protected void execute() {
        double x;
        double leftEncoderSpeed = driveTrain.getLeftEncoderSpeed();
        double rightEncoderSpeed = driveTrain.getRightEncoderSpeed();

        if(Math.abs(x = Math.abs(leftEncoderSpeed) - Math.abs(rightEncoderSpeed)) > encoderThreshold) {
            int leftDirection = (int) (leftEncoderSpeed / Math.abs(leftEncoderSpeed));
            int rightDirection = (int) (rightEncoderSpeed / Math.abs(rightEncoderSpeed));

            if(x < 0) {
                driveTrain.drive(driveTrain.getLeftMotorSpeed() - leftDirection * incrementAmount, driveTrain.getRightMotorSpeed() + rightDirection * incrementAmount);
            } else {
                driveTrain.drive(driveTrain.getLeftMotorSpeed() + leftDirection * incrementAmount, driveTrain.getRightMotorSpeed() - rightDirection * incrementAmount);
            }
        }
    }

    @Override
    protected boolean isFinished() {
    	return Math.abs(navX.getAngle() - (startingAngle + angle)%360) <= angleThreshold;
    }

    @Override
    protected void end() {
        driveTrain.stop();
    }

    @Override
    protected void interrupted() {
        driveTrain.stop();
    }
}
