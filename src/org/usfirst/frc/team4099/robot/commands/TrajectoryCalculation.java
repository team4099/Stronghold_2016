package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class TrajectoryCalculation extends CommandBase {
    private boolean finish = false;
    public TrajectoryCalculation() {
        requires(vision);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        vision.aimShot();
        finish = true;
    }

    @Override
    protected boolean isFinished() {
        return finish;
    }

    @Override
    protected void end() {


    }

    @Override
    protected void interrupted() {
    }
}
