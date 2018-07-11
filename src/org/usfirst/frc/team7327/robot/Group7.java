package org.usfirst.frc.team7327.robot;

public class Group7 {
	public static void Project2() {
		// while loops
		int i = 0;
		while (i < 26) {
			Robot.MoveForward();
			i++;
		}
	}

	public static void Project3() {
		// 1 while loop and if command
		int i = 0;
		while (i < 52) {
			Robot.MoveForward();
			i++;
			if (i == 26) {
				Robot.TurnRight();
				Robot.TurnRight();
			}
			if (i == 52) {
				Robot.TurnRight();
				Robot.TurnRight();
			}
		}
	}

	public static void Project4(int station) {
		// switch
		switch (station) {
		case 1:
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.TurnRight();
			break;
		case 2:
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			break;
		case 3:
			Robot.TurnRight();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.TurnRight();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.TurnRight();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.TurnRight();
			Robot.MoveForward();
			Robot.MoveForward();
			break;
		}

	}

	public static void Project5() {
		// timed if, else if, else
		while (true) {
			double timer = Robot.myTimer.get();
			if (timer > 2) {
				Robot.drivetrain.setRaw1(.2, .2);
			} else if (timer > 4) {
				Robot.drivetrain.setRaw1(.4, .4);
			} else if (timer > 6) {
				Robot.drivetrain.setRaw1(.6, .6);
			} else if (timer > 8)
				Robot.drivetrain.setRaw1(.4, .4);
			else if (timer > 10) {
				Robot.drivetrain.setRaw1(.2, .2);
			} else if (timer > 12) {
				Robot.drivetrain.setRaw1(0, 0);
			} else if (timer > 14) {
				Robot.drivetrain.setRaw1(-.2, -.2);
			} else if (timer > 16) {
				Robot.drivetrain.setRaw1(-.4, -.4);
			} else if (timer > 18)
				Robot.drivetrain.setRaw1(-.6, -.6);
			else if (timer > 20) {
				Robot.drivetrain.setRaw1(-.4, -.4);
			} else if (timer > 22) {
				Robot.drivetrain.setRaw1(-.2, -.2);
			} else {
				Robot.drivetrain.setRaw1(0, 0);
			}
		}
	}

	public void AccelerateIG() {
		while (true) {
			double timer = Robot.myTimer.get();
			if (timer > 2) {
				Robot.drivetrain.setRaw1(.2, .2);
			} else if (timer > 4) {
				Robot.drivetrain.setRaw1(.4, .4);
			}
		}
	}
}
