package org.usfirst.frc.team4099.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team4099.lib.input.Gamepad;
import org.usfirst.frc.team4099.robot.commands.RunShooterFullSpeed;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private Gamepad gamepad0;
    private Gamepad gamepad1;
    private Button A_BUTTON;
    private Button B_BUTTON;
    private Button X_BUTTON;
    private Button Y_BUTTON;
    private Button RIGHT_BUTTON;

    public OI() {
        gamepad0 = new Gamepad(0);

        // TODO: make this thing do stuff like manual control for ramp
        gamepad1 = new Gamepad(1);

        A_BUTTON = new JoystickButton(gamepad0, Gamepad.A_BUTTON);
        B_BUTTON = new JoystickButton(gamepad0, Gamepad.B_BUTTON);
        X_BUTTON = new JoystickButton(gamepad0, Gamepad.X_BUTTON);
        Y_BUTTON = new JoystickButton(gamepad0, Gamepad.Y_BUTTON);
        RIGHT_BUTTON = new JoystickButton(gamepad0, Gamepad.RIGHT_SHOULDER_BUTTON);

        /* Commands */
        Y_BUTTON.whileHeld(new RunShooterFullSpeed());
        RIGHT_BUTTON.whileHeld(new RunShooterFullSpeed());
//        Y_BUTTON.whenPressed(new ElevatorToPosition(Elevator.TOP));
//        A_BUTTON.whenPressed(new ElevatorToPosition(Elevator.BOTTOM));
//        B_BUTTON.whenPressed(new ElevatorToPosition(Elevator.MIDDLE));
    }

    public Gamepad getGamepad0() {
        return gamepad0;
    }
    public Gamepad getGamepad1() { return gamepad1; }
}

