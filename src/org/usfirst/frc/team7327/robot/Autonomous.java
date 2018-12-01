package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		
		
		//While loops 
		//GroupMaster.Project2();
		
		//1 while loop and if command
		//GroupMaster.Project3();
		
		//Switch
		//GroupMaster.Project4(); 
		
		//timed if, else if, else
		//GroupMaster.Project5(); 
		
		
		
		
		Robot.MoveForward(); 
		
		int i = 0; 
		while(i < 26) {
			Robot.MoveForward();
			i = i + 1; 
		}
		Robot.TurnRight();
		Robot.TurnRight();
		
		i = 0; 
		while(i < 26) {
			Robot.MoveForward();
			i = i + 1; 
		}
		MoveForward(26);
		Robot.TurnRight();
		Robot.TurnRight();
		MoveForward(26); 
		
		int station = 3; 
		switch(station){
		case 1: 
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.TurnRight();
			break; 
		case 2: 
			
			
			break; 
			
		case 3: 
			break; 
			
		}
		
		
		
		
		while(true) {
			double timer = Robot.myTimer.get(); 
			//leftvalue and rightvalue from 0 - 1
			Robot.drivetrain.setRaw1(.25, .25);
			
			if(timer < 10 ) {
				
			}
			else if( timer < 20 ) {
				
			}
			else if(timer < 30) {
				
			}
			else {
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
