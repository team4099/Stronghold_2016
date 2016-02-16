package org.usfirst.frc.team4099.robot;

import org.usfirst.frc.team4099.lib.input.Gamepad;
import org.usfirst.frc.team4099.lib.util.RampMoveEnum;
import org.usfirst.frc.team4099.robot.commands.ChangeRampHeight;
import org.usfirst.frc.team4099.robot.commands.IntakeUp;
import org.usfirst.frc.team4099.robot.commands.Kick;
import org.usfirst.frc.team4099.robot.commands.RunShooterFullSpeed;
import org.usfirst.frc.team4099.robot.commands.SetRampAngle;

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
    
    private Button START_BUTTON;

    public OI() {
        gamepad = new Gamepad(0);
        A_BUTTON = new JoystickButton(gamepad, Gamepad.A_BUTTON);
        B_BUTTON = new JoystickButton(gamepad, Gamepad.B_BUTTON);
        X_BUTTON = new JoystickButton(gamepad, Gamepad.X_BUTTON);
        Y_BUTTON = new JoystickButton(gamepad, Gamepad.Y_BUTTON);
        RIGHT_BUTTON = new JoystickButton(gamepad, Gamepad.RIGHT_SHOULDER_BUTTON);
        
        START_BUTTON = new JoystickButton(gamepad, Gamepad.START_BUTTON);

        /* Commands */
        B_BUTTON.whileHeld(new RunShooterFullSpeed());

        Y_BUTTON.whileHeld(new ChangeRampHeight(RampMoveEnum.UP));
        A_BUTTON.whileHeld(new ChangeRampHeight(RampMoveEnum.DOWN));
        Gamepad gamepad2 = new Gamepad(1);
        Button fireButton = new JoystickButton(gamepad2, 2);
        fireButton.whileHeld(new Kick());

        START_BUTTON.whenPressed(new SetRampAngle(45));
        
        //RIGHT_BUTTON.whenPressed(new IntakeUp());
        X_BUTTON.whenPressed(new IntakeUp());
    }

    public Gamepad getGamepad() {
        return gamepad;
    }
}

