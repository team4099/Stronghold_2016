package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class DriveBackward extends CommandBase {
	private double m_timeout;

    public DriveBackward(double time) {
        m_timeout = time;
    }

    @Override
    protected void initialize() {
        setTimeout(m_timeout);
        requires(driveTrain);
    }

    @Override
    protected void execute() {
        driveTrain.driveBackward();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {}

    @Override
    protected void interrupted() {}
}
