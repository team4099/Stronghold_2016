package org.usfirst.frc.team4099.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team4099.robot.OI;
import org.usfirst.frc.team4099.robot.Robot;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class IntakeUp extends CommandBase {
    public IntakeUp() {
        requires(intake);
    }

    @Override
    protected void initialize() {
        setTimeout(1.3);
//        setTimeout(5.0);
    }

    @Override
    protected void execute() {
        intake.setMotorSpeed(-.40);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        intake.setMotorSpeed(.5);
        Timer.delay(.125);
        intake.setMotorSpeed(0);
    }

    @Override
    protected void interrupted(){
    }
}
