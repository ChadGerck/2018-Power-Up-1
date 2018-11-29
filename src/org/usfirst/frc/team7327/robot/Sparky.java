package org.usfirst.frc.team7327.robot;

public class Sparky {
	public static boolean Offline = false; 
	
	public static void main(String[] args) throws InterruptedException {
		Offline = true; 
		//Autonomous.Auto(); 
		
		
		System.out.println("a");
		System.out.println("b");
		System.out.println("c");
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		
		
	}
	/*
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
	*/
}
