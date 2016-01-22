package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class ElevatorToPosition extends CommandBase {

    double m_position;

    public ElevatorToPosition(double position) {
        m_position = position;
        requires(elevator);
    }

    @Override
    protected void initialize() {
        System.out.println("trying to set position to: " + m_position);
        elevator.setSetpoint(m_position);
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
