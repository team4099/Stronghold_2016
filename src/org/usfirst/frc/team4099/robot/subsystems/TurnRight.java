package org.usfirst.frc.team4099.robot.subsystems;

public class TurnRight extends CommandBase {
	private double m_timeout;

    public TurnRight(double time) {
        m_timeout = time;
    }

    @Override
    protected void initialize() {
        setTimeout(m_timeout);
        requires(driveTrain);
    }

    @Override
    protected void execute() {
        driveTrain.turnRight();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {}

    @Override
    protected void interrupted() {}
}
