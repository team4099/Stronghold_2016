package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class RunShooterFullSpeed extends CommandBase {

    public RunShooterFullSpeed() {
        requires(shooter);
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {
        shooter.runMotorsShootingSpeed();
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
