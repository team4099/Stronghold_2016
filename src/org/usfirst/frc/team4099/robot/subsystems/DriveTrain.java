package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4099.lib.input.Gamepad;
import org.usfirst.frc.team4099.lib.util.ConstantsBase;
import org.usfirst.frc.team4099.robot.RobotMap;
import org.usfirst.frc.team4099.robot.commands.JoystickDrive;

public class DriveTrain extends Subsystem {

    private RobotDrive drive;
    private int FRONT_LEFT_MOTOR, REAR_LEFT_MOTOR;
    private int FRONT_RIGHT_MOTOR, REAR_RIGHT_MOTOR;

    public DriveTrain() {
        FRONT_LEFT_MOTOR = CommandBase.constants.getInteger("FRONT_LEFT_MOTOR");
        REAR_LEFT_MOTOR = CommandBase.constants.getInteger("REAR_LEFT_MOTOR");
        FRONT_RIGHT_MOTOR = CommandBase.constants.getInteger("FRONT_RIGHT_MOTOR");
        REAR_RIGHT_MOTOR = CommandBase.constants.getInteger("REAR_RIGHT_MOTOR");
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
        //double vertAxisLeft = gamepad.getLeftVerticalAxis();
        //double horiAxisLeft = gamepad.getLeftHorizontalAxis();
        //motors.setMotorSpeed("FRONT_LEFT", 0.5);
        drive.tankDrive(gamepad, Gamepad.LEFT_Y_AXIS, gamepad, Gamepad.RIGHT_Y_AXIS);
    }
}
