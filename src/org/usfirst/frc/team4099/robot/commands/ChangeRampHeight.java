package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.lib.util.Direction;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

import edu.wpi.first.wpilibj.DriverStation;

public class ChangeRampHeight extends CommandBase {

    private Direction dir;

    public ChangeRampHeight(Direction direction) {
        dir = direction;
        requires(ramp);
    }

    @Override
    protected void initialize() {
        setTimeout(0.0001);
    }

    @Override
    protected void execute() {
    	DriverStation.reportError(Boolean.toString(isTooFar()) + "\n", false);
        DriverStation.reportError(Double.toString(ramp.potentiometerDistance()) + "\n", false);
        if (dir == Direction.DOWN && !isTooFar())
            ramp.setMotorSpeed(1.0);
        else if (dir == Direction.UP && !isTooFar())
            ramp.setMotorSpeed(-1.0);
    }

    private boolean isTooFar() {
//        if(dir == Direction.DOWN) return ramp.potentiometerDistance() < -16;
//        else if(dir == Direction.UP) return ramp.potentiometerDistance() > 40;
//        else return true;
        return false;
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

