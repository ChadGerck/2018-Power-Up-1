package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {

	public static void Auto() {

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
	/*
	 * while(true) { double timer = Robot.myTimer.get(); //leftvalue and
	 * rightvalue from 0-1 Robot.drivetrain.setRaw1(.25, .25);
	 * 
	 * if (timer<10) { Robot.drivetrain.setRaw1(.30, .10); }else if (timer<20){
	 * Robot.drivetrain.setRaw1(.99, .19); }else if (timer<30){
	 * Robot.drivetrain.setRaw1(.5, .5); }else { Robot.drivetrain.setRaw1(.8,
	 * .8);
	 * 
	 * } }
	 */
	// }

	/*
	 * int station = 3; switch(station){ case 1 : Robot.TurnRight();
	 * Robot.TurnRight(); Robot.TurnRight(); Robot.TurnRight(); break; case 2:
	 * Robot.MoveForward(); Robot.MoveForward(); Robot.MoveForward();
	 * Robot.MoveForward(); Robot.TurnRight(); Robot.TurnRight();
	 * Robot.MoveForward(); Robot.MoveForward(); Robot.MoveForward();
	 * Robot.MoveForward(); Robot.TurnRight(); Robot.TurnRight();
	 * Robot.MoveForward(); Robot.MoveForward(); Robot.MoveForward();
	 * Robot.MoveForward(); break; case 3: Robot.TurnRight();
	 * Robot.MoveForward(); Robot.MoveForward(); Robot.MoveForward();
	 * Robot.TurnRight(); Robot.MoveForward(); Robot.MoveForward();
	 * Robot.MoveForward(); Robot.TurnRight(); Robot.MoveForward();
	 * Robot.MoveForward(); Robot.MoveForward(); Robot.TurnRight();
	 * Robot.MoveForward(); Robot.MoveForward(); Robot.MoveForward(); break;
	 * 
	 * } }
	 * 
	 * // other challenge public static void MoveAngle(double angle) {
	 * Robot.drivetrain.setRaw1(.25, .25); double gyroAngle = Robot.GyroAngle();
	 * gyroAngle = Math.toRadians(gyroAngle);
	 * 
	 * try{ Thread.sleep(20); }
	 * 
	 * catch(InterruptedException e){ e.printStackTrace(); } }
	 * 
	 * 
	 * /*int i = 0; while (i <= 54) { Robot.MoveForward(); //sorry; if (i == 27
	 * || i == 54) { Robot.TurnRight(); Robot.TurnRight(); } i++;
	 * 
	 * }
	 * 
	 * int i = 0; while (i < 26) { Robot.MoveForward(); i++; }
	 * Robot.TurnRight(); Robot.TurnRight();
	 * 
	 * i = 0; while (i < 26) { Robot.MoveForward(); i++; } Robot.TurnRight();
	 * Robot.TurnRight();
	 * 
	 * // moveForward(27); // Robot.TurnRight(); // Robot.TurnRight(); //
	 * moveForward(27); // Robot.TurnRight(); Robot.TurnRight();
	 */

	public static void moveForward(int distance) {

	}

	public static void turnRight(int distance) {

	}

	public static void turnAround() {
		turnRight(2);
	}
}
