package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		int station = 2;
		int i = 0;
		switch (station) {
		case 1:
			Robot.TurnLeft();
			Robot.TurnLeft();
			Robot.TurnLeft();
			Robot.TurnLeft();
			break;

		case 2:
			while (i < 2) {
				Robot.TurnRight();
				i++;
			}
			i = 0;
			while (i < 4) {
				Robot.MoveForward();
				i++;
			}

			Robot.TurnRight();
			Robot.TurnLeft();
			Robot.TurnLeft();
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.TurnLeft();

			break;

		case 3:
			Robot.TurnLeft();
			Robot.TurnLeft();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			i = 0;
			while (i < 4) {
				Robot.TurnRight();
				i++;
			}

			Robot.TurnLeft();
			Robot.MoveForward();

		}
	}
}
