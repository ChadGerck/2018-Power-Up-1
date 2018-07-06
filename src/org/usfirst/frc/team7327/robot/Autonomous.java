package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		double timer = Robot.myTimer.get();
		if(timer < 5) {
			Robot.drivetrain.setRaw1(.75, .375);
		}
		else if (timer < 10) {
			Robot.drivetrain.setRaw1(-.25, .5); 
		}
		else if (timer < 15) {
			Robot.drivetrain.setRaw1(.5, -.25);
		}
		else {
			Robot.drivetrain.setRaw1(0, .0);
		}
	}
	
	public static void TurnAround() {
		Robot.TurnRight();
		Robot.TurnRight();
	}
}