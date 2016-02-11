package org.usfirst.frc.team4099.robot.commands;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4099.robot.OI;
import org.usfirst.frc.team4099.robot.Robot;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class IntakeUp extends CommandBase {
    public IntakeUp() {
        requires(intake);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        intake.moveWithTrigger(oi.getGamepad());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted(){
    }
}
