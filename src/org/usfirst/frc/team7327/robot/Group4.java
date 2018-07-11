package org.usfirst.frc.team7327.robot;

public class Group4 {
	public static void Project2() {
		// While loops
		int i = 0;
		while (i < 25) {
			Robot.MoveForward();
			i = i + 1;
		}

		while (i < 2) {
			Robot.TurnRight();
			i = i + 1;

		}
	}

	public static void Project3() {

		// 1 while loop and if command
		int i = 0;
		while (i < 52) {
			Robot.MoveForward();
			i = i + 1;

			if (i == 25) {
				Robot.TurnRight();
				Robot.TurnRight();
			}
		}
		Robot.TurnRight();
		Robot.TurnRight();
	}

	public static void Project4() {

		// Switch
		int i = 1;
		switch (i) {

		case 1:
			while (i < 10) {
				Robot.MoveForward();
				i = i + 1;
				break;
			}

		case 2:
			while (i < 15) {
				Robot.MoveForward();

				while (i < 2)
					Robot.TurnRight();
				break;

			}

		}

	}

	public static void Project5() {

		// timed if, else if, else
		{
			if(10); {
				Robot.MoveForward();
				
			else if(2) {
				Robot.TurnLeft();
				{else {
					Robot.MoveForward();
					
				}
			}
		
		}
	}
}
