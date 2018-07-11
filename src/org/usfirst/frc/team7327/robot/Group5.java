package org.usfirst.frc.team7327.robot;

public class Group5 {
	private static Object Project3;

	public static void Project2() {
		int i = 0;
		while (i < 10) {
			Robot.MoveForward();
			i++;
		}

		Robot.TurnLeft();
		Robot.TurnLeft();
		{
			while (i < 10) {
				Robot.MoveForward();
			}

		}

	}

	public static void Project3() {
		int i = 0;
		while (i < 10) {
			Robot.MoveForward();
			i++;
		}
		if (i <= 10) {
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.TurnLeft();
		}
	}

	public static void Project4() {
		int i = 0;

		int station = 1;
		switch (station) {
		case 1:
			while (i < 5) {
				Robot.MoveForward();
			}
			Robot.TurnLeft();
			Robot.TurnLeft();
			Robot.TurnLeft();
			break;

		case 2:
			while (i < 10) {
				Robot.MoveForward();
			}
			Robot.TurnLeft();
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.TurnLeft();
			break;

		case 3:
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.TurnLeft();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.TurnLeft();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.TurnRight();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();

		}
	}

	public static void Project5() {

		double clock = Robot.myTimer.get();

		while (true) {
			if (clock < 10) {
				Robot.MoveForward();
				Robot.drivetrain.setRaw1(.25, .25);
			}

			else if (clock > 10) {
				Robot.MoveForward();
				Robot.drivetrain.setRaw1(.75, .75);
			}

			else {
				Robot.drivetrain.setRaw1(0, .25);
				Robot.drivetrain.setRaw1(0, 0); 
				//A whim away, a whim away, a whim away 
				//Deep in the jungle, the mighty jungle, a lion sleeps toniiightt
			}

		}
	}
}
