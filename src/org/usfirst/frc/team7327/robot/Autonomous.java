package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {	//Robot.MoveForward(); 
		//Robot.MoveForward();
		//Robot.TurnRight();  
		//Robot.MoveForward();
		int i = 0;
		while(i<26) { 	
			Robot.MoveForward(); 
			i = i +1;
		}
		
		//MoveForward(26);
		while(i<2) { 
			Robot.TurnRight(); 
			i = i +1;
		}
		while(i<26) { 
			Robot.MoveForward(); 
			i = i +1;
		}
		while(i<2) { 
			Robot.TurnRight(); 
			i = i +1; 
		}
		
	}
}
