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
        setTimeout(0.02);
    }

    @Override
    protected void execute() {
        if (dir == RampMoveEnum.DOWN)
            ramp.setMotorSpeed(1.0);
        else if (dir == RampMoveEnum.UP)
            ramp.setMotorSpeed(-1.0);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        ramp.setMotorSpeed(0);
    }

    @Override
    protected void interrupted() {
        ramp.setMotorSpeed(0);
    }
}

