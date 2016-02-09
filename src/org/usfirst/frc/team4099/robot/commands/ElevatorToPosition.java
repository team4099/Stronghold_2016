package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class ElevatorToPosition extends CommandBase {

    double position;

    public ElevatorToPosition(double position) {
        this.position = position;
        requires(elevator);
    }

    @Override
    protected void initialize() {
        System.out.println("trying to set position to: " + position);
        elevator.setSetpoint(position);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return Math.abs(elevator.getSetpoint() - elevator.getPosition()) < 0.1;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
