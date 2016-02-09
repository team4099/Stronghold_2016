package org.usfirst.frc.team4099.lib.util;

import java.io.File;
import java.util.HashMap;

public class ConstantsBase {

    public HashMap<String, Integer> integerConstants;
    public HashMap<String, Double> doubleConstants;
    private static final String CONSTANTS_FILEPATH = "CONSTANTS.txt";

    public ConstantsBase() {
        integerConstants = new HashMap<String, Integer>();
        doubleConstants = new HashMap<String, Double>();

        doubleConstants.put("ELEVATOR_P", 0.1);
        doubleConstants.put("ELEVATOR_I", 0.0);
        doubleConstants.put("ELEVATOR_D", 0.0);

        integerConstants.put("LEFT_SHOOTER_MOTOR_PORT", 5);
        integerConstants.put("RIGHT_SHOOTER_MOTOR_PORT", 4);

        integerConstants.put("FRONT_LEFT_MOTOR_PORT", 6);
        integerConstants.put("REAR_LEFT_MOTOR_PORT", 8);
        integerConstants.put("FRONT_RIGHT_MOTOR_PORT", 7);
        integerConstants.put("REAR_RIGHT_MOTOR_PORT", 9);

        integerConstants.put("RAMP_ACTUATOR_MOTOR_PORT", 0);

        doubleConstants.put("DEADBAND_LIMIT", 0.1);
        doubleConstants.put("SLOW_GEAR_REDUCTION_FACTOR", 2.5);
        doubleConstants.put("FAST_GEAR_REDUCTION_FACTOR", 1.5);
        //loadConstantsFromFile(CONSTANTS_FILEPATH);

        doubleConstants.put("RAMP_ACTUATOR_RADIUS", 3.0);
        doubleConstants.put("DISTANCE_ACTUATOR_SHOOTER", 3.0);
        doubleConstants.put("MOTOR_LENGTH", 0.5);

    }

    public static void loadConstantsFromFile(String filepath) {
        File f = new File(filepath);
    }

    public static void reloadConstants() {
        loadConstantsFromFile(CONSTANTS_FILEPATH);
    }

    public Integer getInteger(String name) {
        if (!integerConstants.containsKey(name)) {
            System.err.println("Could not get integer with name '" + name + "'...");
            throw new IllegalArgumentException("[!!][ConstantsBase] no such constant found");
        }
        return integerConstants.get(name);
    }

    public Double getDouble(String name) {
        if (!doubleConstants.containsKey(name)) {
            System.err.println("Could not get double with name '" + name + "'...");
            throw new IllegalArgumentException("[!!][ConstantsBase] no such constant found");
        }
        return doubleConstants.get(name);
    }
}
