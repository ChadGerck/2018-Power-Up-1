package org.usfirst.frc.team7327.robot;

public class Group3 {
	public static void Project2() {
		int count = 0;
		while (count < 26) {
			Robot.MoveForward();
			count++;
		}
			Robot.TurnRight();
			Robot.TurnRight();
		while (count < 54) {
			Robot.MoveForward();
			count++;
		}
	}
	public static void Project3() {
		int fas = 0;
		while (fas < 40) {
			Robot.MoveForward();
			if (fas == 20) {
				Robot.TurnRight();
				Robot.TurnRight();
			}
			fas++;
		}
	}
	public static void Project4() {
		int station = 4;
		switch (station) {
		case 1:
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			break;
		case 2:
			Robot.TurnRight();
			Robot.TurnRight();
			break;
		case 3:
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			break;
		}
	}
	public static void Project5() {
		while (true) {
			double timer = Robot.myTimer.get();
			if (timer < 5) {
				Robot.drivetrain.setRaw1(.20, .20);
			} else if (timer < 10) {
				Robot.drivetrain.setRaw1(.25, .25);
			} else if (timer < 15) {
				Robot.drivetrain.setRaw1(.20, .20);
			} else {
				Robot.drivetrain.setRaw1(0, 0);
				break; 
			}
		}
	}
}
