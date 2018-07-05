package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		int i = 0;
		while (i < 52) {
			Robot.MoveForward();
			i++;
			if (i == 26) {
				TurnAround();
			}
		}
	}

	public static void MoveForward(int distance) {
		int i = 0;
		while (i < distance) {
			Robot.MoveForward();
			i++;
		}
	}

	public static void TurnAround() {
		Robot.TurnRight();
		Robot.TurnRight();
	}
}
