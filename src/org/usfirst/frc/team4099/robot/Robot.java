
package org.usfirst.frc.team4099.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team4099.lib.util.ConstantsBase;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class Robot extends IterativeRobot {

    Command autonomousCommand;

    @Override
    public void robotInit() {
        CommandBase.init();
    }
	
    public void disabledInit(){
        //CommandBase.driveTrain.setSafety(true);
        ConstantsBase.reloadConstants();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        CommandBase.driveTrain.setSafety(false);
//        Scheduler.getInstance().add(new DriveForward());
//        Scheduler.getInstance().add(new WaitCommand(3));
//        Scheduler.getInstance().add(new StopDriving());
//
//        Scheduler.getInstance().add(new WaitCommand(1));
//        Scheduler.getInstance().add(new DriveForward(3));
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
    }
}
