package org.usfirst.frc.team4099.lib.util;

public class Limiter {
    private Limiter() {}  // prevents instantiating

    public static double limitSpeed(double speedIn) {
        if (speedIn > 1.0)
            speedIn = 1.0;

        if (speedIn < -1.0)
            speedIn = -1.0;

        return speedIn;
    }

}
