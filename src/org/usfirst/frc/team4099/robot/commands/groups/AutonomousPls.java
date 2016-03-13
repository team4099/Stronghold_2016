package org.usfirst.frc.team4099.robot.commands.groups;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.robot.commands.*;
public class AutonomousPls extends CommandGroup {
	public AutonomousPls() {
		addParallel(new IntakeDown());
		addSequential(new SetRampAngle(Constants.RAMP_LOWER_LIMIT));
		addSequential(new DriveForward(0.75, 5));
		/*
		addSequential(new AlignForShot());
		addSequential(new Shoot());
		*/
	}
}
