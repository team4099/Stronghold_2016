package org.usfirst.frc.team4099.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team4099.robot.OI;
import org.usfirst.frc.team4099.robot.Robot;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class IntakeDown extends CommandBase {

    public IntakeDown() {
        requires(intake);
    }

    @Override
    protected void initialize() {
        setTimeout(1.3);
    }

    @Override
    protected void execute() {
        intake.setMotorSpeed(.10);
    }

    @Override
    protected boolean isFinished() {
        return intake.hasHitLowerLimit() || isTimedOut();
    }

    @Override
    protected void end() {
        intake.setMotorSpeed(0);
    }

    @Override
    protected void interrupted() {}
}
