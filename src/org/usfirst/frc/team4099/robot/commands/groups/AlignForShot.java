package org.usfirst.frc.team4099.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4099.robot.commands.TurnAngleBangBang;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;
import org.usfirst.frc.team4099.robot.commands.UpdateVision;
import org.usfirst.frc.team4099.robot.commands.SetRampAngle;

public class AlignForShot extends CommandGroup {

    public AlignForShot() {
        addSequential(new UpdateVision());

        addSequential(new TurnAngleBangBang(CommandBase.vision.getLateralAngle(), false));
        // false means that the angle is turn amount
        addSequential(new SetRampAngle());
    }
}
