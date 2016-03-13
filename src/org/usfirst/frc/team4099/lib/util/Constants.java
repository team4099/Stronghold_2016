package org.usfirst.frc.team4099.lib.util;

public class Constants {



    private Constants() {}
    
    //crusty
    public static boolean abort = false;
    
    public static final double DPAD_MOVE_SPEED = 0.7;
    		;
    public static final double DPAD_TURN_SPEED = 0.7;
    public static final double ANGLE_TOLERANCE = 10.0;

    public static final double DEADBAND_LIMIT = 0.1;
    public static final double SLOW_GEAR_REDUCTION_FACTOR = 2;
    public static final double FAST_GEAR_REDUCTION_FACTOR = 1.05;
    public static final double MID_GEAR_REDUCTION_FACTOR = 1.5;

    public static final int LEFT_MOTORS_PORT = 0;
    public static final int RIGHT_MOTORS_PORT = 1;
/*    
    public static final int FRONT_LEFT_MOTOR_PORT = 0;
    public static final int REAR_LEFT_MOTOR_PORT = 1;
    public static final int FRONT_RIGHT_MOTOR_PORT = 7;
    public static final int REAR_RIGHT_MOTOR_PORT = 8;
  */  
    public static final int LEFT_SHOOTER_MOTOR_PORT = 4;
    public static final int RIGHT_SHOOTER_MOTOR_PORT = 5;
    public static final int KICKER_PORT = 6;
    public static final int INTAKE_MOTOR_PORT = 3;
    public static final int LINEAR_ACTUATOR_PORT = 9;

    public static final double GYRO_GAIN_LEFT = 0.1;
    public static final double GYRO_GAIN_RIGHT = 0.1;

    public static final double RAMP_ACTUATOR_RADIUS = 3.0;
    public static final double DISTANCE_ACTUATOR_SHOOTER = 3.0;
    public static final double MOTOR_LENGTH = 0.5;

    public static final String UDOO_RESTFUL_ENDPOINT = "http://10.40.99.21:80/get_angle";

    public static final int[] LEFT_ENCODER_CHANNELS = {2, 3};
    public static final int[] RIGHT_ENCODER_CHANNELS = {6, 7};
    public static final int LIMIT_PORT = 3;
    public static final int PHOTO_PORT = 4;

    public static final int INTAKE_TRIPWIRE_PORT = 9;
    
    public static final int POTENTIOMETER_PORT = 2;
    public static final double RAMP_POT_SLOPE = -205.8733749;
    public static final double RAMP_POT_CONSTANT = 151.0816574;
//    public static final double RAMP_UPPER_LIMIT = 50;
//    public static final double RAMP_LOWER_LIMIT = 2;

    public static final double RAMP_UPPER_LIMIT = 57;
    public static final double RAMP_LOWER_LIMIT = 5;

//    public static final int INTAKE_UPPER_LIMIT_SWITCH_PORT = 1; // TBD

    public static final double RAMP_ANGLE_TOLERANCE = 0.1;

    public static final double DRIVE_GAIN_KP = 0.1;
    public static final double DRIVE_GAIN_KI = 0.000;
    public static final double DRIVE_GAIN_KD = 0.000;

    public static final double DISTANCE_PER_PULSE = 0.001;
    
    public static final int DEFAULT_RAMP_ANGLE = 19;

}
