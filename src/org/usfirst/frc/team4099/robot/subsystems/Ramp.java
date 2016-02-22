package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team4099.lib.util.Constants;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4099.robot.commands.BurstUp;

public class Ramp extends Subsystem {

    //private AnalogPotentiometer potentiometer;
    private Talon actuatorMotor;
    private double maxHeight = 10;
    private double zeroPoint = 0;
    
    private double potMultiplier = 30; //change multiplier value for potentiometer

    public Ramp() {
        this.actuatorMotor = new Talon(Constants.LINEAR_ACTUATOR_PORT);
        //this.potentiometer = new AnalogPotentiometer(Constants.POTENTIOMETER_PORT, potMultiplier, 10);
    }

    public void setActuatorMotor(double speed) {
        actuatorMotor.set(speed);
    }

    public double getCurrentAngle() {
//    	SmartDashboard.putNumber("Potentiometer", potentiometer.get());

        /*
        arccos ( (p^2 - r^2 - t^2) / rt )
        where p is the distance from the actuator motor rod to the actuator connector point
              r is the radius of the actuator arm (distance from rotating rod to actuator connector point)
              t is the distance from the actuator motor rod to the ramp's rotation rod
         */
    	
    	//TODO DIFFERENT POTENTIOMETER POSITIONING -- RECALCULATE

//        return Math.acos(Math.pow(potentiometerDistance() + Constants.MOTOR_LENGTH, 2) - Math.pow(Constants.RAMP_ACTUATOR_RADIUS, 2) - Math.pow(Constants.DISTANCE_ACTUATOR_SHOOTER, 2) / (Constants.RAMP_ACTUATOR_RADIUS * Constants.DISTANCE_ACTUATOR_SHOOTER));
        return 0.0;
    }

    /*
    public double potentiometerDistance() {
        return potMultiplier - potentiometer.get();
    }
    */

    @Override
    protected void initDefaultCommand() {

    }

    public void burstUp() {
        Scheduler.getInstance().add(new BurstUp());
    }

    public void stopRamp() {
        actuatorMotor.set(0);
    }

    public void moveDown() {
        actuatorMotor.set(-0.9);
    }

    public void moveUp() {
        actuatorMotor.set(1.0);
    }
}
