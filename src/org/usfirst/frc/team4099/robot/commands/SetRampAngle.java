package org.usfirst.frc.team4099.robot.commands;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.lib.util.Direction;
import org.usfirst.frc.team4099.lib.util.Util;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class SetRampAngle extends CommandBase {
    double destinationAngle;
    boolean goingUp;
    double maxSpeed;
    boolean aimassist = false;

    /*
     * Grabbing vision data
     */
    public SetRampAngle() {
        this.maxSpeed = 0.5;
        requires(ramp);
    }
    public SetRampAngle(boolean aimAssist) {
        this(0);
        this.aimassist = aimassist;
    }

    /**
     * @param angleToSetTo The angle at which to set the ramp to
     */
    public SetRampAngle(double angleToSetTo) {
        this.destinationAngle = angleToSetTo;
        this.maxSpeed = 0.5;
        this.goingUp = destinationAngle > ramp.getCurrentAngle();
        requires(ramp);
    }

    /**
     * @param angleToSetTo The angle at which to set the ramp to
     * @param maxSpeed The max speed with which to run the motor
     */
    public SetRampAngle(double angleToSetTo, double maxSpeed) {
        this(angleToSetTo);
        if (aimassist) {
            this.destinationAngle = ramp.getCurrentAngle() + CommandBase.vision.getVerticalAngle();
        }
        this.maxSpeed = Math.abs(maxSpeed);
    }

    @Override
    protected void initialize() {
        if (aimassist) {
            setTimeout(14); //timeout intended for auto mode
        	this.destinationAngle = ramp.getCurrentAngle() + CommandBase.vision.getVerticalAngle();
        }
        this.goingUp = destinationAngle > ramp.getCurrentAngle();
        
    }

    @Override
    protected void execute() {
        System.out.println("Ramp Angle: " +  ramp.getCurrentAngle() + " Dest: " + destinationAngle);


        if (goingUp)
            ramp.setMotorSpeed(1.0);
        else
            ramp.setMotorSpeed(-1.0);
    }
    
    private boolean isTooFar() {
        if (goingUp) {
            if (ramp.getCurrentAngle() < Constants.RAMP_UPPER_LIMIT)
                return false;
        } else {
            if (ramp.getCurrentAngle() > Constants.RAMP_LOWER_LIMIT)
                return false;
        }

        return true;
    }
    
    private boolean reachedAngle() {
    	if (goingUp) {
    		return ramp.getCurrentAngle() > destinationAngle;
    	} else {
    		return ramp.getCurrentAngle() < destinationAngle;
    	}
    }

    @Override
    protected boolean isFinished() {
        //return Util.withinRange(ramp.getCurrentAngle(), destinationAngle, Constants.RAMP_ANGLE_TOLERANCE);
    	
    	if (isTimedOut()) {
    		Constants.abort = true;
    	}
    	
    	return Constants.abort ||reachedAngle() || isTooFar();
    }

    @Override
    protected void end() {/*
        if(!goingUp) {
            Scheduler.getInstance().add(new BurstUp());
        }*/
        ramp.setMotorSpeed(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
