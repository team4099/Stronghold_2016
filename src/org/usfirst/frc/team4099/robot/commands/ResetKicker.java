package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class ResetKicker extends CommandBase {

    public ResetKicker() {
        requires(kicker);
    }

    @Override
    protected void initialize() {

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
