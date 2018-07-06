package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	
	public static void Auto() {
		
		while(true) {
			double timer = Robot.myTimer.get();
			//leftvalue and rightvalue from 0 - 1
			
			if(timer<10) {
				Robot.drivetrain.setRaw1(.25, .25);
			}
			else if ( timer < 20) {
				Robot.drivetrain.setRaw1(.25, .50);
			}
			else if (timer<30) {
				Robot.drivetrain.setRaw1(.50, .25);
			}
			else {
				Robot.drivetrain.setRaw1(0, 0);
			}
		}
		
		
		/*
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
			*/
		}
			
		

	}
	
}
