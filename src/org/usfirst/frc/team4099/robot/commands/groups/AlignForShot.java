package org.usfirst.frc.team4099.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;
import org.usfirst.frc.team4099.robot.commands.TurnAngle;
import org.usfirst.frc.team4099.robot.commands.UpdateVision;
import org.usfirst.frc.team4099.robot.commands.SetRampAngle;
import org.usfirst.frc.team4099.robot.commands.groups.Shoot;

public class AlignForShot extends CommandGroup {

    public AlignForShot() {
        addSequential(new UpdateVision());
        addSequential(new TurnAngle(CommandBase.vision.getLateralAngle()));
        addParallel(new SetRampAngle(CommandBase.vision.getVerticalAngle()));
        addSequential(new Shoot());
    }
}
