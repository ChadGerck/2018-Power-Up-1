package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		int i = 0; 
		while(i<26) {
			Robot.MoveForward();
			i = i +1; 
		}
		
		//MoveForward(26); 
		
		
		
		
		
		while(true) {
			double timer = Robot.myTimer.get(); 
			
			if(timer < 10) {
				Robot.drivetrain.setRaw1( .25, .25);
			}
			else if (timer < 20 ) {
				Robot.drivetrain.setRaw1(.05, .05);
			}
			else if(timer < 30 ) {
				
			}
			else {
				Robot.drivetrain.setRaw1(0,0); 
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	public static void MoveForward(int distance) {
		int i = 0; 
		while(i<distance) {
			Robot.MoveForward();
			i = i +1; 
		}
	 }
}
