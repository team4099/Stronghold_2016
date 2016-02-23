package org.usfirst.frc.team4099.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team4099.robot.OI;
import org.usfirst.frc.team4099.robot.Robot;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class IntakeUp extends CommandBase {

    private boolean shouldRun = true;

    public IntakeUp() {
        requires(intake);
    }

    @Override
    protected void initialize() {
        if (ramp.getCurrentAngle() > 10) {
            shouldRun = false;
        }
        setTimeout(1.3);
    }

    @Override
    protected void execute() {
        if (shouldRun)
            intake.setMotorSpeed(-.40);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut() || !shouldRun;
    }

    @Override
    protected void end() {
        intake.setMotorSpeed(.5);
        Scheduler.getInstance().add(new WaitCommand(0.125));
        intake.setMotorSpeed(0);
    }

    @Override
    protected void interrupted() {}
}
