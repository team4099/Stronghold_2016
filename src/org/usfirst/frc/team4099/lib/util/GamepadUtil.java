package org.usfirst.frc.team4099.lib.util;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class GamepadUtil {

    private GamepadUtil() {}

    public static double deadband(double d) {
        double DEADBAND_LIMIT = Constants.DEADBAND_LIMIT;
        if (Math.abs(d) < DEADBAND_LIMIT)
            return 0;
        d = (d - DEADBAND_LIMIT) / (1.0 - DEADBAND_LIMIT);
        return d;
    }
}
