package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.lib.util.Direction;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class ControlIntake extends CommandBase {

    private Direction direction;

    public ControlIntake(Direction direction) {
        this.direction = direction;
    }

    @Override
    protected void initialize() {
        setTimeout(0.001);
        requires(intake);
    }

    @Override
    protected void execute() {
        if (direction == Direction.UP) // go up
            intake.raiseIntake();
        else
            intake.lowerIntake();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        intake.stopIntake();
    }

    @Override
    protected void interrupted() {
        intake.stopIntake();
    }
}
