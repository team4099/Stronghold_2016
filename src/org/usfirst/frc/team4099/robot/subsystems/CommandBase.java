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
    public static AHRS navX;

    public static void init() {
        try {
            navX = new AHRS(SPI.Port.kMXP);
            navX.reset();
            navX.zeroYaw();
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }

        oi = new OI();
    }
}
