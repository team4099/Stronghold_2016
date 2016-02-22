package org.usfirst.frc.team4099.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShootWithAimAssist extends CommandGroup {
    public ShootWithAimAssist() {
        addSequential(new AlignForShot());
        addSequential(new Shoot());
    }
}
