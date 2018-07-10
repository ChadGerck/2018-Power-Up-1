package org.usfirst.frc.team7327.robot;

public class Group2 {

	public static void Project2() {

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

			i = i + 1;
		}

	}

	public static void Project3() {

		int i = 0;
		while (i < 52) {

			Robot.MoveForward();

			i = i + 1;

			if (i == 25) {

				Robot.TurnLeft();
				Robot.TurnLeft();
			}
		}

	}

	public static void Project4(int station) {

		switch (station) {

		case 1:
			Robot.MoveForward();
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.MoveForward();
			break;

		case 2:
			Robot.MoveForward();
			Robot.TurnLeft();
			Robot.TurnRight();
			Robot.MoveForward();
			break;
			
			
		case 3:
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.TurnRight();
			Robot.TurnLeft();
			break;
			
			default:
				break;

		}

	}

	public static void Project5() {

		while (true) {

			double timer = Robot.myTimer.get();

			if (timer < 5) {

				Robot.drivetrain.setRaw1(.25, .25);
				
			} else if (timer < 10) {

				Robot.drivetrain.setRaw1(.55, .55);

			} else if (timer < 15) {

				Robot.drivetrain.setRaw1(.60, .60);

			} else {
				Robot.drivetrain.setRaw1(0, 0);

			}
		}
	}

}
