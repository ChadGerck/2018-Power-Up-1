package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		
		
		//While loops 
		GroupMaster.Project2();
		
		//1 while loop and if command
		GroupMaster.Project3();
		
		//Switch
		GroupMaster.Project4(); 
		
		//timed if, else if, else
		GroupMaster.Project5(); 
		
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	
		
	}
	public static void MoveAngle(double angle ) {
		Robot.drivetrain.setRaw1(.25,  .25);
		double gyroAngle = Robot.GyroAngle(); 
		gyroAngle = Math.toRadians(gyroAngle);
		
		try{
			Thread.sleep(20);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	
	public static void MoveForward(int distance) {
		int i = 0; 
		while(i < distance) {
			Robot.MoveForward();
			i = i + 1; 
		}
	}
}

*/