package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		for (int i = 1; i < 13; i++ ){
			Robot.MoveForward();
		}
		Robot.TurnLeft(); 
		Robot.MoveForward();
		Robot.MoveForward();
		Robot.TurnLeft();
		for (int i = 1; i < 13; i++ ){
			Robot.MoveForward();
		}
		Robot.TurnLeft();
		Robot.TurnLeft();
	}
}
