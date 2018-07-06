package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	
	public static void Auto() {
		int i = 0;
		while(i < 52)
		{
			Robot.MoveForward();
			i = i + 1;
			
			if(i == 25)
			{
				Robot.TurnRight();
				Robot.TurnRight();
			}
		}
			
		

	}
	
}
