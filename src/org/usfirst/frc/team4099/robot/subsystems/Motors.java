package org.usfirst.frc.team4099.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4099.lib.util.Limiter;

import java.util.HashMap;

public class Motors extends Subsystem {
    public HashMap<String, SpeedController> motors = new HashMap<String, SpeedController>();

    public Motors() {}

    public Motors(String[] names, SpeedController[] controllers) {
        if (names.length != controllers.length)
            throw new IllegalArgumentException("[!!][init][Motors] names.length != controllers.length!");
        for (int i = 0; i < names.length; i++)
            motors.put(names[i], controllers[i]);
        System.out.println("[DEBUG][init][Motors] Initialized motors successfully.");
    }

    @Override
    protected void initDefaultCommand() {}

    public void addMotor(String name, SpeedController controller) {
        motors.put(name, controller);
    }

    public SpeedController getMotorByName(String name) {
        if (!motors.containsKey(name))
            throw new IllegalArgumentException(String.format("[!!][Motors] motor '%s' does not exist", name));
        return motors.get(name);
    }

    public void setMotorInversionState(String name, boolean state) {
        getMotorByName(name).setInverted(state);
    }

    public void setMotorSpeed(String name, double speed) {
        speed = Limiter.limitSpeed(speed);
        getMotorByName(name).set(speed);
    }
}
