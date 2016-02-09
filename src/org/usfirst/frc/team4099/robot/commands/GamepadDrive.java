
package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class GamepadDrive extends CommandBase {

	
	
    public GamepadDrive() {
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//        driveTrain.driveWithGamepad(oi.getGamepad0());
    	if (oi.getGamepad0().isDPadUpPressed() || oi.getGamepad0().isDPadDownPressed()) {
    		driveTrain.tankDrive(oi.getGamepad0().isDPadUpPressed() ? 1 : 0, oi.getGamepad0().isDPadDownPressed() ? 1 : 0)
    	} else if ( oi.getGamepad0().isDPadLeftPressed() || oi.getGamepad0().isDPadRightPressed()) {
    		//turn
    	} else {
    		double left = gamepad.getLeftVerticalAxis();
            double right = gamepad.getRightVerticalAxis();

            // deadband modified values
            double f_left = GamepadUtil.deadband(left);
            double f_right = GamepadUtil.deadband(right);

            if (printTimer.hasPeriodPassed(1.0))
                System.out.println("left: " + f_left + "  " + "right: " + f_right);

            // gear modified values
            double m_left = modifySpeed(f_left);
            double m_right = modifySpeed(f_right);

            // fix sign (motor direction)
            m_left = -m_left;
            m_right = -m_right;
            
            driveTrain.tankDrive(m_left, m_right);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
