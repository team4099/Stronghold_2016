package org.usfirst.frc.team4099.robot.commands;

import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.lib.util.Util;
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
        this.goingUp = destinationAngle > ramp.getCurrentAngle();
        requires(ramp);
    }

    /**
     * @param angleToSetTo The angle at which to set the ramp to
     * @param maxSpeed The max speed with which to run the motor
     */
    public SetRampAngle(double angleToSetTo, double maxSpeed) {
        this(angleToSetTo);
        this.maxSpeed = Math.abs(maxSpeed);
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {
        if (goingUp)
            ramp.moveUp();
        else
            ramp.moveDown();
    }

    @Override
    protected boolean isFinished() {
        return Util.withinRange(ramp.getCurrentAngle(), destinationAngle, Constants.RAMP_ANGLE_TOLERANCE);
    }

    @Override
    protected void end() {
        if(!goingUp) {
            Scheduler.getInstance().add(new BurstUp());
        }
    }

    @Override
    protected void interrupted() {
        end();
    }
}
