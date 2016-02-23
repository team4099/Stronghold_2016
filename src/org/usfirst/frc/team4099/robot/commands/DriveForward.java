package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class DriveForward extends CommandBase {

    double timeout;

    public DriveForward() {
        timeout = 0.1;
        requires(driveTrain);
    }

    public DriveForward(double timeout) {
        this.timeout = timeout;
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
        setTimeout(timeout);
    }

    @Override
    protected void execute() {
        driveTrain.driveForward();
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
        end();
    }
}
