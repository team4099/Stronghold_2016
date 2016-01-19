package org.usfirst.frc.team4099.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveInASquare extends CommandGroup {
    public DriveInASquare() {
        addSequential(new DriveForward(1));
    }
}
