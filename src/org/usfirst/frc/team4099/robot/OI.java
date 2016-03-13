package org.usfirst.frc.team4099.robot;

import org.usfirst.frc.team4099.lib.input.Attack3;
import org.usfirst.frc.team4099.lib.input.Extreme3DJoystick;
import org.usfirst.frc.team4099.lib.input.Gamepad;
import org.usfirst.frc.team4099.lib.util.Constants;
import org.usfirst.frc.team4099.lib.util.DPadButton;
import org.usfirst.frc.team4099.lib.util.Direction;
import org.usfirst.frc.team4099.lib.util.IOButton;
import org.usfirst.frc.team4099.robot.commands.ChangeRampHeight;
import org.usfirst.frc.team4099.robot.commands.DriveBackward;
import org.usfirst.frc.team4099.robot.commands.DriveForward;
import org.usfirst.frc.team4099.robot.commands.IntakeDown;
import org.usfirst.frc.team4099.robot.commands.IntakeUp;
import org.usfirst.frc.team4099.robot.commands.SetRampAngle;
import org.usfirst.frc.team4099.robot.commands.TurnLeft;
import org.usfirst.frc.team4099.robot.commands.TurnRight;
import org.usfirst.frc.team4099.robot.commands.groups.AlignForShot;
import org.usfirst.frc.team4099.robot.commands.groups.Shoot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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
    private Button ttck3button, ttck3button2;
    
    private Extreme3DJoystick edgyStick;
    private Button EDGY_BUTTON1;
    private Button EDGY_BUTTON2;
    private Button EDGY_BUTTON3;
    private Button EDGY_BUTTON4;
    private Button EDGY_BUTTON5;
    private Button EDGY_BUTTON6;
    private Button EDGY_BUTTON7;
    private Button EDGY_BUTTON9;
    private Button EDGY_BUTTON10;
    private Button EDGY_BUTTON11;


    public OI() {
        gamepad = new Gamepad(0);
        flightStick = new Attack3(1);

        A_BUTTON = new JoystickButton(gamepad, Gamepad.A_BUTTON);
        B_BUTTON = new JoystickButton(gamepad, Gamepad.B_BUTTON);
        X_BUTTON = new JoystickButton(gamepad, Gamepad.X_BUTTON);
        Y_BUTTON = new JoystickButton(gamepad, Gamepad.Y_BUTTON);
        ttck3button = new JoystickButton(flightStick, Attack3.BUTTON_4);
        ttck3button.whenPressed(new IntakeDown());
        ttck3button2 = new JoystickButton(flightStick, Attack3.BUTTON_5);
        ttck3button2.whenPressed(new IntakeUp());
        
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
        

        EDGY_BUTTON1 = new JoystickButton(edgyStick, 1);
        EDGY_BUTTON2 = new JoystickButton(edgyStick, 2);
        EDGY_BUTTON3 = new JoystickButton(edgyStick, 3);
        EDGY_BUTTON4 = new JoystickButton(edgyStick, 4);
        EDGY_BUTTON5 = new JoystickButton(edgyStick, 5);
        EDGY_BUTTON6 = new JoystickButton(edgyStick, 6);
        EDGY_BUTTON7 = new JoystickButton(edgyStick, 7);
        EDGY_BUTTON9 = new JoystickButton(edgyStick, 9);
        EDGY_BUTTON10 = new JoystickButton(edgyStick, 10);
        EDGY_BUTTON11 = new JoystickButton(edgyStick, 11);

        /** COMMANDS */
        // gamepad
        X_BUTTON.whenPressed(new AlignForShot());//);
        //B_BUTTON.whenPressed(new Shoot());
        Y_BUTTON.whileHeld(new ChangeRampHeight(Direction.Ramp.UP));
        A_BUTTON.whileHeld(new ChangeRampHeight(Direction.Ramp.DOWN));
        START_BUTTON.whenPressed(new SetRampAngle(Constants.DEFAULT_RAMP_ANGLE));
//        BACK_BUTTON.whenPressed(new TurnAngle(90));
        EAST_BUTTON.whileHeld(new TurnRight(Constants.DPAD_TURN_SPEED));
        WEST_BUTTON.whileHeld(new TurnLeft(Constants.DPAD_TURN_SPEED));
        NORTH_BUTTON.whileHeld(new DriveForward(Constants.DPAD_MOVE_SPEED));
        SOUTH_BUTTON.whileHeld(new DriveBackward(Constants.DPAD_MOVE_SPEED));
        
        
//        EDGY_BUTTON1.whenPressed(new Shoot());
//        EDGY_BUTTON2.whenPressed(new AlignForShot());
//        EDGY_BUTTON3.whenPressed(new SetRampAngle(Constants.DEFAULT_RAMP_ANGLE));
//        EDGY_BUTTON4.whileHeld(new ChangeRampHeight(Direction.Ramp.DOWN));
//        EDGY_BUTTON5.whenPressed(new TurnToAngle(0));
//        EDGY_BUTTON6.whileHeld(new ChangeRampHeight(Direction.Ramp.UP));
//        EDGY_BUTTON7.whenPressed(new SetGearMode(0));
//        EDGY_BUTTON9.whenPressed(new SetGearMode(1));
//        EDGY_BUTTON10.whenPressed(new ReverseOrientation());
//        EDGY_BUTTON11.whenPressed(new SetGearMode(2));
        

//        TRIPWIRE_BUTTON.whenPressed(new IntakeUp());

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
    
    public Extreme3DJoystick getExtreme3D() {
        return this.edgyStick;
    }
}

