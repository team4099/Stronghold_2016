package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.robot.commands.SetIntakeSpeedManually;

public class Intake extends Subsystem {
    private Talon intakeMotor;

    public Intake() {
        intakeMotor = new Talon(Constants.INTAKE_MOTOR_PORT);
    }

    public void setMotorSpeed(double speed) {
        intakeMotor.set(speed);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new SetIntakeSpeedManually());
    }
}
