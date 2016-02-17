package org.usfirst.frc.team4099.lib.util;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team4099.lib.input.Gamepad;

/**
 * Created by plato2000 on 2/17/16.
 */
public class AxisButton extends Button {

    private int axisNumber;
    private Gamepad gamepad;
    private double threshold;
    boolean higherThanThreshold;

    public AxisButton(int axisNumber, Gamepad gamepad, double threshold, boolean higherThanThreshold) {
        this.gamepad = gamepad;
        this.axisNumber = axisNumber;
        this.threshold = threshold;
        this.higherThanThreshold = higherThanThreshold;
    }

    @Override
    public boolean get() {
        if(higherThanThreshold) {
            return gamepad.getRawAxis(axisNumber) >= threshold;
        } else {
            return gamepad.getRawAxis(axisNumber) <= threshold;
        }
    }

}
