package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		for (var i = 0; i < 13; i++ ){
			Robot.MoveForward();
		}
		Robot.TurnLeft(); 
		Robot.MoveForward();
		Robot.MoveForward();
		Robot.TurnLeft();
		for (var i = 0; i < 13; i++ ){
			Robot.MoveForward();
		}
		Robot.TurnLeft();
		Robot.TurnLeft();
	}
}
