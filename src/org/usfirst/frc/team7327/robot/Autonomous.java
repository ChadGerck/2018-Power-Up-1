package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	
	public static void Auto() {
		int i = 0;
		while(i < 26)
		{
			Robot.MoveForward();
			i = i + 1;
		}
			
		
	    Robot.TurnRight();
	    Robot.TurnRight();
	    
	    i = 0;
		while(i < 26)
		{
			Robot.MoveForward();
			i = i + 1;
		}
		
		 Robot.TurnRight();
		 Robot.TurnRight();
	}
	
}
