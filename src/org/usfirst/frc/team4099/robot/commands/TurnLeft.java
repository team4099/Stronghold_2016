package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class TurnLeft extends CommandBase {

    public TurnLeft() {
        requires(driveTrain);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        driveTrain.turnLeft();
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
