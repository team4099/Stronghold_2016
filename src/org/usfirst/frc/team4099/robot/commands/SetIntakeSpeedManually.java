package org.usfirst.frc.team4099.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team4099.lib.input.Attack3;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class SetIntakeSpeedManually extends CommandBase {

    public SetIntakeSpeedManually() {
        requires(intake);
    }

    @Override
    protected void initialize() {
        setTimeout(0.001);
    }

    @Override
    protected void execute() {
        intake.controlManually();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        intake.setMotorSpeed(0);
    }

    @Override
    protected void interrupted(){
        intake.setMotorSpeed(0);
    }
}
