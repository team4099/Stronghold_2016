package org.usfirst.frc.team4099.lib.input;

import edu.wpi.first.wpilibj.Joystick;

public class Attack3 extends Joystick {

    public static final int X_AXIS = 0;
    public static final int Y_AXIS = 1;
    public static final int Z_AXIS = 2;
    public static final int INDEX_TRIGGER = 0;
    public static final int BUTTON_2 = 1;
    public static final int BUTTON_3 = 2;
    public static final int BUTTON_4 = 3;

    public Attack3(int port) {
        super(port);
    }

    public boolean isIndexTriggerPressed() {
        return getRawButton(INDEX_TRIGGER);
    }

    public double getZAxisValue() {
        return getRawAxis(Z_AXIS);
    }

    public double getYAxisValue() {
        return getRawAxis(Y_AXIS);
    }

    public boolean isButton2Pressed() {
        return getRawButton(BUTTON_2);
    }

    public boolean isButton3Pressed() {
        return getRawButton(BUTTON_3);
    }

    public boolean isButton4Pressed() {
        return getRawButton(BUTTON_4);
    }
}
