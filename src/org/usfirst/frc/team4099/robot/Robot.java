package org.usfirst.frc.team4099.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team4099.robot.commands.GamepadDrive;
import org.usfirst.frc.team4099.robot.commands.groups.TestCommandGroup;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;



public class Robot extends IterativeRobot {

    Command autonomousCommand;
    Command gamepadDrive;

    @Override
    public void robotInit() {
        DriverStation.reportError("In robotInit()", true);
        CommandBase.init();

//      	SmartDashboard.putData("DriveForward", new DriveForward(5));
//    	SmartDashboard.putData("DriveBackward", new DriveBackward(5));
//    	SmartDashboard.putData("TurnRight", new TurnRight(5));
//    	SmartDashboard.putData("TurnLeft", new TurnLeft(5));
        autonomousCommand = new TestCommandGroup();
    }

    @Override
    public void disabledInit(){
        CommandBase.driveTrain.setSafety(true);
    }

    @Override
	public void disabledPeriodic() {
//		Scheduler.getInstance().run();
	}

    @Override
    public void autonomousInit() {
        CommandBase.driveTrain.setSafety(false);
        autonomousCommand.start();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        CommandBase.driveTrain.setSafety(false);
        // cancel any current autonomous
        if (autonomousCommand != null) autonomousCommand.cancel();
        gamepadDrive = new GamepadDrive();
    }

    @Override
    public void teleopPeriodic() {
        gamepadDrive.start();
    }

    @Override
    public void testInit() {

    }

    @Override
    public void testPeriodic() {
        LiveWindow.run();

        /* Calibrate DriveTrain motors */
//        CommandBase.driveTrain.setMotorSpeed("FRONT_LEFT_MOTOR",
//                DriveTrain.deadband(CommandBase.oi.getGamepad0().getLeftVerticalAxis()));
//        CommandBase.driveTrain.setMotorSpeed("FRONT_RIGHT_MOTOR",
//                DriveTrain.deadband(CommandBase.oi.getGamepad0().getLeftVerticalAxis()));
//        CommandBase.driveTrain.setMotorSpeed("REAR_LEFT_MOTOR",
//                DriveTrain.deadband(CommandBase.oi.getGamepad0().getLeftVerticalAxis()));
//        CommandBase.driveTrain.setMotorSpeed("REAR_RIGHT_MOTOR",
//                DriveTrain.deadband(CommandBase.oi.getGamepad0().getLeftVerticalAxis()));

        /* Calibrate shooter motors */
//        CommandBase.shooter.setMotorSpeed("LEFT_SHOOTER_MOTOR",
//                GamepadUtil.deadband(CommandBase.oi.getGamepad0().getLeftVerticalAxis()));
//        CommandBase.shooter.setMotorSpeed("RIGHT_SHOOTER_MOTOR",
//                GamepadUtil.deadband(CommandBase.oi.getGamepad0().getLeftVerticalAxis()));
    }
}
