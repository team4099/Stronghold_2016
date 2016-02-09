package org.usfirst.frc.team4099.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class SetRampAngle extends CommandBase {

    double destinationAngle;
    boolean goingUp;
    double maxSpeed;

    public SetRampAngle(double angleToSetTo) {
        this.destinationAngle = angleToSetTo;
        this.maxSpeed = 0.5;
        requires(ramp);
    }
    public SetRampAngle(double angleToSetTo, double maxSpeed) {
        this.maxSpeed = Math.abs(maxSpeed);
        this.destinationAngle = angleToSetTo;
        requires(ramp);
    }

    @Override
    protected void initialize() {
        this.goingUp = destinationAngle > ramp.getCurrentAngle();
        if(goingUp) ramp.setActuatorMotor(maxSpeed);
        else ramp.setActuatorMotor(-maxSpeed);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        if(goingUp) return ramp.getCurrentAngle() >= destinationAngle;
        else return ramp.getCurrentAngle() <= destinationAngle;
    }

    @Override
    protected void end() {
        if(!goingUp) {
            ramp.setActuatorMotor(0.5);
            try {
                Thread.sleep(125);
                ramp.setActuatorMotor(0);
            } catch (InterruptedException e) {
                ramp.setActuatorMotor(0);
                DriverStation.reportError("ye interrupted my sleep", true);
            }
        }
        ramp.setActuatorMotor(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
