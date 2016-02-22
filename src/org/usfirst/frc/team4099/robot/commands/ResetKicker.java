package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class ResetKicker extends CommandBase {

    @Override
    protected void initialize() {
        requires(kicker);
    }

    @Override
    protected void execute() {
        kicker.resetKicker();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {}

    @Override
    protected void interrupted() {}
}
