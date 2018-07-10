package org.usfirst.frc.team7327.robot;

public class Group1 {
	public static void Project2() {
		// While loops
		int i = 0;
		while (i < 26) {
			Robot.MoveForward();
			i = i + 1;

		}
		Robot.TurnRight();
		Robot.TurnRight();
		i = 0;
		while (i < 26) {
			Robot.MoveForward();
			i++;

		}
		Robot.TurnRight();
		Robot.TurnRight();
	}

	public static void Project3() {
		// 1 while loop and if command
		int i = 0;
		while (i < 52) {
			Robot.MoveForward();
			i++;
			if (i == 19) {
				Robot.TurnRight();
				Robot.TurnRight();
			}
		}
	}

	public static void Project4() {

		// Switch
		int station = 1;
		switch (station) {
		case 1:
			break;

		}
	}

	public static void project5() {
		while (true) {
			double timer = Robot.myTimer.get();

			if (timer < 10) {
				Robot.drivetrain.setRaw1(.25, .25);
			} else if (timer < 20) {
				Robot.drivetrain.setRaw1(.05, .05);
			} else if (timer < 30) {

			} else {
				Robot.drivetrain.setRaw1(0, 0);

			}
		}
	}
}
