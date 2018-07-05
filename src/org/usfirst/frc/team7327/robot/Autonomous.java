package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {

		int station = 1;
		switch (station) {
		case 1:
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.TurnRight();
			break;
		case 2:
			int i = 0;
			while (i < 10) {
				Robot.MoveForward();
				i = i + 1;
			
			}
			break;
		case 3:
			int k = 0;
			while (k < 15) {
				Robot.MoveForward();
				k = k + 1;

				Robot.TurnLeft();
				break;
			}

		}
	}
}
