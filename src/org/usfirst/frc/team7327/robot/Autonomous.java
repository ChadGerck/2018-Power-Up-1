package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		double timer = Robot.myTimer.get();
		if(timer < 0.5) {
			Robot.drivetrain.setRaw(0, 0, .25);
		}
		else if (timer < 1) {
			Robot.drivetrain.setRaw(0, 0, -.25); 
		}
		else if (timer < 2) {
			Robot.drivetrain.setRaw1(0, 0);
		}
		else {
			Robot.drivetrain.setRaw1(0, .0);
		}
	}
	
	public static void TurnAround() {
		Robot.TurnRight();
		Robot.TurnRi
		ght();
	}
}