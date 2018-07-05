package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Sparky;


public class Autonomous {
	public static void Auto() {
		
		int count = 0;
		
		while(count < 26 ) {
			Sparky.MoveForward();
			count++;
		}
		
		Sparky.TurnLeft(); 
		Sparky.MoveForward();
		Sparky.MoveForward();
		Sparky.TurnLeft();
		
		count = 0;
		while(count < 26) {
			Sparky.MoveForward();
			count++;
		}
		Sparky.TurnLeft();
		Sparky.TurnLeft();
	}
}