package org.usfirst.frc.team4099.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4099.robot.commands.DriveBackward;
import org.usfirst.frc.team4099.robot.commands.DriveForward;
import org.usfirst.frc.team4099.robot.commands.groups.TestCommandGroup;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;
import org.usfirst.frc.team4099.robot.subsystems.TurnLeft;
import org.usfirst.frc.team4099.robot.subsystems.TurnRight;

import com.kauailabs.navx.frc.AHRS;


public class Robot extends IterativeRobot {

    Command autonomousCommand;

    @Override
    public void robotInit() {
        CommandBase.init();

//      	SmartDashboard.putData("DriveForward", new DriveForward(5));
//    	SmartDashboard.putData("DriveBackward", new DriveBackward(5));
//    	SmartDashboard.putData("TurnRight", new TurnRight(5));
//    	SmartDashboard.putData("TurnLeft", new TurnLeft(5));
        autonomousCommand = new TestCommandGroup();
    }
	
    public void disabledInit(){
        CommandBase.driveTrain.setSafety(true);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        CommandBase.driveTrain.setSafety(false);
        autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        CommandBase.driveTrain.setSafety(false);
        // cancel any current autonomous
        if (autonomousCommand != null) autonomousCommand.cancel();

    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();

        /* Calibrate DriveTrain motors */
//        CommandBase.driveTrain.setMotorSpeed("FRONT_LEFT_MOTOR",
//                DriveTrain.deadband(CommandBase.oi.getGamepad().getLeftVerticalAxis()));
//        CommandBase.driveTrain.setMotorSpeed("FRONT_RIGHT_MOTOR",
//                DriveTrain.deadband(CommandBase.oi.getGamepad().getLeftVerticalAxis()));
//        CommandBase.driveTrain.setMotorSpeed("REAR_LEFT_MOTOR",
//                DriveTrain.deadband(CommandBase.oi.getGamepad().getLeftVerticalAxis()));
//        CommandBase.driveTrain.setMotorSpeed("REAR_RIGHT_MOTOR",
//                DriveTrain.deadband(CommandBase.oi.getGamepad().getLeftVerticalAxis()));

        /* Calibrate shooter motors */
//        CommandBase.shooter.setMotorSpeed("LEFT_SHOOTER_MOTOR",
//                GamepadUtil.deadband(CommandBase.oi.getGamepad().getLeftVerticalAxis()));
//        CommandBase.shooter.setMotorSpeed("RIGHT_SHOOTER_MOTOR",
//                GamepadUtil.deadband(CommandBase.oi.getGamepad().getLeftVerticalAxis()));
    }
}
