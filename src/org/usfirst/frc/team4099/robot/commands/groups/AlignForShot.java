package org.usfirst.frc.team4099.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4099.robot.commands.TurnAngle;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;
import org.usfirst.frc.team4099.robot.commands.UpdateVision;
import org.usfirst.frc.team4099.robot.commands.SetRampAngle;
import org.usfirst.frc.team4099.robot.commands.TrajectoryCalculation;

public class AlignForShot extends CommandGroup {

    public AlignForShot() {
        addSequential(new UpdateVision());

        addSequential(new TurnAngle(true));
       
        //ramp adjustment aimassist
        // false means that the angle is turn amount
        addSequential(new SetRampAngle(true));
        addSequential(new TrajectoryCalculation());
        addSequential(new SetRampAngle(true));
    }
}
