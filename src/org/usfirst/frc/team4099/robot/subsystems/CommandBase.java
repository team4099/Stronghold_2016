package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4099.lib.util.ConstantsBase;
import org.usfirst.frc.team4099.robot.OI;
import org.usfirst.frc.team4099.robot.RobotMap;

public abstract class CommandBase extends Command {

    public static OI oi;
    public static final ConstantsBase constants = new ConstantsBase();
    public static final DriveTrain driveTrain = new DriveTrain();

    public static void init() {
        oi = new OI();
    }
}
