package org.usfirst.frc.team4099.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4099.lib.input.Attack3;
import org.usfirst.frc.team4099.lib.input.Gamepad;
import org.usfirst.frc.team4099.robot.commands.SetIntakeSpeed;

/**
 * Created by plato2000 on 2/21/16.
 */
public class MoveIntakeManually extends CommandGroup{
    public MoveIntakeManually(Attack3 attack3) {
//        attack3.
        addSequential(new SetIntakeSpeed(attack3.getRawAxis(2)));
    }
}
