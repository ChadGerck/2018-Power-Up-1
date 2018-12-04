package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
     int a = 0;
     while(a < 33) {
    	 Robot.MoveForward();
    	 a = a + 1;
     }
	 
	 Robot.TurnLeft();
	 
	 int b = 0;
	 while(b < 15) {
		 Robot.MoveForward();
		 b = b + 1;
	 }
	 
	 Robot.TurnLeft();
	 Robot.TurnLeft();
	 
	 int c = 0;
	 while(c < 15) {
		 Robot.MoveForward();
		 c = c + 1;
	 }
	 
	 Robot.TurnRight();
	 
	 int d = 0;
     while(d < 33) {
    	 Robot.MoveForward();
    	 d = d + 1;
     }
	 } 
}