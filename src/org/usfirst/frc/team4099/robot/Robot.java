package org.usfirst.frc.team4099.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.robot.commands.*;
import org.usfirst.frc.team4099.robot.commands.groups.AutonomousPls;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class Robot extends IterativeRobot {

    Command autonomousCommand;

    @Override
    public void robotInit() {
        CommandBase.init();
        autonomousCommand = new AutonomousPls();
    }

    public void resetValues() {
        CommandBase.driveTrain.resetDistance();
    }

    public void disabledInit(){
        resetValues();
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
    	//Constants.abort = false; //resets auto mode abort setting
        CommandBase.driveTrain.setSafety(false);
        // cancel any current autonomous
        if (autonomousCommand != null) autonomousCommand.cancel();

        CommandBase.navX.reset();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("gyro angle", CommandBase.navX.getAngle());
        SmartDashboard.putNumber("right encoder", CommandBase.driveTrain.rightEncoder.get());
        SmartDashboard.putNumber("left encoder", CommandBase.driveTrain.leftEncoder.get());
        SmartDashboard.putNumber("ramp angle", CommandBase.ramp.getCurrentAngle());
        //Constants.abort = false;
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }

    public void testInit() {
        //runInitialCalibration();
    }

    private void runInitialCalibration() {
        /* Orient to field */
    }

    private void runMotorControllerCalibration() {

    }
}
