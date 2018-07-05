package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		int i=0;
		while(i<26) {
			Robot.MoveForward();
			i=i +1;
		}
		
		i=0;
		while(i<2) {
			Robot.TurnRight();
			i=i+1;
		}
	
		i=0;
		while(i<26) {
			Robot.MoveForward();
			i=i+1;
		}
		
	}
	
	
	
	
	
	
	
	public static void MoveForward(int distance) {
		int i = 0;
		while(i<distance) {
			Robot.MoveForward(); 
			i = i +1;
		}
	}
}