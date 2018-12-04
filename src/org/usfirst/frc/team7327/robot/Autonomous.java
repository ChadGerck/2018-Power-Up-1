package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
	
		int i = 0;
		
	while (i < 34) {
		Robot.MoveForward();
		i = i++;
	}		
	
		Robot.TurnRight();
	
	while (i < 6) {
		Robot.MoveForward();
		i = i++;
	}
	
		Robot.TurnRight();
		Robot.TurnRight();
		
	while (i < 6) {
		Robot.MoveForward();
		i = i++;
		}
		
		Robot.TurnLeft();
		
	while (i < 34) {
		Robot.MoveForward();
		i = i++;
		}
	
	}
}
