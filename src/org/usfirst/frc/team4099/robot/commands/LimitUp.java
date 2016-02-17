package org.usfirst.frc.team4099.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4099.robot.OI;
import org.usfirst.frc.team4099.robot.Robot;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class LimitUp extends CommandBase {
    public LimitUp() {
        requires(intake);
    }

    @Override
    protected void initialize() {
        //setTimeout(0.9);
    }

    @Override
    protected void execute() {
    	if (!limitSwitch.get()) {
    		intake.setMotorSpeed(-.5);
    		Timer.delay(.9)
    	} else {
    		intake.setMotorSpeed(0);
    		Timer.delay(.9)
    	}
        
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        intake.setMotorSpeed(0.5);
        Timer.delay(0.1);
        intake.setMotorSpeed(0);
    }

    @Override
    protected void interrupted(){
    }
}
