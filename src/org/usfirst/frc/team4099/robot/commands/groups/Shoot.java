package org.usfirst.frc.team4099.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team4099.robot.commands.Kick;
import org.usfirst.frc.team4099.robot.commands.RunShooterFullSpeed;

public class Shoot extends CommandGroup {

    public Shoot() {
        addParallel(new RunShooterFullSpeed(3.0));
        addSequential(new WaitCommand(2.5));
        addParallel(new Kick());
    }
}
