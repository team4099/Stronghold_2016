package org.usfirst.frc.team4099.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team4099.lib.input.Gamepad;
import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private Gamepad gamepad;

    public OI() {
         gamepad = new Gamepad(0);
    }

    public Gamepad getGamepad() {
        return gamepad;
    }
}

