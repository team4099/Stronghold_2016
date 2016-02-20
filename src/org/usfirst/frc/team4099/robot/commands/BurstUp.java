package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class BurstUp extends CommandBase {

    @Override
    protected void initialize() {
        requires(ramp);
        setTimeout(0.15);
    }

    @Override
    protected void execute() {
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
