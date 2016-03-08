package org.usfirst.frc.team4099.lib.input;

import edu.wpi.first.wpilibj.Joystick;

public class Extreme3DJoystick extends Joystick {

    public static final int X_AXIS = 0;
    public static final int Y_AXIS = 1;
    public static final int SPIN_AXIS = 2;
    public static final int FLAPPER = 3;

    public static final int INDEX_TRIGGER = 1;

    public Extreme3DJoystick(int port) {
        super(port);
    }

    public boolean isIndexTriggerPressed() {
        return getRawButton(INDEX_TRIGGER);
    }
    public double getFlapperValue() {
        return getRawAxis(FLAPPER);
    }

    public double getSpinAxisValue() {
        return getRawAxis(SPIN_AXIS);
    }

    public double getYAxisValue() {
        return getRawAxis(Y_AXIS);
    }
    public boolean getButton(int button_num) {
        return getRawButton(button_num);
    }
}
