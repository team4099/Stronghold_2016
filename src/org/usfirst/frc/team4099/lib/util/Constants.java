package org.usfirst.frc.team4099.lib.util;

public class Constants {

    private Constants() {}

    public static final double ELEVATOR_P = 0.1;
    public static final double ELEVATOR_I = 0.0;
    public static final double ELEVATOR_D = 0.0;

    public static final double DEADBAND_LIMIT = 0.1;
    public static final double SLOW_GEAR_REDUCTION_FACTOR = 2;
    public static final double FAST_GEAR_REDUCTION_FACTOR = 1.5;


    public static final int LEFT_SHOOTER_MOTOR_PORT = 9;
    public static final int RIGHT_SHOOTER_MOTOR_PORT = 2;
    public static final int FRONT_LEFT_MOTOR_PORT = 8;
    public static final int REAR_LEFT_MOTOR_PORT = 7;
    public static final int FRONT_RIGHT_MOTOR_PORT = 1;
    public static final int REAR_RIGHT_MOTOR_PORT = 0;
    public static final int LINEAR_ACTUATOR_PORT = 5;
    public static final int KICKER_PORT = 3;
    public static final int INTAKE_MOTOR_PORT = 6;
//    public static final int INTAKE_SWITCH_PORT = 6;

    public static final double GYRO_GAIN_LEFT = 0.1;
    public static final double GYRO_GAIN_RIGHT = 0.1;

    public static final double RAMP_ACTUATOR_RADIUS = 3.0;
    public static final double DISTANCE_ACTUATOR_SHOOTER = 3.0;
    public static final double MOTOR_LENGTH = 0.5;

    public static final String UDOO_RESTFUL_ENDPOINT = "http://127.0.0.1:5000/get_angle";

    public static final int[] LEFT_ENCODER_CHANNELS = {2, 3};
    public static final int[] RIGHT_ENCODER_CHANNELS = {6, 7};
    public static final int POTENTIOMETER_PORT = 2;
    public static final int LIMIT_PORT;
    public static final int PHOTO_PORT;
}
