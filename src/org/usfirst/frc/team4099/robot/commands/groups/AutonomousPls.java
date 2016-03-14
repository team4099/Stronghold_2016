package org.usfirst.frc.team4099.robot.commands.groups;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.robot.commands.*;
public class AutonomousPls extends CommandGroup {
	public AutonomousPls() {
		addParallel(new IntakeDown());
		addSequential(new SetRampAngle(Constants.RAMP_LOWER_LIMIT));
		addSequential(new DriveForward(0.75, 2));
		addSequential(new SetRampAngle((Constants.RAMP_UPPER_LIMIT - Constants.RAMP_LOWER_LIMIT)/2 + Constants.RAMP_LOWER_LIMIT));
		addSequential(new TurnAngle(15));
		//addSequential(new SetRampAngle(Constants.RAMP_UPPER_LIMIT-5)); //temp ramp raise
		
		//added for auto aim assist
		addSequential(new AlignForShot());
		addSequential(new Shoot());
		
	}
}