package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		double timer = Robot.myTimer.get(); 
		while (true) {
			Robot.drivetrain.setRaw1(.1, .1);

			 if ( timer < 10) {
			Robot.drivetrain.setRaw1(.25, .25);}
			 
			 if (timer < 20) {
			Robot.drivetrain.setRaw1(.50, .50);}
			 
			 if (timer < 30) {
			Robot.drivetrain.setRaw1(0, 0); }
			 
			 if (timer < 40) {
			Robot.drivetrain.setRaw1(-.50, -.50); }
			 
			 if (timer < 50) {
			Robot.drivetrain.setRaw1(-.25, -.25); }
			 
			 if (timer < 60) {
			Robot.drivetrain.setRaw1(-.1, -.1); }
			 
			 if (timer < 70) {
			Robot.drivetrain.setRaw1(0, 0); }

		}
	}
}
