package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		int count = 0;
		while(count < 13 ){
			Robot.MoveForward();
			count++;
		}
		Robot.TurnLeft(); 
		Robot.MoveForward();
		Robot.MoveForward();
		Robot.TurnLeft();
		while(count < 13) {
			Robot.MoveForward();
			count++;
		}
		Robot.TurnLeft();
		Robot.TurnLeft();
	}
}
