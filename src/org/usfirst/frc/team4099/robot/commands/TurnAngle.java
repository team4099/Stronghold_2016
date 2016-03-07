package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class TurnAngle extends CommandBase {

	private double startingAngle;
    private double turnAngle;
    private double angleThreshold;
    private boolean turnRight;
    private boolean aimAssist;
    private boolean turnToAngle;

    public TurnAngle() {
        this(true);
    }

    public TurnAngle(boolean aimAssist) {
        this(0);
        this.aimAssist = aimAssist;

    }

    public TurnAngle(double angle) {
        this.aimAssist = false;
        this.turnAngle = angle;
        this.angleThreshold = 10;
        requires(driveTrain);
    }

    public TurnAngle(boolean turnToAngle, double angle) {
        this(angle);
        this.turnToAngle = turnToAngle;
    }

    @Override
    protected void initialize() {
        if (aimAssist)
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
        if(!turnToAngle)
    	    return Math.abs(navX.getAngle() - (startingAngle + turnAngle)%360) <= angleThreshold;
        else
            return Math.abs(navX.getAngle() - (turnAngle)%360) <= angleThreshold;
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
