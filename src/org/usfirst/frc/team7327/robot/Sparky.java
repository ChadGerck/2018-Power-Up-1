package org.usfirst.frc.team7327.robot;

public class Sparky {
	public static boolean Offline = false; 
	
	public static void main(String[] args) {
		Offline = true; 
		//Autonomous.Auto(); 
		int k = 0; 
		while(k < 50) {
			MoveForward(); 
			if(k == 25) {
				TurnRight(); 
				TurnRight(); 
			}
			k++; 
		}
		
		int i = 0; 
		if(i == 10) {
			
		}
		while(i < 26) {
			MoveForward();
			i++; 
		}
		
		
	}
	public static void MoveForward() {
		System.out.println("Move robot forward 1 space");
		if(!Offline) { Robot.MoveDistance(Robot.GyroAngle(), .3, 1); }
	}
	public static void TurnRight() {
		System.out.println("Turn Right");
		if(!Offline) { Robot.TurnRight(); }
	}
	public static void TurnLeft() {
		System.out.println("Turn Left");
		if(!Offline) { Robot.TurnLeft(); }
	}
}
