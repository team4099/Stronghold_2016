package org.usfirst.frc.team4099.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.robot.OI;
import edu.wpi.first.wpilibj.SPI;

public abstract class CommandBase extends Command {

    public static OI oi;
    public static DriveTrain driveTrain = new DriveTrain();
    public static Shooter shooter = new Shooter();
    public static Ramp ramp = new Ramp();
    public static Intake intake = new Intake();
    public static Kicker kicker = new Kicker();
    public static Vision vision = new Vision();
    public static Potentiometer potentiometer;
    public static DigitalInput limitSwitch;
    public static DigitalInput photoInterrupter;
    public static AHRS navX;

    public static void init() {
        //potentiometer = new AnalogPotentiometer(0, 360, 30);
        //limitSwitch = new DigitalInput(Constants.LIMIT_PORT);
        //photoInterrupter = new DigitalInput(Constants.PHOTO_PORT);

        try {
            navX = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }

        oi = new OI();
    }
}
