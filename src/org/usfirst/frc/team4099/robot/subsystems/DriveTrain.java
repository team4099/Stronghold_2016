package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4099.lib.input.Gamepad;
import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.lib.util.GamepadUtil;
import org.usfirst.frc.team4099.robot.commands.JoystickDrive;

public class DriveTrain extends Subsystem {

    private RobotDrive drive;

    private static double DEADBAND_LIMIT;
    private double SLOW_GEAR_REDUCTION_FACTOR;
    private double FAST_GEAR_REDUCTION_FACTOR;

    private int FRONT_LEFT_MOTOR_PORT, REAR_LEFT_MOTOR_PORT;
    private int FRONT_RIGHT_MOTOR_PORT, REAR_RIGHT_MOTOR_PORT;

    private Talon FRONT_LEFT_MOTOR, REAR_LEFT_MOTOR;
    private Talon FRONT_RIGHT_MOTOR, REAR_RIGHT_MOTOR;

    private Timer printTimer;

    public DriveTrain() {
        DEADBAND_LIMIT = Constants.DEADBAND_LIMIT;
        SLOW_GEAR_REDUCTION_FACTOR = Constants.SLOW_GEAR_REDUCTION_FACTOR;
        FAST_GEAR_REDUCTION_FACTOR = Constants.FAST_GEAR_REDUCTION_FACTOR;

        FRONT_LEFT_MOTOR_PORT = Constants.FRONT_LEFT_MOTOR_PORT;
        REAR_LEFT_MOTOR_PORT = Constants.REAR_LEFT_MOTOR_PORT;
        FRONT_RIGHT_MOTOR_PORT = Constants.FRONT_RIGHT_MOTOR_PORT;
        REAR_RIGHT_MOTOR_PORT = Constants.REAR_RIGHT_MOTOR_PORT;

        FRONT_LEFT_MOTOR = new Talon(FRONT_LEFT_MOTOR_PORT);
        REAR_LEFT_MOTOR = new Talon(REAR_LEFT_MOTOR_PORT);
        FRONT_RIGHT_MOTOR = new Talon(FRONT_RIGHT_MOTOR_PORT);
        REAR_RIGHT_MOTOR = new Talon(REAR_RIGHT_MOTOR_PORT);

        drive = new RobotDrive(FRONT_LEFT_MOTOR, REAR_LEFT_MOTOR, FRONT_RIGHT_MOTOR, REAR_RIGHT_MOTOR);

        printTimer = new Timer();
        printTimer.start();
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }

    public void setSafety(boolean safety) {
        drive.setSafetyEnabled(safety);
    }

    public void driveWithGamepad(Gamepad gamepad) {
        double left = gamepad.getLeftVerticalAxis();
        double right = gamepad.getRightVerticalAxis();

        // deadband modified values
        double f_left = GamepadUtil.deadband(left);
        double f_right = GamepadUtil.deadband(right);

        if (printTimer.hasPeriodPassed(1.0))
            System.out.println("left: " + f_left + "  " + "right: " + f_right);

        // gear modified values
        double m_left = modifySpeed(f_left);
        double m_right = modifySpeed(f_right);

        // fix sign (motor direction)
        m_left = -m_left;
        m_right = -m_right;

        /*
        double pi = Math.PI;
        double gyro_angle = CommandBase.navX.getAngle();

        m_left += gyro_angle * Constants.GYRO_GAIN_LEFT;
        m_right -= gyro_angle * Constants.GYRO_GAIN_RIGHT;
        */

        drive.tankDrive(m_left, m_right);
    }

    private double modifySpeed(double speed) {
        boolean leftTriggerPressed = CommandBase.oi.getGamepad().isLeftTriggerPressed();
        boolean rightTriggerPressed = CommandBase.oi.getGamepad().isRightTriggerPressed();

        if (leftTriggerPressed && rightTriggerPressed)
            return speed / FAST_GEAR_REDUCTION_FACTOR;

        return speed / SLOW_GEAR_REDUCTION_FACTOR;
    }

    public void driveForward() {
        FRONT_LEFT_MOTOR.set(1.0);
        FRONT_RIGHT_MOTOR.set(1.0);
        REAR_LEFT_MOTOR.set(1.0);
        REAR_RIGHT_MOTOR.set(1.0);
    }
}
