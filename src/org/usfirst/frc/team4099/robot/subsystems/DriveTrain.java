package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.robot.commands.JoystickDrive;

public class DriveTrain extends Subsystem {

    private RobotDrive drive;

    private Talon frontLeftMotor, rearLeftMotor;
    private Talon frontRightMotor, rearRightMotor;

    private Timer printTimer;

    private Encoder leftEncoder;
    private Encoder rightEncoder;

    public DriveTrain() {

        frontLeftMotor = new Talon(Constants.FRONT_LEFT_MOTOR_PORT);
        rearLeftMotor = new Talon(Constants.REAR_LEFT_MOTOR_PORT);
        frontRightMotor = new Talon(Constants.FRONT_RIGHT_MOTOR_PORT);
        rearRightMotor = new Talon(Constants.REAR_RIGHT_MOTOR_PORT);

        leftEncoder = new Encoder(Constants.LEFT_ENCODER_CHANNELS[0], Constants.LEFT_ENCODER_CHANNELS[1], true, CounterBase.EncodingType.k4X);
        rightEncoder = new Encoder(Constants.RIGHT_ENCODER_CHANNELS[0], Constants.RIGHT_ENCODER_CHANNELS[1], true, CounterBase.EncodingType.k4X);

        drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

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

//    public void driveWithGamepad(Gamepad gamepad) {
//    	// DEPRECATED
//        double left = gamepad.getLeftVerticalAxis();
//        double right = gamepad.getRightVerticalAxis();
//
//        // deadband modified values
//        double f_left = GamepadUtil.deadband(left);
//        double f_right = GamepadUtil.deadband(right);
//
//        if (printTimer.hasPeriodPassed(1.0))
//            System.out.println("left: " + f_left + "  " + "right: " + f_right);
//
//        // gear modified values
//        double m_left = modifySpeed(f_left);
//        double m_right = modifySpeed(f_right);
//
//        // fix sign (motor direction)
//        m_left = -m_left;
//        m_right = -m_right;
//
//        double rcw = pJoystick->GetTwist();
//        double forwrd = pJoystick->GetY() * -1; /* Invert stick Y axis */
//        double strafe = pJoystick->GetX();
//
//        double pi = Math.PI;
//
//        /* Adjust Joystick X/Y inputs by navX MXP yaw angle */
//
//        double gyro_degrees = CommandBase.navX.getYaw();
//        double gyro_radians = gyro_degrees * pi / 180;
//        double temp = forwrd * Math.cos(gyro_radians) +
//                strafe * Math.sin(gyro_radians);
//        strafe = -forwrd * Math.sin(gyro_radians) +
//                strafe * Math.cos(gyro_radians);
//        fwd = temp;
//        drive.tankDrive(m_left, m_right);
//    }
    
    public void tankDrive(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);
    }

    private double modifySpeed(double speed) {
        boolean leftTriggerPressed = CommandBase.oi.getGamepad0().isLeftTriggerPressed();
        boolean rightTriggerPressed = CommandBase.oi.getGamepad0().isRightTriggerPressed();

        if (leftTriggerPressed && rightTriggerPressed)
            return speed / Constants.FAST_GEAR_REDUCTION_FACTOR;

        return speed / Constants.SLOW_GEAR_REDUCTION_FACTOR;
    }

    public void drive(double leftSpeed, double rightSpeed) {
        frontLeftMotor.set(leftSpeed);
        rearLeftMotor.set(leftSpeed);
        frontRightMotor.set(rightSpeed);
        rearRightMotor.set(rightSpeed);
    }

    public void driveForward() {
        frontLeftMotor.set(0.5);
        rearLeftMotor.set(0.5);
        frontRightMotor.set(0.5);
        rearRightMotor.set(0.5);
    }

    public void driveBackward() {
        frontLeftMotor.set(-0.5);
        rearLeftMotor.set(-0.5);
        frontRightMotor.set(-0.5);
        rearRightMotor.set(-0.5);
    }

    public void turnRight() {
        frontLeftMotor.set(0.5);
        rearLeftMotor.set(0.5);
        frontRightMotor.set(-0.5);
        rearRightMotor.set(-0.5);
    }

    public void turnLeft() {
        frontLeftMotor.set(-0.5);
        rearLeftMotor.set(-0.5);
        frontRightMotor.set(0.5);
        rearRightMotor.set(0.5);
    }

    public void stop() {
        frontLeftMotor.set(0.0);
        rearLeftMotor.set(0.0);
        frontRightMotor.set(0.0);
        rearRightMotor.set(0.0);
    }

    public double getLeftEncoderSpeed() {
        return leftEncoder.getRate();
    }

    public double getRightEncoderSpeed() {
        return rightEncoder.getRate();
    }

    public double getLeftMotorSpeed() {
        return frontLeftMotor.get();
    }

    public double getRightMotorSpeed() {
        return frontRightMotor.get();
    }

}
