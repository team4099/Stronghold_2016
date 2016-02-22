package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class RunShooterFullSpeed extends CommandBase {

    private double m_timeout;
    public RunShooterFullSpeed(double timeout) {
        m_timeout = timeout;
        requires(shooter);
    }

    @Override
    protected void initialize() {
        setTimeout(m_timeout);
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
