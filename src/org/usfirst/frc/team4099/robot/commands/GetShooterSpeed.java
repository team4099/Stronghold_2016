package org.usfirst.frc.team4099.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4099.robot.OI;
import org.usfirst.frc.team4099.robot.Robot;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class GetShooterSpeed extends CommandBase {
	private int count = 0;
    public GetShooterSpeed() {
        requires(shooter);
    }

    @Override
    protected void initialize() {
        setTimeout(2);
    }

    @Override
    protected void execute() {
        if (photoInterrupter.get()) {
        	count++;
        }
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        return (count*120);
    }

    @Override
    protected void interrupted(){
    }
}
