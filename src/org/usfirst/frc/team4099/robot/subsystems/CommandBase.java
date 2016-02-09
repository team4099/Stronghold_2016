package org.usfirst.frc.team4099.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import org.usfirst.frc.team4099.lib.util.ConstantsBase;
import org.usfirst.frc.team4099.robot.OI;

public abstract class CommandBase extends Command {

    public static OI oi;
    public static final ConstantsBase constants = new ConstantsBase();
    public static final DriveTrain driveTrain = new DriveTrain();
    public static final Shooter shooter = new Shooter();
    public static final Ramp ramp = new Ramp();
    public static final Elevator elevator = null;/* = new Elevator();*/
    public static AHRS ahrs;
    public static Potentiometer potentiometer;
    public static void init() {
        oi = new OI();
        try {
            /* Communicate w/navX MXP via the MXP SPI Bus.                                     */
            /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
            /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
            ahrs = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }
        potentiometer = new AnalogPotentiometer(0, 360, 30);
    }
}
