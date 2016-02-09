package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4099.lib.util.ConstantsBase;


public class Ramp extends Subsystem {
    private Motors motors;
    private int LINEAR_ACTUATOR_PORT;
    private Talon LINEAR_ACTUATOR;

    public Ramp() {
        motors = new Motors();
        LINEAR_ACTUATOR_PORT = CommandBase.constants.getInteger("LINEAR_ACTUATOR_PORT");

        LINEAR_ACTUATOR = neww Talon(LINEAR_ACTUATOR_PORT);
        motors.addMotor(LINEAR_ACTUATOR);

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
