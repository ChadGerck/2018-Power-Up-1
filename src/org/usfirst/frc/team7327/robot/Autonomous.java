package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {

		while (true) {
			double timer = Robot.myTimer.get();
			Robot.drivetrain.setRaw1(.25, .25);

			if (timer < 10) {
				Robot.drivetrain.setRaw1(.50, 0);

			}

			else if (timer < 20) {
				Robot.drivetrain.setRaw1(-.25, .25 );	
			
			}

			else if (timer < 30) 
				Robot.drivetrain.setRaw1(.25, -.25 );
			else {

			}

		}
	}
}
