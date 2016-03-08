package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class ReverseOrientation extends CommandBase {
    public ReverseOrientation() {
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
        driveTrain.reverse();
    }

    @Override
    protected void execute() {
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
