package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.lib.util.Direction;
import org.usfirst.frc.team4099.lib.util.Util;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class TurnAngleBangBang extends CommandBase {

    public double destAngle;
    public Direction.Rotation rotate;

    public TurnAngleBangBang(double angle, boolean isDestination) {
        if (!isDestination)
            angle = Util.mod(CommandBase.navX.getAngle() + angle, 360);
        destAngle = angle;
        double currentAngle = navX.getAngle();
        double oppositeAngle = Util.mod(180 + currentAngle, 360);
        if (currentAngle < 180) {
            if (destAngle < currentAngle || destAngle > oppositeAngle) {
                rotate = Direction.Rotation.COUNTERCLOCKWISE;
            } else {
                rotate = Direction.Rotation.CLOCKWISE;
            }
        } else {
            if (destAngle > currentAngle || destAngle < oppositeAngle) {
                rotate = Direction.Rotation.COUNTERCLOCKWISE;
            } else {
                rotate = Direction.Rotation.CLOCKWISE;
            }
        }
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
        System.out.println("Trying to turn to " + destAngle + " degrees.");
    }

    @Override
    protected void execute() {
        if (rotate == Direction.Rotation.CLOCKWISE) {
            driveTrain.turnRight();
        } else {
            driveTrain.turnLeft();
        }
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
