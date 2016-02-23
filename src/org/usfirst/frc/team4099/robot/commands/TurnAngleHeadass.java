package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.lib.util.Util;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class TurnAngleHeadass extends CommandBase {

	private double startingAngle;
    private double turnAngle;
    private double angleThreshold;
    private boolean turnRight;

    public TurnAngleHeadass(double angle) {
        turnAngle = angle;
        angleThreshold = 3;
        startingAngle = navX.getAngle();
        if (turnAngle>=0) 
        	turnRight = true;
        else
        	turnRight = false;
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	if (turnRight)
    		driveTrain.turnRight(0.5);
    	else
    		driveTrain.turnLeft(0.5);
    }

    @Override
    protected boolean isFinished() {
        //return Util.withinRange(CommandBase.navX.getAngle(), destAngle, Constants.ANGLE_TOLERANCE);
    	return Math.abs(navX.getAngle() - (startingAngle + turnAngle)%360) <= angleThreshold;
    }

    @Override
    protected void end() {
        driveTrain.stop();
    }

    @Override
    protected void interrupted() {
        driveTrain.stop();
    }
}
