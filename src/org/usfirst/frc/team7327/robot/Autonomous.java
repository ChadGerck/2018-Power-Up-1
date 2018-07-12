package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {

		while (true) {
			double timer = Robot.myTimer.get();

			if (timer < 10) {
				Robot.drivetrain.setRaw1(.27, .27);
		
			}

			else if (timer < 16) {
				Robot.TurnRight();
			} else if (timer < 30) {
				Robot.drivetrain.setRaw1(.35, .35);
				Robot.MoveForward();
			}

			else {
				Robot.drivetrain.setRaw1(0, 0);
			}

		}
	}
}
