package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.robot.commands.ControlIntake;
import org.usfirst.frc.team4099.robot.commands.SetIntakeSpeedManually;


public class Intake extends Subsystem {
    private Talon intakeMotor;
    private DigitalInput upperLimitSwitch;
    private DigitalInput lowerLimitSwitch;

    public Intake() {
        intakeMotor = new Talon(Constants.INTAKE_MOTOR_PORT);
        //upperLimitSwitch = new DigitalInput(Constants.INTAKE_UPPER_LIMIT_SWITCH_PORT);
        //lowerLimitSwitch = new DigitalInput(Constants.INTAKE_LOWER_LIMIT_SWITCH_PORT);
    }

    public void controlManually() {
        double speed = CommandBase.oi.getFlightStick().getYAxisValue();
        if (!hasHitLowerLimit() && !hasHitLowerLimit())
            intakeMotor.set(speed);
        else
            stopIntake();
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
        return false;
//        return upperLimitSwitch.get();
    }

    public boolean hasHitLowerLimit() {
        return false;
//        return lowerLimitSwitch.get();
    }

    @Override
    protected void initDefaultCommand() {
     //   setDefaultCommand(new SetIntakeSpeedManually());
    }
}
