package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class Kick extends CommandBase {
    public Kick() {
        requires(kicker);
    }

    @Override
    protected void initialize() {
        setTimeout(1.0);
        kicker.kick();
    }

    @Override
    protected void execute() {}

    @Override
    protected boolean isFinished() {
        return Constants.abort || isTimedOut();
    }

    @Override
    protected void end() {
    	Constants.abort = false;
        kicker.resetKicker();
    }

    @Override
    protected void interrupted() {
        kicker.resetKicker();
    }
}
