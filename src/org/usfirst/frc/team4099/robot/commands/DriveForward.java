package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class DriveForward extends CommandBase {

    private double m_speed;
    private double timeout;

    public DriveForward(double speed) {
        m_speed = speed;
        requires(driveTrain);
        this.timeout = 0.1;
    }
    public DriveForward(double speed, double timeout) {
        m_speed = speed;
        requires(driveTrain);
        this.timeout = timeout;
    }

    @Override
    protected void initialize() {
        setTimeout(timeout);
    }

    @Override
    protected void execute() {
        driveTrain.driveForward(m_speed);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
    	driveTrain.stop();
    }

    @Override
    protected void interrupted() {
    }
}
