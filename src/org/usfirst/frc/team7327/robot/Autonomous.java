package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		
		MoveFoward(10);
	}
		
		
		
	public static void MoveFoward(int distance){
		int i = 0;
		while(i<distance) {
		Robot.MoveForward();
		i= i +1;
		}
	}



  }