package org.usfirst.frc.team4099.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4099.robot.commands.PassiveIntake;
import org.usfirst.frc.team4099.robot.commands.SetRampAngle;

public class PrepareForLowBar extends CommandGroup {
    public PrepareForLowBar() {
        addParallel(new PassiveIntake());
        addParallel(new SetRampAngle(15));
    }
}
