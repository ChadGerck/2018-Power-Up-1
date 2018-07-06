package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {

	
		while(true) {
			double timer = Robot.myTimer.get();
			//leftvaule and rightvalue from 0 - 1
			//Robot.drivetrain.setRaw1(0.25,  0.25);
			
			
			
			if(timer < 2){
				Robot.drivetrain.setRaw1(0.25, 0.25);
			}
			else if(timer < 4) {
				Robot.drivetrain.setRaw1(0.45,.45);
			}
			else if ( timer < 6) {
				Robot.drivetrain.setRaw1(0.60, 0.60);
			}	
				else if(timer< 8) {
				Robot.drivetrain.setRaw1(0.25, -0.25);
			}
				else if (timer< 10) {
				Robot.drivetrain.setRaw1(0.60, 0.60);
			}
				else if (timer< 12) {
				Robot.drivetrain.setRaw1(0.45, 0.45);
			}	
				else if (timer< 12) {
				Robot.drivetrain.setRaw1(0.25, 0.25);
			}
	    }
	}
}
		
	

	    
	    
	
	