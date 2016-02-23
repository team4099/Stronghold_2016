package org.usfirst.frc.team4099.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.lib.util.Direction;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

import edu.wpi.first.wpilibj.DriverStation;

public class ChangeRampHeight extends CommandBase {

    private Direction.Ramp dir;

    public ChangeRampHeight(Direction.Ramp direction) {
        dir = direction;
        requires(ramp);
    }

    @Override
    protected void initialize() {
        setTimeout(0.01);
    }

    @Override
    protected void execute() {

        if (dir == Direction.Ramp.DOWN && !isTooFar())
            ramp.setMotorSpeed(1.0);
        else if (dir == Direction.Ramp.UP && !isTooFar())
            ramp.setMotorSpeed(-1.0);
    }

    private boolean isTooFar() {
        if (dir == Direction.Ramp.UP) {
            if (ramp.getCurrentAngle() < Constants.RAMP_UPPER_LIMIT)
                return false;
        } else {
            if (ramp.getCurrentAngle() > Constants.RAMP_LOWER_LIMIT)
                return false;
        }

        return true;
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut() || isTooFar();
    }

    @Override
    protected void end() {
        ramp.setMotorSpeed(0);
    }

    @Override
    protected void interrupted() {
        ramp.setMotorSpeed(0);
    }
}

