package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4099.lib.input.Gamepad;
import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.lib.util.GamepadUtil;
import org.usfirst.frc.team4099.robot.commands.IntakeUp;


public class Intake extends Subsystem {
    private Talon INTAKE_MOTOR;

    public Intake() {
        INTAKE_MOTOR = new Talon(Constants.INTAKE_MOTOR_PORT);
    }

    // Temporary - we will have it activate on limit switch once thats wired up
    public void moveWithTrigger(Gamepad gamepad) {
        double speed = GamepadUtil.deadband(gamepad.getLeftTrigger());
        move(speed);
    }

    public void move(double speed) {
        INTAKE_MOTOR.set(speed);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new IntakeUp());
    
    }
}
