package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4099.lib.util.Constants;

public class Ramp extends Subsystem {

    private AnalogPotentiometer potentiometer;
    private Talon actuatorMotor;
    private double maxHeight = 10;
    private double zeroPoint = 0;

    public Ramp() {
        this.actuatorMotor = new Talon(Constants.LINEAR_ACTUATOR_PORT);
        this.potentiometer = new AnalogPotentiometer(Constants.POTENTIOMETER_PORT);
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

        return Math.acos(Math.pow(potentiometerDistance() + Constants.MOTOR_LENGTH, 2) - Math.pow(Constants.RAMP_ACTUATOR_RADIUS, 2) - Math.pow(Constants.DISTANCE_ACTUATOR_SHOOTER, 2) / (Constants.RAMP_ACTUATOR_RADIUS * Constants.DISTANCE_ACTUATOR_SHOOTER));
    }

    public double potentiometerDistance() {
        return potentiometer.get();
    }

    @Override
    protected void initDefaultCommand() {
    }

    public void setMotorSpeed(double speed) {
        actuatorMotor.set(speed);
    }

    public void setAngle(double angle) {
    }



}
