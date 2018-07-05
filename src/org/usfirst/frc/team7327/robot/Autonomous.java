package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
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
		
		
		switch(Robot.station){
		case 1: 
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.TurnRight();
			break; 
		case 2: 
			Robot.MoveDistance(0, .3, 26);
			
			
			break; 
			
		case 3: 
			break; 
			
		}
		
		
	}
	public static void MoveAngle() {
		Robot.drivetrain.setRaw1(.25, .25);
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
