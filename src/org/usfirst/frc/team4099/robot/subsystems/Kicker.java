package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4099.lib.util.Constants;

public class Kicker extends Subsystem {
    private int KICKER_PORT;
    private Servo KICKER;

    public Kicker() {
        KICKER_PORT = Constants.KICKER_PORT;
        KICKER = new Servo(KICKER_PORT);

        resetKicker();
    }

    @Override
    protected void initDefaultCommand() {
    }

    public void kick() {
        KICKER.setAngle(0);
    }

    public void resetKicker() {
        KICKER.setAngle(110);
    }
}
