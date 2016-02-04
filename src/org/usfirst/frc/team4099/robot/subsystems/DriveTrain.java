package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4099.lib.input.Gamepad;
import org.usfirst.frc.team4099.lib.util.GamepadUtil;
import org.usfirst.frc.team4099.robot.commands.JoystickDrive;

public class DriveTrain extends Subsystem {

    private RobotDrive drive;
    private Motors motors;

    private static double DEADBAND_LIMIT;
    private double SLOW_GEAR_REDUCTION_FACTOR;
    private double FAST_GEAR_REDUCTION_FACTOR;

    private int FRONT_LEFT_MOTOR_PORT, REAR_LEFT_MOTOR_PORT;
    private int FRONT_RIGHT_MOTOR_PORT, REAR_RIGHT_MOTOR_PORT;

    private Talon FRONT_LEFT_MOTOR, REAR_LEFT_MOTOR;
    private Talon FRONT_RIGHT_MOTOR, REAR_RIGHT_MOTOR;

    public DriveTrain() {
        DEADBAND_LIMIT = CommandBase.constants.getDouble("DEADBAND_LIMIT");
        SLOW_GEAR_REDUCTION_FACTOR = CommandBase.constants.getDouble("SLOW_GEAR_REDUCTION_FACTOR");
        FAST_GEAR_REDUCTION_FACTOR = CommandBase.constants.getDouble("FAST_GEAR_REDUCTION_FACTOR");

        FRONT_LEFT_MOTOR_PORT = CommandBase.constants.getInteger("FRONT_LEFT_MOTOR_PORT");
        REAR_LEFT_MOTOR_PORT = CommandBase.constants.getInteger("REAR_LEFT_MOTOR_PORT");
        FRONT_RIGHT_MOTOR_PORT = CommandBase.constants.getInteger("FRONT_RIGHT_MOTOR_PORT");
        REAR_RIGHT_MOTOR_PORT = CommandBase.constants.getInteger("REAR_RIGHT_MOTOR_PORT");

        

//        FRONT_LEFT_MOTOR = new Talon(FRONT_LEFT_MOTOR_PORT);
//        REAR_LEFT_MOTOR = new Talon(REAR_LEFT_MOTOR_PORT);
//        FRONT_RIGHT_MOTOR = new Talon(FRONT_RIGHT_MOTOR_PORT);
//        REAR_RIGHT_MOTOR = new Talon(REAR_RIGHT_MOTOR_PORT);
        FAST_GEAR_REDUCTION_FACTOR = 1.05;
        SLOW_GEAR_REDUCTION_FACTOR = 1.05;
        FRONT_LEFT_MOTOR = 6;
        REAR_LEFT_MOTOR = 8;
        FRONT_RIGHT_MOTOR = 7;
        REAR_RIGHT_MOTOR = 9;

        motors = new Motors();
        motors.addMotor("FRONT_LEFT_MOTOR", FRONT_LEFT_MOTOR);
        motors.addMotor("REAR_LEFT_MOTOR", REAR_LEFT_MOTOR);
        motors.addMotor("FRONT_RIGHT_MOTOR", FRONT_RIGHT_MOTOR);
        motors.addMotor("REAR_RIGHT_MOTOR", REAR_RIGHT_MOTOR);

        drive = new RobotDrive(FRONT_LEFT_MOTOR, REAR_LEFT_MOTOR, FRONT_RIGHT_MOTOR, REAR_RIGHT_MOTOR);
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

        System.out.println("left: " + f_left + "  " + "right: " + f_right);

        // gear modified values
        double m_left = modifySpeed(f_left);
        double m_right = modifySpeed(f_right);

        // fix sign (motor direction)
        m_left = m_left;
        m_right = m_right;

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
        motors.setMotorSpeed("FRONT_LEFT_MOTOR", 0.5);
        motors.setMotorSpeed("REAR_LEFT_MOTOR", 0.5);
        motors.setMotorSpeed("FRONT_RIGHT_MOTOR", 0.5);
        motors.setMotorSpeed("REAR_RIGHT_MOTOR", 0.5);
    }
    public void driveBackward() {
        motors.setMotorSpeed("FRONT_LEFT_MOTOR", -0.5);
        motors.setMotorSpeed("REAR_LEFT_MOTOR", -0.5);
        motors.setMotorSpeed("FRONT_RIGHT_MOTOR", -0.5);
        motors.setMotorSpeed("REAR_RIGHT_MOTOR", -0.5);
    }
    public void turnRight() {
        motors.setMotorSpeed("FRONT_LEFT_MOTOR", 0.5);
        motors.setMotorSpeed("REAR_LEFT_MOTOR", 0.5);
        motors.setMotorSpeed("FRONT_RIGHT_MOTOR", -0.5);
        motors.setMotorSpeed("REAR_RIGHT_MOTOR", -0.5);
    }
    public void turnLeft() {
        motors.setMotorSpeed("FRONT_LEFT_MOTOR", -0.5);
        motors.setMotorSpeed("REAR_LEFT_MOTOR", -0.5);
        motors.setMotorSpeed("FRONT_RIGHT_MOTOR", 0.5);
        motors.setMotorSpeed("REAR_RIGHT_MOTOR", 0.5);
    }

    public void setMotorSpeed(String motor, double speed) {
        motors.setMotorSpeed(motor, speed);
    }
}
