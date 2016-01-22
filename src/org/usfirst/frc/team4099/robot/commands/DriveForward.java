package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class DriveForward extends CommandBase {

    private double m_timeout;

    public DriveForward(double time) {
        m_timeout = time;
    }

    @Override
    protected void initialize() {
        setTimeout(m_timeout);
        //requires(driveTrain);
    }

    @Override
    protected void execute() {
        //driveTrain.driveForward();
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
