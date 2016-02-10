package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4099.lib.util.Constants;

public class Ramp extends Subsystem {
    private int LINEAR_ACTUATOR_PORT;
    private Talon LINEAR_ACTUATOR;

    public Ramp() {
        LINEAR_ACTUATOR_PORT = Constants.LINEAR_ACTUATOR_PORT;
        LINEAR_ACTUATOR = new Talon(LINEAR_ACTUATOR_PORT);
    }

    @Override
    protected void initDefaultCommand() {
    }

    public void setMotorSpeed(double speed) {
        LINEAR_ACTUATOR.set(speed);
    }

    public void setAngle(double angle) {

    }
}
