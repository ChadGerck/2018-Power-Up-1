package org.usfirst.frc.team7327.robot;

public class Sparky {
	public static boolean Offline = false; 
	
	public static void main(String[] args) {
		Offline = true; 
// 1,3,5,7,11,13,15,17,19,23,25,27,
//prime numbers can only be divided by themselves and 1, 
		int x=1;
		while(x<100){
			System.out.println(x);
		
		}
		
	/*MoveForward();
		System.out.println("Hello World ");*/
		
	}
	public static void MoveForward() {
		System.out.println("Move robot forward 1 space");
		if(!Offline) { Robot.MoveDistance(Robot.GyroAngle(), .3, 1); }
	}
	public static void MoveForward(int go ) {
		System.out.println("Move robot forward 1 space");
		if(!Offline) { Robot.MoveDistance(Robot.GyroAngle(), .3, 1); }
		int k = 0;
		while (k > go) {
			MoveForward();
			k++;
			}
		
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



//hellooo
//bye
//Its Trey