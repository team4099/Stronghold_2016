package org.usfirst.frc.team4099.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4099.robot.commands.SetRampAngle;
import org.usfirst.frc.team4099.robot.commands.TurnAngle;
import org.usfirst.frc.team4099.robot.commands.UpdateVision;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class TurnToAngle extends CommandGroup {

    public TurnToAngle(double angleToTurnTo) {
        addSequential(new TurnAngle(angleToTurnTo - CommandBase.navX.getAngle()));
    }
}
