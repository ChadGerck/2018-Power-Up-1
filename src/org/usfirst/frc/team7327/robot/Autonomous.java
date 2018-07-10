package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		
		Group2.Project4(1);

		while (true) {
			
			double timer = Robot.myTimer.get();
			
			Robot.drivetrain.setRaw1(.25, .25);
			
			
			if (timer < 10) {
				
			} else if (timer < 20) {
		
			} else if (timer < 30) {
				
			} else {
				Robot.drivetrain.setRaw1(0, 0);
			}
			
			
			Robot.drivetrain.setRaw1(.20, .20);
			
			
			if (timer < 20) {

			} else if (timer < 25) {

			} else if (timer < 30) {

			}
			else {
				
			}

		}
	}

	/*
	 * int station = 2; switch(station){ case 1: Robot.MoveForward();
	 * Robot.TurnRight(); Robot.MoveForward(); Robot.TurnRight(); break; case 2:
	 * Robot.TurnLeft(); Robot.MoveForward(); Robot.TurnLeft();
	 * Robot.MoveForward(); break;
	 * 
	 * case 3: Robot.TurnLeft(); Robot.TurnRight(); Robot.TurnLeft();
	 * Robot.TurnRight(); break;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * int i = 0; while (i<52){ Robot.MoveForward(); i++; if(i==25){
	 * Robot.TurnRight(); Robot.TurnRight(); } }
	 */

	public static void MoveForward(int distance) {
		int i = 0;
		while (i < 26) {
			Robot.MoveForward();
			i = i + 1;

		}
	}
}
