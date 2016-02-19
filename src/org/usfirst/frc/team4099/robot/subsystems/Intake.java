package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4099.lib.util.Constants;


public class Intake extends Subsystem {
    private Talon intakeMotor;
    private DigitalInput upperLimitSwitch;
    private DigitalInput lowerLimitSwitch;

    public Intake() {
        intakeMotor = new Talon(Constants.INTAKE_MOTOR_PORT);
        upperLimitSwitch = new DigitalInput(Constants.INTAKE_UPPER_LIMIT_SWITCH_PORT);
        lowerLimitSwitch = new DigitalInput(Constants.INTAKE_LOWER_LIMIT_SWITCH_PORT);
    }

    public void setMotorSpeed(double speed) {
        intakeMotor.set(speed);
    }

    public void raiseIntake() {
        intakeMotor.set(0.5);
    }

    public void stopIntake() {
        intakeMotor.set(0);
    }

    public void lowerIntake() {
        intakeMotor.set(-0.05);
    }

    public boolean hasHitUpperLimit() {
        return upperLimitSwitch.get();
    }

    public boolean hasHitLowerLimit() {
        return lowerLimitSwitch.get();
    }

    @Override
    protected void initDefaultCommand() {
    }
}
