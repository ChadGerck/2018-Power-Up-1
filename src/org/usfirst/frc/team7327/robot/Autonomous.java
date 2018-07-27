package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {

	int i=0;
	while( i < 16) {
		Robot.MoveForward();
		i++;
		if(i == 8 || i == 16) {
			Robot.TurnRight();
			Robot.TurnRight();
			
			}
		}
	}
}
		
	

	    
	    
	
	