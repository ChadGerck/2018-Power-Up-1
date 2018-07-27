package org.usfirst.frc.team7327.robot;

import java.io.Console;

public class Sparky {
	public static boolean Offline = false; 
	
											static double[] distanceArray = new double[] {0, 0, 0, 0};
	
	public static void main(String[] args) {
		Offline = true; 
		//Autonomous.Auto(); 
		

		
		System.out.println(distanceArray[0]);
		System.out.println(distanceArray[1]);
		System.out.println(distanceArray[2]);
		System.out.println(distanceArray[3]);
		
		distanceArray[0] = 3;
		distanceArray[1] = 7;
		distanceArray[2] = 8;
		distanceArray[3] = 9.3;
		
		System.out.println(distanceArray[0]);
		System.out.println(distanceArray[1]);
		System.out.println(distanceArray[2]);
		System.out.println(distanceArray[3]);
	}
	
//	static double[] distanceArray = new double[] {0, 0, 0, 0};
//	
//	System.out.println(distanceArray[0]);
//	System.out.println(distanceArray[1]);
//	System.out.println(distanceArray[2]);
//	System.out.println(distanceArray[3]);
	
	
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
