
package org.usfirst.frc.team4099.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;
import org.usfirst.frc.team4099.lib.util.GamepadUtil;

public class GamepadDrive extends CommandBase {

    Timer printTimer;
	
	
    public GamepadDrive() {
        requires(driveTrain);
    }

    /**
     *  Called just before this Command runs the first time
     */
    protected void initialize() {
        printTimer = new Timer();
        printTimer.start();
    }

    /**
     *
     * @param speed The input speed to modify (make slower/faster)
     * @return The updated speed after dividing by reduction factor
     */
    private double modifySpeed(double speed) {
        boolean leftTriggerPressed = CommandBase.oi.getGamepad0().isLeftTriggerPressed();
        boolean rightTriggerPressed = CommandBase.oi.getGamepad0().isRightTriggerPressed();

        if (leftTriggerPressed && rightTriggerPressed)
            return speed / Constants.FAST_GEAR_REDUCTION_FACTOR;

        return speed / Constants.SLOW_GEAR_REDUCTION_FACTOR;
    }

    /**
     *  Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {

//        driveTrain.driveWithGamepad(oi.getGamepad0());
    	if (oi.getGamepad0().isDPadUpPressed() || oi.getGamepad0().isDPadDownPressed()) {
    		driveTrain.tankDrive(oi.getGamepad0().isDPadUpPressed() ? 1 : 0, oi.getGamepad0().isDPadDownPressed() ? 1 : 0);
    	} else if (oi.getGamepad0().isDPadLeftPressed()) {
    		driveTrain.turnLeft();
    	} else if (oi.getGamepad0().isDPadRightPressed()) {
    		driveTrain.turnRight();
    	} else {
    		double left = oi.getGamepad0().getLeftVerticalAxis();
            double right = oi.getGamepad0().getRightVerticalAxis();

            // deadband modified values
            double f_left = GamepadUtil.deadband(left);
            double f_right = GamepadUtil.deadband(right);

            if (printTimer.hasPeriodPassed(1.0))
                System.out.println("left: " + f_left + "  " + "right: " + f_right);

            // gear modified values
            double m_left = modifySpeed(f_left);
            double m_right = modifySpeed(f_right);
//            double m_left = f_left;
//            double m_right = f_right;

            // fix sign (motor direction)
            m_left = -m_left;
            m_right = -m_right;
            
            driveTrain.tankDrive(m_left, m_right);
    	}
    }

    /**
     *  @return true when this Command no longer needs to run execute()
     */
    protected boolean isFinished() {
        return !(oi.getGamepad0().isDPadUpPressed() || oi.getGamepad0().isDPadDownPressed() || oi.getGamepad0().isDPadLeftPressed() || oi.getGamepad0().isDPadRightPressed() || GamepadUtil.deadband(oi.getGamepad0().getLeftVerticalAxis()) != 0 || GamepadUtil.deadband(oi.getGamepad0().getRightVerticalAxis()) != 0); // if nothing is pressed stop
    }

    /**
     *  Called once after isFinished returns true
     */
    protected void end() {
    	driveTrain.stop();
    }

    /**
     * Called when another command which requires one or more of the same subsystems is scheduled to run
     */
    protected void interrupted() {
    }
}
