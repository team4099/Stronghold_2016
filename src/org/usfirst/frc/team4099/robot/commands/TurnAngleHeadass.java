package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class TurnAngleHeadass extends CommandBase {

	private double startingAngle;
    private double turnAngle;
    private double angleThreshold;
    private boolean turnRight;
    private boolean aimassist = false;

    public TurnAngleHeadass() {
        this(0);
        aimassist = true;

    }
    public TurnAngleHeadass(double angle) {
        turnAngle = angle;
        angleThreshold = 10;
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
        if (aimassist)
            this.turnAngle = CommandBase.vision.getLateralAngle();

        turnRight = this.turnAngle > 0;
    	startingAngle = navX.getAngle();
    	if (turnRight) 
    		driveTrain.turnRight(0.5);
    	else
    		driveTrain.turnLeft(0.5);
    }

    @Override
    protected void execute() {
    	if (turnRight)
    		driveTrain.drive(0.5,0.5);
    	else
    		driveTrain.drive(-0.5,-0.5);
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
