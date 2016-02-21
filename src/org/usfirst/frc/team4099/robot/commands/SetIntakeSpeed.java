package org.usfirst.frc.team4099.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class SetIntakeSpeed extends CommandBase {

    private double speed;

    public SetIntakeSpeed(double speed) {
        requires(intake);
        this.speed = speed;
    }

    @Override
    protected void initialize() {
        setTimeout(0.001);
//        setTimeout(5.0);
    }

    @Override
    protected void execute() {
        intake.setMotorSpeed(speed);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
//        intake.setMotorSpeed(.5);
//        Timer.delay(.125);
        intake.setMotorSpeed(0);
    }

    @Override
    protected void interrupted(){
    }
}
