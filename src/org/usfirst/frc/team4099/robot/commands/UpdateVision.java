package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class UpdateVision extends CommandBase {
    private boolean finish = false;
    public UpdateVision() {
        requires(vision);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        vision.pointToGoal();
        finish = true;
    }

    @Override
    protected boolean isFinished() {
    	if (isTimedOut()) {
    		Constants.abort = true;
    	}
        return finish;
    }

    @Override
    protected void end() {


    }

    @Override
    protected void interrupted() {
    }
}
