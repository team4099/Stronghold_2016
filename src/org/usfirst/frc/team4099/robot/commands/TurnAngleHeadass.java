package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.lib.util.Util;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class TurnAngleHeadass extends CommandBase {

    private double destAngle;

    public TurnAngleHeadass(double destination) {
        destAngle = destination;
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        driveTrain.turnRight(0.3);
    }

    @Override
    protected boolean isFinished() {
        return Util.withinRange(CommandBase.navX.getAngle(), destAngle, Constants.ANGLE_TOLERANCE);
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
