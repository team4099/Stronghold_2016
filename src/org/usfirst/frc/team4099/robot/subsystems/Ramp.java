package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4099.lib.util.ConstantsBase;

public class Ramp extends Subsystem {

    private double potentiometerDistance;
    private Talon actuatorMotor;

    public Ramp() {
        this.actuatorMotor = new Talon(CommandBase.constants.getInteger("RAMP_ACTUATOR_MOTOR_PORT"));
    }

    public void setActuatorMotor(double speed) {
        actuatorMotor.set(speed);
    }

    public double getCurrentAngle() {
        /*
        arccos ( (p^2 - r^2 - t^2) / rt )
        where p is the distance from the actuator motor rod to the actuator connector point
              r is the radius of the actuator arm (distance from rotating rod to actuator connector point)
              t is the distance from the actuator motor rod to the ramp's rotation rod
         */

        return Math.acos(Math.pow(potentiometerDistance + CommandBase.constants.getDouble("MOTOR_LENGTH"), 2) - Math.pow(CommandBase.constants.getDouble("RAMP_ACTUATOR_RADIUS"), 2) - Math.pow(CommandBase.constants.getDouble("DISTANCE_ACTUATOR_SHOOTER"), 2) / (CommandBase.constants.getDouble("RAMP_ACTUATOR_RADIUS") * CommandBase.constants.getDouble("DISTANCE_ACTUATOR_SHOOTER")));
    }
    @Override
    protected void initDefaultCommand() {}


}
