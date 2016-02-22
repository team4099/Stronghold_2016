package org.usfirst.frc.team4099.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4099.lib.util.Util;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class DriveDistance extends CommandBase {

    private double m_distance;  // should be in feet

    public DriveDistance(double distance) {
        m_distance = distance;
        requires(driveTrain);
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {
        driveTrain.driveDistance(m_distance);
    }

    @Override
    protected boolean isFinished() {
        return Util.withinRange(driveTrain.getDistanceTravelled(), m_distance, 1.0);
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
