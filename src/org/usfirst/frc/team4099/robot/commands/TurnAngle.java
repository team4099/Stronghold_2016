package org.usfirst.frc.team4099.robot.commands;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class TurnAngle extends CommandBase {

    double angle;
    double startingAngle;
    boolean turnRight;

    public TurnAngle(double angle) {
        this.angle = angle;
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
        System.out.println("trying to turn angle: " + angle);
        startingAngle = ahrs.getAngle();
        turnRight = angle > 0;
        if(turnRight) driveTrain.turnRight();
        else driveTrain.turnLeft();
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        if(turnRight) {
            return ahrs.getAngle() >= startingAngle + angle;
        } else {
            return ahrs.getAngle() <= startingAngle + angle;
        }
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
