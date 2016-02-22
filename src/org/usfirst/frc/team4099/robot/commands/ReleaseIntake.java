package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class ReleaseIntake extends CommandBase {
    @Override
    protected void initialize() {
        requires(intake);
    }

    @Override
    protected void execute() {
        intake.lowerIntake();
    }

    @Override
    protected boolean isFinished() {
        return intake.hasHitLowerLimit();
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
