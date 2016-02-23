package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.lib.util.Direction;
import org.usfirst.frc.team4099.lib.util.Util;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class TurnAngleBangBang extends CommandBase {

    public double destAngle;
    public boolean isDestination;
    public boolean aimassist = false;
    public Direction.Rotation rotate;

    /* Vision */
    public TurnAngleBangBang() {
        this(0, false);
        aimassist = true;
    }

    public TurnAngleBangBang(double angle, boolean isDestination) {
        destAngle = angle;
        this.isDestination = isDestination;
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
        if (aimassist)
            this.destAngle = CommandBase.vision.getLateralAngle();
        if (!isDestination)
            destAngle = Util.mod(CommandBase.navX.getAngle() + destAngle, 360);
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

        System.out.println("Trying to turn to " + destAngle + " degrees.");
    }

    @Override
    protected void execute() {
        if (rotate == Direction.Rotation.CLOCKWISE) {
            driveTrain.turnRight(0.5);
        } else {
            driveTrain.turnLeft(0.5);
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
