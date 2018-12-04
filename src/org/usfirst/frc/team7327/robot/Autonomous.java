package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
	
		int i = 0;
		
	while (i < 34) {
		i = i + 1;
		Robot.MoveForward();
	}		
	
		Robot.TurnRight();
	
	while (i < 6) {
		i = i + 1;
		Robot.MoveForward();
	}
	
		Robot.TurnRight();
		Robot.TurnRight();
		
	while (i < 6) {
		i = i + 1;
		Robot.MoveForward();
		}
		
		Robot.TurnLeft();
		
	while (i < 34) {
		i = i + 1;
		Robot.MoveForward();
		}
	
	}
}
