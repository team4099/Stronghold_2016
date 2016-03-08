package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.robot.commands.ControlIntake;
import org.usfirst.frc.team4099.robot.commands.SetIntakeSpeedManually;


public class Intake extends Subsystem {
    private Talon intakeArm;
    private Talon intakeMotor;
    private DigitalInput upperLimitSwitch;
    private DigitalInput lowerLimitSwitch;

    public Intake() {
        intakeArm = new Talon(Constants.INTAKE_ARM_PORT);
        intakeMotor = new Talon(Constants.INTAKE_MOTOR_PORT);
//        intakeMotor.set(0.25);
    }

    public void controlManually() {
        double speed = CommandBase.oi.getAttack3().getYAxisValue();
        if (!hasHitLowerLimit() && !hasHitLowerLimit())
            intakeArm.set(speed);
        else
            stopIntake();
    }

    public void setMotorSpeed(double speed) {
        intakeArm.set(speed);
    }

    public void raiseIntake() {
        intakeArm.set(0.5);
    }

    public void stopIntake() {
        intakeArm.set(0);
    }

    public void lowerIntake() {
        intakeArm.set(-0.05);
    }

    public boolean hasHitUpperLimit() {
        return false;
//        return upperLimitSwitch.get();
    }

    public boolean hasHitLowerLimit() {
        return false;
//        return lowerLimitSwitch.get();
    }

    @Override
    protected void initDefaultCommand() {
//        setDefaultCommand(new SetIntakeSpeedManually());
    }
}
