package org.usfirst.frc.team4099.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc.team4099.lib.input.Attack3;
import org.usfirst.frc.team4099.lib.input.Gamepad;
import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.lib.util.DPadButton;
import org.usfirst.frc.team4099.lib.util.Direction;
import org.usfirst.frc.team4099.lib.util.IOButton;
import org.usfirst.frc.team4099.robot.commands.*;
import org.usfirst.frc.team4099.robot.commands.groups.*;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team4099.robot.commands.groups.Shoot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private Gamepad gamepad;
    private Button A_BUTTON;
    private Button B_BUTTON;
    private Button X_BUTTON;
    private Button Y_BUTTON;
    private Button RIGHT_BUTTON;
    private DPadButton UP_BUTTON;
    private DPadButton DOWN_BUTTON;
    private Button SHOOT_BUTTON;
    private Button RAISE_SHOOTER_BUTTON;
    private Button LOWER_SHOOTER_BUTTON;
    private IOButton TRIPWIRE_BUTTON;

    private Attack3 flightStick;

    private Button START_BUTTON;

    private DPadButton EAST_BUTTON, WEST_BUTTON;

    public OI() {
        gamepad = new Gamepad(0);
        flightStick = new Attack3(1);

        A_BUTTON = new JoystickButton(gamepad, Gamepad.A_BUTTON);
        B_BUTTON = new JoystickButton(gamepad, Gamepad.B_BUTTON);
        X_BUTTON = new JoystickButton(gamepad, Gamepad.X_BUTTON);
        Y_BUTTON = new JoystickButton(gamepad, Gamepad.Y_BUTTON);
        RIGHT_BUTTON = new JoystickButton(gamepad, Gamepad.RIGHT_SHOULDER_BUTTON);
        UP_BUTTON = new DPadButton(gamepad, Gamepad.DPAD_NORTH);
        DOWN_BUTTON = new DPadButton(gamepad, Gamepad.DPAD_SOUTH);

        EAST_BUTTON = new DPadButton(gamepad, Gamepad.DPAD_EAST);
        WEST_BUTTON = new DPadButton(gamepad, Gamepad.DPAD_WEST);
        START_BUTTON = new JoystickButton(gamepad, Gamepad.START_BUTTON);
        SHOOT_BUTTON = new JoystickButton(flightStick, Attack3.INDEX_TRIGGER);
        TRIPWIRE_BUTTON = new IOButton(new DigitalInput(Constants.INTAKE_TRIPWIRE_PORT), false);


        /** COMMANDS */
        // gamepad
        X_BUTTON.whenPressed(new AlignForShot());
        B_BUTTON.whenPressed(new Shoot());
        Y_BUTTON.whileHeld(new ChangeRampHeight(Direction.UP));
        A_BUTTON.whileHeld(new ChangeRampHeight(Direction.DOWN));
        START_BUTTON.whenPressed(new SetRampAngle(Constants.DEFAULT_RAMP_ANGLE));

        TRIPWIRE_BUTTON.whenPressed(new IntakeUp());
        UP_BUTTON.whileHeld(new ControlIntake(Direction.UP));
        DOWN_BUTTON.whileHeld(new ControlIntake(Direction.DOWN));

        // flight stick
    }

    public Gamepad getGamepad() {
        return gamepad;
    }

    public Attack3 getFlightStick() {
        return flightStick;
    }
}

