package org.usfirst.frc.team4099.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team4099.lib.util.GamepadUtil;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;
import org.usfirst.frc.team4099.robot.subsystems.DriveTrain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Robot extends IterativeRobot {

    Command autonomousCommand;

    @Override
    public void robotInit() {
        CommandBase.init();

    }
	
    public void disabledInit(){
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

    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        System.out.println("Pot: " + CommandBase.ramp.getCurrentAngle());
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }

    public void testInit() {
        runInitialCalibration();
    }

    private void runInitialCalibration() {
        /* Orient to field */
    }

    private void runMotorControllerCalibration() {

    }
}
