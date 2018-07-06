package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	
	public static void Auto() {
		int i = 0;
		while(i < 52)
		{
			Robot.MoveForward();
			i = i + 1;
			
			switch(i)
			{
				case 10:
					Robot.TurnRight();
					Robot.TurnRight();
					Robot.TurnRight();
					Robot.TurnRight();
					break;
					
				case 25:
					Robot.TurnRight();
					Robot.TurnRight();
					break;
					
				case 45:
					Robot.TurnRight();
					Robot.TurnLeft();
					break;
					
				default:
					break;
					
				
			}
		}
			
		

	}
	
}
