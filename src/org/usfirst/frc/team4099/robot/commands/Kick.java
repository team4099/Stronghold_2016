package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class Kick extends CommandBase {

    @Override
    protected void initialize() {
        setTimeout(1.0);
        shooter.kick();
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        shooter.resetKicker();
    }

    @Override
    protected void interrupted() {
        shooter.resetKicker();
    }
}
