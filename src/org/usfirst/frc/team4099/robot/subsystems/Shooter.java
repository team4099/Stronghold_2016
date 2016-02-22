package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.robot.commands.RunShooterSlowlyBackwards;

public class Shooter extends Subsystem {

    private int LEFT_SHOOTER_PORT, RIGHT_SHOOTER_PORT;
    private Talon LEFT_SHOOTER_MOTOR, RIGHT_SHOOTER_MOTOR;

    public Shooter() {
        LEFT_SHOOTER_PORT = Constants.LEFT_SHOOTER_MOTOR_PORT;
        RIGHT_SHOOTER_PORT = Constants.RIGHT_SHOOTER_MOTOR_PORT;

        LEFT_SHOOTER_MOTOR = new Talon(LEFT_SHOOTER_PORT);
        RIGHT_SHOOTER_MOTOR = new Talon(RIGHT_SHOOTER_PORT);

        LEFT_SHOOTER_MOTOR.setSafetyEnabled(false);
        RIGHT_SHOOTER_MOTOR.setSafetyEnabled(false);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new RunShooterSlowlyBackwards());
    }

    public void runMotorsSlowlyBackwards() {
        LEFT_SHOOTER_MOTOR.set(-0.1);
        RIGHT_SHOOTER_MOTOR.set(0.1);
    }

    public void runMotorsShootingSpeed() {
        LEFT_SHOOTER_MOTOR.set(0.8);
        RIGHT_SHOOTER_MOTOR.set(-0.8);
    }
}
