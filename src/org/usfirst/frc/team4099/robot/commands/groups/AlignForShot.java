package org.usfirst.frc.team4099.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team4099.robot.commands.DriveForward;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class AlignForShot extends CommandGroup {

    public AlignForShot() {
        requires(CommandBase.vision);
        addSequential(new DriveForward(1));
        addSequential(new WaitCommand(1));
        addSequential(new DriveForward(1));
        addSequential(new WaitCommand(1));
        addSequential(new DriveForward(1));
    }
}
