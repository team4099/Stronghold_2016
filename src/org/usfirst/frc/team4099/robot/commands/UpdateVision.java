package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class UpdateVision extends CommandBase {
    public UpdateVision() {
        requires(vision);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        vision.updateVisionData();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
