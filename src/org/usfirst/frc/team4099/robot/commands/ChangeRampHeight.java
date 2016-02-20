package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.lib.util.RampMoveEnum;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class ChangeRampHeight extends CommandBase {

    private RampMoveEnum dir;

    public ChangeRampHeight(RampMoveEnum direction) {
        dir = direction;
        requires(ramp);
    }

    @Override
    protected void initialize() {
        setTimeout(0.0001);
    }

    @Override
    protected void execute() {
        if (dir == RampMoveEnum.DOWN)
            ramp.moveDown();
        else if (dir == RampMoveEnum.UP)
            ramp.moveUp();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        ramp.stopRamp();
    }

    @Override
    protected void interrupted() {
        ramp.stopRamp();
    }
}

