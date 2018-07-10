package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto () {
		int i = 0;
		while(i<26){
			Robot.MoveForward();
			if(i == 10) {
				Robot.TurnLeft();
			}
			i = i +1;
		}
		Robot.TurnRight();
		Robot.TurnRight();
		

	}
	public static void MoveForward(int distance) {
      int i=0;
      while(i<distance) {
    	  Robot.MoveForward();
    	  i = i +1;
      }
	}
}






