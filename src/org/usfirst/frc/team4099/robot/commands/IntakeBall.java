package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

// TODO: ignore command if the ramp is in an invalid position

public class IntakeBall extends CommandBase {

    @Override
    protected void initialize() {
        requires(intake);
    }

    @Override
    protected void execute() {
        intake.raiseIntake();
    }

    @Override
    protected boolean isFinished() {
        return intake.hasHitUpperLimit();
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
