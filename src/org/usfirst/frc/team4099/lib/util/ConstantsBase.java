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

        integerConstants.put("FRONT_LEFT_MOTOR", 3);
        integerConstants.put("REAR_LEFT_MOTOR", 2);
        integerConstants.put("FRONT_RIGHT_MOTOR", 1);
        integerConstants.put("REAR_RIGHT_MOTOR", 0);
        //loadConstantsFromFile(CONSTANTS_FILEPATH);
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
