package org.usfirst.frc.team4099.lib.util;

public class Util {
    private Util() {}

    public static boolean withinRange(double value, double target, double tolerance) {
        return Math.abs(value - target) <= tolerance;
    }

    public static double mod(double value, double modulus) {
        double mod = value % modulus;
        while (mod < 0)
            mod += 360;

        return mod;
    }
}
