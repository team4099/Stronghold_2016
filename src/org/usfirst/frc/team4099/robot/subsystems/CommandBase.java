package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4099.lib.util.ConstantsBase;
import org.usfirst.frc.team4099.robot.OI;

public abstract class CommandBase extends Command {

    public static OI oi;
    public static final ConstantsBase constants = new ConstantsBase();
    public static final DriveTrain driveTrain = new DriveTrain();
    public static final Shooter shooter = new Shooter();
    public static final Ramp ramp = new Ramp();
    public static final Elevator elevator = null;/* = new Elevator();*/

    public static void init() {
        oi = new OI();
    }
}
