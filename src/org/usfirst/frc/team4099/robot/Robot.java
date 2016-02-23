package org.usfirst.frc.team4099.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4099.robot.commands.TurnAngleBangBang;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class Robot extends IterativeRobot {

    Command autonomousCommand;

    @Override
    public void robotInit() {
        CommandBase.init();
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
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        CommandBase.driveTrain.setSafety(false);
        // cancel any current autonomous
        if (autonomousCommand != null) autonomousCommand.cancel();

        CommandBase.navX.reset();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("gyroangle", CommandBase.navX.getAngle());
        SmartDashboard.putNumber("rightencoder", CommandBase.driveTrain.rightEncoder.get());
        SmartDashboard.putNumber("leftencoder", CommandBase.driveTrain.leftEncoder.get());
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }

    public void testInit() {
        //runInitialCalibration();
        Scheduler.getInstance().add(new TurnAngleBangBang(90, false));
    }

    private void runInitialCalibration() {
        /* Orient to field */
    }

    private void runMotorControllerCalibration() {

    }
}
