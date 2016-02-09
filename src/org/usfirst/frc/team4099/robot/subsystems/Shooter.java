package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.robot.commands.RunShooterSlowly;

public class Shooter extends Subsystem {

    private Motors motors;
    private int LEFT_SHOOTER_PORT, RIGHT_SHOOTER_PORT;
    private Talon LEFT_SHOOTER_MOTOR, RIGHT_SHOOTER_MOTOR;

    public Shooter() {
        motors = new Motors();

        LEFT_SHOOTER_PORT = Constants.LEFT_SHOOTER_MOTOR_PORT;
        RIGHT_SHOOTER_PORT = Constants.RIGHT_SHOOTER_MOTOR_PORT;

        LEFT_SHOOTER_MOTOR = new Talon(LEFT_SHOOTER_PORT);
        RIGHT_SHOOTER_MOTOR = new Talon(RIGHT_SHOOTER_PORT);

        motors.addMotor("LEFT_SHOOTER_MOTOR", LEFT_SHOOTER_MOTOR);
        motors.addMotor("RIGHT_SHOOTER_MOTOR", RIGHT_SHOOTER_MOTOR);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new RunShooterSlowly());
    }

    public void setMotorSpeed(String motor, double speed) {
        motors.setMotorSpeed(motor, speed);
    }

    public void runMotorsSlowly() {
        setMotorSpeed("LEFT_SHOOTER_MOTOR", 0.2);
        setMotorSpeed("RIGHT_SHOOTER_MOTOR", 0.2);
    }

    public void runMotorsShootingSpeed() {
        setMotorSpeed("LEFT_SHOOTER_MOTOR", 1.0);
        setMotorSpeed("RIGHT_SHOOTER_MOTOR", 1.0);
    }
}
