package org.usfirst.frc.team4099.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class SetRampAngle extends CommandBase {

    double destinationAngle;
    boolean goingUp;
    double maxSpeed;

    /**
     * @param angleToSetTo The angle at which to set the ramp to
     */
    public SetRampAngle(double angleToSetTo) {
        this.destinationAngle = angleToSetTo;
        this.maxSpeed = 0.5;
        requires(ramp);
    }

    /**
     * @param angleToSetTo The angle at which to set the ramp to
     * @param maxSpeed The max speed with which to run the motor
     */
    public SetRampAngle(double angleToSetTo, double maxSpeed) {
        this.maxSpeed = Math.abs(maxSpeed);
        this.destinationAngle = angleToSetTo;
        requires(ramp);
    }

    @Override
    protected void initialize() {
        this.goingUp = destinationAngle > ramp.getCurrentAngle();
        if(goingUp) ramp.setActuatorMotor(maxSpeed);
        else ramp.setActuatorMotor(-maxSpeed);
    }

    @Override
    protected void execute() {
    	
    }

    @Override
    protected boolean isFinished() {
        if(goingUp) return ramp.getCurrentAngle() >= destinationAngle;
        else return ramp.getCurrentAngle() <= destinationAngle;
    }

    @Override
    protected void end() {
        // If it is going down, apply a quick burst going up to hold it in place (Karl)
        if(!goingUp) {
            ramp.setActuatorMotor(0.5);
            try {
                Thread.sleep(125);  //DANGER DANGER 
                ramp.setActuatorMotor(0);
            } catch (InterruptedException e) {
                ramp.setActuatorMotor(0);
                DriverStation.reportError("ye interrupted my sleep", true);
            }
        }
        ramp.setActuatorMotor(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
