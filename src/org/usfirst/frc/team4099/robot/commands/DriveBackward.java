package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class DriveBackward extends CommandBase {

    private double m_speed;
    public DriveBackward(double speed) {
        m_speed = speed;
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
        setTimeout(0.1);
    }

    @Override
    protected void execute() {
        driveTrain.driveBackward(m_speed);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
