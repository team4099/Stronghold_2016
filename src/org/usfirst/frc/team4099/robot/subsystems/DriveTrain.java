package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4099.lib.input.Gamepad;
import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.lib.util.GamepadUtil;
import org.usfirst.frc.team4099.robot.commands.JoystickDrive;

public class DriveTrain extends Subsystem {

    private RobotDrive drive;

    private static double DEADBAND_LIMIT;
    private double SLOW_GEAR_REDUCTION_FACTOR;
    private double MID_GEAR_REDUCTION_FACTOR;
    private double FAST_GEAR_REDUCTION_FACTOR;

    /*
    private Talon frontLeftMotor, rearLeftMotor;
    private Talon frontRightMotor, rearRightMotor;
    */
    private Talon leftMotors, rightMotors;

    public Encoder leftEncoder;
    public Encoder rightEncoder;

    private Timer printTimer;

    private double integralError = 0;
    private double derivError = 0;
    private double lastError = 0;

    private boolean reversed = false;

    public DriveTrain() {
        DEADBAND_LIMIT = Constants.DEADBAND_LIMIT;
        SLOW_GEAR_REDUCTION_FACTOR = Constants.SLOW_GEAR_REDUCTION_FACTOR;
        MID_GEAR_REDUCTION_FACTOR = Constants.MID_GEAR_REDUCTION_FACTOR;
        FAST_GEAR_REDUCTION_FACTOR = Constants.FAST_GEAR_REDUCTION_FACTOR;

        leftMotors = new Talon(Constants.LEFT_MOTORS_PORT);
        rightMotors = new Talon(Constants.RIGHT_MOTORS_PORT);
        /*
        frontLeftMotor = new Talon(Constants.FRONT_LEFT_MOTOR_PORT);
        rearLeftMotor = new Talon(Constants.REAR_LEFT_MOTOR_PORT);
        frontRightMotor = new Talon(Constants.FRONT_RIGHT_MOTOR_PORT);
        rearRightMotor = new Talon(Constants.REAR_RIGHT_MOTOR_PORT);
        */

        leftEncoder = new Encoder(Constants.LEFT_ENCODER_CHANNELS[0], Constants.LEFT_ENCODER_CHANNELS[1], true, CounterBase.EncodingType.k4X);
        rightEncoder = new Encoder(Constants.RIGHT_ENCODER_CHANNELS[0], Constants.RIGHT_ENCODER_CHANNELS[1], true, CounterBase.EncodingType.k4X);
        leftEncoder.setDistancePerPulse(Constants.DISTANCE_PER_PULSE);
        rightEncoder.setDistancePerPulse(Constants.DISTANCE_PER_PULSE);

        drive = new RobotDrive(leftMotors, rightMotors);
//        drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

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

        // gear modified values
        double m_left = modifySpeed(f_left);
        double m_right = modifySpeed(f_right);

        double pi = Math.PI;
        double gyro_angle = CommandBase.navX.getAngle();

        //m_left += gyro_angle * 0.1;//Constants.GYRO_GAIN_LEFT;
        //m_right -= gyro_angle * 0.1;//Constants.GYRO_GAIN_RIGHT;

        if (!isInReverse())
            drive.tankDrive(m_left, m_right);
        else
            drive.tankDrive(-m_right, -m_left);
    }
    
    public void arcadeDrive(Gamepad gamepad) {
    	drive.arcadeDrive(GamepadUtil.deadband(gamepad.getLeftVerticalAxis()) / 1.5, -0.2 * GamepadUtil.deadband(gamepad.getLeftHorizontalAxis()));
    }

    public boolean isInReverse() {
        return reversed;
    }

    private double modifySpeed(double speed) {
        boolean leftTriggerPressed = CommandBase.oi.getGamepad().isLeftTriggerPressed();
        boolean rightTriggerPressed = CommandBase.oi.getGamepad().isRightTriggerPressed();

        int gearMode = 1;

        if (leftTriggerPressed)
            gearMode++;
        if (rightTriggerPressed)
            gearMode++;

        if (gearMode == 0)
            return speed / SLOW_GEAR_REDUCTION_FACTOR;
        else if (gearMode == 1)
            return speed / MID_GEAR_REDUCTION_FACTOR;
        else
            return speed / FAST_GEAR_REDUCTION_FACTOR;
    }

    public void drive(double leftSpeed, double rightSpeed) {
        leftMotors.set(leftSpeed);
        rightMotors.set(rightSpeed);
    }

    public void driveForward(double speed) {
        drive.tankDrive(speed, speed + .07);
    }

    public void driveBackward(double speed) {
        drive.tankDrive(-speed, -speed);
    }

    public void turnRight(double speed) {
        drive.tankDrive(speed, -speed);
    }

    public void turnLeft(double speed) {
        drive.tankDrive(-speed, speed);
    }

    public void stop() {
        drive.tankDrive(0.0, 0.0);
    }

    public double getLeftEncoderSpeed() {
        return leftEncoder.getRate();
    }

    /**
     * Gets the motor speed as reported by the encoder
     * @return The speed returned by the right gearbox encoder
     */
    public double getRightEncoderSpeed() {
        return rightEncoder.getRate();
    }

    public double getLeftMotorSpeed() {
        return leftMotors.get();
    }

    public double getRightMotorSpeed() {
        return rightMotors.get();
    }

    public void resetDistance() {
        rightEncoder.reset();
        leftEncoder.reset();
        integralError = 0;
        derivError = 0;
        lastError = 0;
    }

    public double getDistanceTravelled() {
        return (rightEncoder.getDistance() + leftEncoder.getDistance()) / 2.0;
    }

    public void driveDistance(double distance) {
        resetDistance();

        double error = distance - getDistanceTravelled();
        derivError = error - lastError;

        double K_p = Constants.DRIVE_GAIN_KP;
        double K_i = Constants.DRIVE_GAIN_KI;
        double K_d = Constants.DRIVE_GAIN_KD;

        double output = K_p * error + K_i * integralError + K_d * derivError;

        drive.tankDrive(output, output);

        lastError = error;
        integralError += error;
    }
}
