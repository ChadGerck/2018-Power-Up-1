package org.usfirst.frc.team7327.robot;

public class Sparky {
	public static boolean Offline = false; 
	
	public static void main(String[] args) {
		Offline = true; 
		//Autonomous.Auto(); 
		MoveForward();
		System.out.println("Hello, Chadbois!");
		
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




//
//static double[] distanceArray = new double[] {0, 0, 0, 0};
//
//static int[] intarray = new int[] {1, 2, 3, 4, 5};
//int k =0;{
//while(k < distanceArray.length) {
//	System.out.println(distanceArray[k]);
//	k++;
//}
//System.out.println(distanceArray[0]);
//}
//
//distanceNW = Robot.encoderNW.getDistance();
//distanceNE = Robot.encoderNE.getDistance();
//distanceSW = Robot.encoderSW.getDistance();
//distanceSE = Robot.encoderSE.getDistance();
//distanceArray[0] = Robot.encoder[0].getDistance();

static double[] distanceArray = new double[] {1, 2, 3, 4};
static double errorNW = 1;
static double errorNE = 2;
static double errorSW = 3;
static double errorSE = 4;
static double averageDistance = 0;
static double throttle = .65;
double[] errorArray = new double[] {1, 2, 3, 4};
}


































