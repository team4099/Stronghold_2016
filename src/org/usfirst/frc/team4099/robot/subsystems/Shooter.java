package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.robot.commands.RunShooterSlowly;

public class Shooter extends Subsystem {

    private int LEFT_SHOOTER_PORT, RIGHT_SHOOTER_PORT;
    private Talon LEFT_SHOOTER_MOTOR, RIGHT_SHOOTER_MOTOR;

    /*
    private int KICKER_PORT;
    private Servo KICKER;
    */

    public Shooter() {

        LEFT_SHOOTER_PORT = Constants.LEFT_SHOOTER_MOTOR_PORT;
        RIGHT_SHOOTER_PORT = Constants.RIGHT_SHOOTER_MOTOR_PORT;
        //KICKER_PORT = Constants.KICKER_PORT;

        LEFT_SHOOTER_MOTOR = new Talon(LEFT_SHOOTER_PORT);
        RIGHT_SHOOTER_MOTOR = new Talon(RIGHT_SHOOTER_PORT);

//        KICKER = new Servo(KICKER_PORT);

        LEFT_SHOOTER_MOTOR.setSafetyEnabled(false);
        RIGHT_SHOOTER_MOTOR.setSafetyEnabled(false);

        //resetKicker();
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new RunShooterSlowly());
    }

    public void setMotorSpeed(String motor, double speed) {
    }

    public void runMotorsSlowly() {
        LEFT_SHOOTER_MOTOR.set(-0.2);
        RIGHT_SHOOTER_MOTOR.set(0.2);
    }

    public void runMotorsShootingSpeed() {
        LEFT_SHOOTER_MOTOR.set(0.8);
        RIGHT_SHOOTER_MOTOR.set(-0.8);
    }

    /*
    public void kick() {
        KICKER.setAngle(0);
    }

    public void resetKicker() {
        KICKER.setAngle(110);
    }
    */
}
