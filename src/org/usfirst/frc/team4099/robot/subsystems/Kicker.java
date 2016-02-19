package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.robot.commands.ResetKicker;

public class Kicker extends Subsystem {
    private Servo KICKER;

    public Kicker() {
        KICKER = new Servo(Constants.KICKER_PORT);
        resetKicker();
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ResetKicker());
    }

    public void kick() {
        KICKER.setAngle(0);
    }

    public void resetKicker() {
        KICKER.setAngle(110);
    }
}
