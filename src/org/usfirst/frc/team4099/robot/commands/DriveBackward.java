package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

/**
 * Created by plato2000 on 2/17/16.
 */
public class DriveBackward extends CommandBase {
    public DriveBackward() {
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
        setTimeout(0.01);
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
    protected void end() {
        driveTrain.stop();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
