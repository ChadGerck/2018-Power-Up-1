package org.usfirst.frc.team7327.robot;

public class Sparky {
	public static boolean Offline = false; 
	
	public static void main(String[] args) {
		Offline = true; }
		//Autonomous.Auto(); 
<<<<<<< HEAD
		
		int x = 1;
		
		System.out.println(x);
		
		while (x<100) {
		System.out.println(x);
		x = x*2;
		
		}
	}	
=======
	
	double x=1; {
	
	while(x>0) {
		
		System.out.println(x);
		x = x/2;    }
	}
		
	
		
	
>>>>>>> 96acda900f2a036a0821bec00e672726b75aa92b
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
