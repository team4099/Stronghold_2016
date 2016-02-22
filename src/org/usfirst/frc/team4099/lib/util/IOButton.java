package org.usfirst.frc.team4099.lib.util;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogInput;

/**
 * Created by plato2000 on 2/17/16.
 */
public class IOButton extends Button {

    private DigitalInput input;
    private boolean inverted;
    
    public IOButton(DigitalInput input, boolean inverted) {
        this.input = input;
        this.inverted = inverted;
    }

    @Override
    public boolean get() {
        return input.get();
    }
}
