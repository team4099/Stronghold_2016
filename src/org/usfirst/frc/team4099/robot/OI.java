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
    private Button SHOOT_BUTTON;
    private DPadButton EAST_BUTTON, WEST_BUTTON;
    private DPadButton NORTH_BUTTON, SOUTH_BUTTON;
    private Button START_BUTTON, BACK_BUTTON;
    private IOButton TRIPWIRE_BUTTON;

    private Attack3 flightStick;
    private Button RAISE_SHOOTER_BUTTON;
    private Button LOWER_SHOOTER_BUTTON;


    public OI() {
        gamepad = new Gamepad(0);
        flightStick = new Attack3(1);

        A_BUTTON = new JoystickButton(gamepad, Gamepad.A_BUTTON);
        B_BUTTON = new JoystickButton(gamepad, Gamepad.B_BUTTON);
        X_BUTTON = new JoystickButton(gamepad, Gamepad.X_BUTTON);
        Y_BUTTON = new JoystickButton(gamepad, Gamepad.Y_BUTTON);
        RIGHT_BUTTON = new JoystickButton(gamepad, Gamepad.RIGHT_SHOULDER_BUTTON);

        NORTH_BUTTON = new DPadButton(gamepad, Gamepad.DPAD_NORTH);
        SOUTH_BUTTON = new DPadButton(gamepad, Gamepad.DPAD_SOUTH);
        EAST_BUTTON = new DPadButton(gamepad, Gamepad.DPAD_EAST);
        WEST_BUTTON = new DPadButton(gamepad, Gamepad.DPAD_WEST);

        START_BUTTON = new JoystickButton(gamepad, Gamepad.START_BUTTON);
        BACK_BUTTON = new JoystickButton(gamepad, Gamepad.BACK_BUTTON);
        SHOOT_BUTTON = new JoystickButton(flightStick, Attack3.INDEX_TRIGGER);

        TRIPWIRE_BUTTON = new IOButton(new DigitalInput(Constants.INTAKE_TRIPWIRE_PORT), false);

        RAISE_SHOOTER_BUTTON = new JoystickButton(flightStick, Attack3.BUTTON_3);
        LOWER_SHOOTER_BUTTON = new JoystickButton(flightStick, Attack3.BUTTON_2);

        /** COMMANDS */
        // gamepad
        X_BUTTON.whenPressed(new AlignForShot());
        //B_BUTTON.whenPressed(new Shoot());
        Y_BUTTON.whileHeld(new ChangeRampHeight(Direction.Ramp.UP));
        A_BUTTON.whileHeld(new ChangeRampHeight(Direction.Ramp.DOWN));
        START_BUTTON.whenPressed(new SetRampAngle(Constants.DEFAULT_RAMP_ANGLE));
        BACK_BUTTON.whenPressed(new TurnAngle(90));
        EAST_BUTTON.whileHeld(new TurnRight(Constants.DPAD_TURN_SPEED));
        WEST_BUTTON.whileHeld(new TurnLeft(Constants.DPAD_TURN_SPEED));
        NORTH_BUTTON.whileHeld(new DriveForward(Constants.DPAD_MOVE_SPEED));
        SOUTH_BUTTON.whileHeld(new DriveBackward(Constants.DPAD_MOVE_SPEED));

        TRIPWIRE_BUTTON.whenPressed(new IntakeUp());

        // flight stick
        RAISE_SHOOTER_BUTTON.whileHeld(new ChangeRampHeight(Direction.Ramp.UP));
        LOWER_SHOOTER_BUTTON.whileHeld(new ChangeRampHeight(Direction.Ramp.DOWN));
        SHOOT_BUTTON.whenPressed(new Shoot());

    }

    public Gamepad getGamepad() {
        return gamepad;
    }

    public Attack3 getFlightStick() {
        return flightStick;
    }
}

