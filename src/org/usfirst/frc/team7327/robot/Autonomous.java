package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Sparky;


public class Autonomous {
	public static void Auto() {
		
		int count = 0;
		
		while(count <= 52 ) {
			
			Sparky.MoveForward();
			if (count == 26) {
				Sparky.TurnLeft();
				Sparky.TurnLeft();
			}			
			count++;
		}		
	}

public static void MoveForward(int distance){
	int i = 0;
	while (i < distance){
		Sparky.MoveForward();
		i = i + 1;
		}
	}
}