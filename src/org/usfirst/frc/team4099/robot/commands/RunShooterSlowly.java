package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class RunShooterSlowly extends CommandBase {

    public RunShooterSlowly() {
        requires(shooter);
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {
        shooter.runMotorsSlowly();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {}

    @Override
    protected void interrupted() {}
}
