package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.lib.util.RampMoveEnum;
import org.usfirst.frc.team4099.lib.util.Util;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class SetRampAngle extends CommandBase {

    double destinationAngle;
    RampMoveEnum direction;
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
        if (destinationAngle > ramp.getCurrentAngle())
            direction = RampMoveEnum.UP;
        else
            direction = RampMoveEnum.DOWN;
    }

    @Override
    protected void execute() {
        if (direction == RampMoveEnum.DOWN) {
            ramp.moveDown();
        } else {
            ramp.moveUp();
        }
    }

    @Override
    protected boolean isFinished() {
        return Util.withinRange(ramp.getCurrentAngle(), destinationAngle, Constants.RAMP_ANGLE_TOLERANCE);
    }

    @Override
    protected void end() {
        if (direction == RampMoveEnum.DOWN)
            ramp.burstUp();
        else
            ramp.stopRamp();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
