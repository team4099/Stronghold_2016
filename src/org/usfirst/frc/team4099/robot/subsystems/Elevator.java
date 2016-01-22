package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Elevator extends PIDSubsystem {

    private static double P = CommandBase.constants.getDouble("ELEVATOR_P");
    private static double I = CommandBase.constants.getDouble("ELEVATOR_I");
    private static double D = CommandBase.constants.getDouble("ELEVATOR_D");
    private Encoder encoder = new Encoder(2, 3);
    private Talon talon = new Talon(2);
    public static final double TOP = 4.6, MIDDLE = 1.65, BOTTOM = 0.0;
    private Timer printTimer;

    public Elevator() {
        super(P, I, D);

        printTimer = new Timer();
        printTimer.start();
        getPIDController().setContinuous(false);

        setSetpoint(MIDDLE);
        encoder.startLiveWindowMode();
        enable();
    }

    @Override
    protected double returnPIDInput() {
        double pidGet = encoder.pidGet();
        System.out.println("pidGet: " + pidGet);
        return pidGet;
    }

    @Override
    protected void usePIDOutput(double output) {
        if (printTimer.hasPeriodPassed(1.0))
            System.out.println("talon output: " + output);
        talon.set(output);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
