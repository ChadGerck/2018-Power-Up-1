package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		int d = 0;

		if(d == 25) {
			Robot.TurnLeft();
			Robot.TurnLeft();
			
		}
		while (d < 26) {
			Robot.MoveForward();
			d = d + 1;
		}
	}
		
	    

	public static void MoveForward(int distance) {
		int i = 0;
		while (i < distance) {

		}

	}
}