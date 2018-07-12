//Hello I'm carlos
package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		
		
		int station = 2;
		switch(station){
		case 1:
			   Robot.TurnRight();
		       Robot.TurnRight();
		       Robot.TurnRight();
		       Robot.TurnRight();
		       
		       
		       break;
		case 2:Robot.MoveForward();
		       Robot.TurnRight();
		       Robot.MoveForward();
		       Robot.TurnRight();
			
			
			   break;
		case 3:Robot.TurnRight();
		       Robot.TurnLeft();
		       Robot.TurnRight();
			   Robot.TurnLeft();
			   
			   
			   break;

		    } 
		
		int i = 0;
		while(i<52){
		    Robot.MoveForward();
		    i++;
			if(i == 25){
			Robot.TurnRight();
			Robot.TurnRight();
			}
		 }
		
	}  
	public static void MoveFoward(int distance){
		int i = 0;
		while(i<26) {
		Robot.MoveForward();
		i= i +1;
		}
	}



  }