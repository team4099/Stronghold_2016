package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.lib.util.RampMoveEnum;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

import edu.wpi.first.wpilibj.DriverStation;

public class ChangeRampHeight extends CommandBase {

    private RampMoveEnum dir;

    public ChangeRampHeight(RampMoveEnum direction) {
        dir = direction;
        requires(ramp);
    }

    @Override
    protected void initialize() {
        setTimeout(0.01);
    }

    @Override
    protected void execute() {
    	DriverStation.reportError(Boolean.toString(isTooFar()) + "\n", false);
        DriverStation.reportError(Double.toString(ramp.potentiometerDistance()) + "\n", false);
        if (dir == RampMoveEnum.DOWN && !isTooFar())
            ramp.setMotorSpeed(1.0);
        else if (dir == RampMoveEnum.UP && !isTooFar())
            ramp.setMotorSpeed(-1.0);
    }

    private boolean isTooFar() {
//        if(dir == RampMoveEnum.DOWN) return ramp.potentiometerDistance() < -16;
//        else if(dir == RampMoveEnum.UP) return ramp.potentiometerDistance() > 40;
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

