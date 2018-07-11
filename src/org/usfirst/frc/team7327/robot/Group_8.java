package org.usfirst.frc.team7327.robot;

public class Group_8 {
	public static void Project2() {
		int i = 0;
		while (i < 26) {
			Robot.MoveForward();
			i++;
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
		int i = 0;
		while (i <= 54) {
			Robot.MoveForward();
			if (i == 27 || i == 54) {
				Robot.TurnRight();
				Robot.TurnRight();
			}
			i++;

		}
	}

	public static void Project4() {
		int station = 3;
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
			Robot.MoveForward();
			Robot.TurnRight();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.TurnRight();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.TurnRight();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			break;
		}
	}

	public static void Project5() {
		while (true) {
			double timer = Robot.myTimer.get();
			// leftvalueandrightvalue from 0-1
			Robot.drivetrain.setRaw1(.25, .25);
			if (timer < 10) {
				Robot.drivetrain.setRaw1(.30, .10);
			} else if (timer < 20) {
				Robot.drivetrain.setRaw1(.99, .19);
			} else if (timer < 30) {
				Robot.drivetrain.setRaw1(.5, .5);
			} else {
				Robot.drivetrain.setRaw1(.8, .8);
			}

		}
	}
	public static void Accelarater(){
		while (true) {
			double timer = Robot.myTimer.get();
			// Robot.drivetrain.setRaw1(.2, .2);
			if (timer < 1) {
				Robot.drivetrain.setRaw1(.2, .2);
			} else if (timer < 2) {
				Robot.drivetrain.setRaw1(.4, .4);
			} else if (timer < 3) {
				Robot.drivetrain.setRaw1(.6, .6);
			} else if (timer < 4) {
				Robot.drivetrain.setRaw1(.4, .4);
			} else if (timer < 5) {
				Robot.drivetrain.setRaw1(.2, .2);
			} else if (timer < 6) {
				Robot.drivetrain.setRaw1(.0, .0);
			} else if (timer < 7) {
				Robot.drivetrain.setRaw1(-.2, -.2);
			} else if (timer < 8) {
				Robot.drivetrain.setRaw1(-.4, -.4);
			} else if (timer < 9) {
				Robot.drivetrain.setRaw1(-.6, -.6);
			}else if (timer < 10){
				Robot.drivetrain.setRaw1(-.4, -.4);
			}else if (timer < 11){
				Robot.drivetrain.setRaw1(-.2, -.2);
			} else {
				Robot.drivetrain.setRaw1(0, 0); 
			}
		}
	}
}