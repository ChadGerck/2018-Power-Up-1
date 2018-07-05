package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		int i = 0;
		while(i<25) {
			Robot.MoveForward();
			i = i +1;
		}

		Robot.TurnLeft();
		Robot.TurnLeft();
		int k = 0; 
		while(k<25){
			Robot.MoveForward();
			k = k +1;
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
