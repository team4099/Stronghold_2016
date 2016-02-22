package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class RunShooterSlowlyBackwards extends CommandBase {

    public RunShooterSlowlyBackwards() {
        requires(shooter);
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {
        shooter.runMotorsSlowlyBackwards();
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
