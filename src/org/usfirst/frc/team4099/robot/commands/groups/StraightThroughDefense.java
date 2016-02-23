package org.usfirst.frc.team4099.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team4099.robot.commands.DriveForward;
import org.usfirst.frc.team4099.robot.commands.Kick;
import org.usfirst.frc.team4099.robot.commands.RunShooterFullSpeed;

public class StraightThroughDefense extends CommandGroup {

    public StraightThroughDefense() {
        addSequential(new DriveForward(1.0));
        addSequential(new WaitCommand(2.0));
    }
}
