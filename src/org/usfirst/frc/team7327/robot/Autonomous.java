package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
	
		while(true) {
			double timer = Robot.myTimer.get();
			//leftvaule and rightvalue from 0 - 1
			Robot.drivetrain.setRaw1(0.25,  0.25);
			
			if(timer < 10){
				Robot.MoveForward();
			}
			else if(timer<20); {
				Robot.TurnRight();
			}
		 if(timer<30) {
				}
			}
		
		}
	}

	    
	    
	
	