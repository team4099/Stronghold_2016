package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class RunShooterFullSpeed extends CommandBase {

    public RunShooterFullSpeed() {
        requires(shooter);
    }

    @Override
    protected void initialize() {
        setTimeout(1.0);
    }

    @Override
    protected void execute() {
        shooter.runMotorsShootingSpeed();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        shooter.stopMotors();
    }

    @Override
    protected void interrupted() {}
}
