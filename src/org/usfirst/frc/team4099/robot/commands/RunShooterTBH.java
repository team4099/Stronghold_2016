package org.usfirst.frc.team4099.robot.commands;

import org.usfirst.frc.team4099.robot.subsystems.CommandBase;

public class RunShooterTBH extends CommandBase {

	double targetSpeed;
	double currentSpeed;
	double prevPwr;
	double currentPwr;
	double prevError;
	double gain;

	public RunShooterTBH(double targetSpeed) {
		requires(shooter);
		this.targetSpeed = targetSpeed;
		currentSpeed = prevPwr = currentPwr = prevError = 0;
		gain = .5;
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		currentPwr += (targetSpeed - currentSpeed)*gain;
		//shooter.prepShoot(currentPwr);
		// get current speed here
		if ((int) Math.signum(targetSpeed-currentSpeed) != prevError) {
			prevError = (int) Math.signum(targetSpeed-currentSpeed);
			currentPwr = prevPwr = (currentPwr + prevPwr)*.5;
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}
}
