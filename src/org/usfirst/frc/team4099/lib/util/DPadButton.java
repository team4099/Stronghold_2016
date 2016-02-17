package org.usfirst.frc.team4099.lib.util;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team4099.lib.input.Gamepad;

/**
 * Created by plato2000 on 2/17/16.
 */
public class DPadButton extends Button {

    private Gamepad gamepad;
    private int direction;

    public DPadButton(Gamepad gamepad, int direction) {
        this.gamepad = gamepad;
        this.direction = direction;
    }

    @Override
    public boolean get() {
        return gamepad.getPOV() == direction;
    }
}
