package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {

		int i = 0;
		while (i < 52){
			Robot.MoveForward();
			if(i == 25) {
				Robot.TurnRight();
				Robot.TurnRight();
			}
			i = i + 1;
		}
	}
}
	
			