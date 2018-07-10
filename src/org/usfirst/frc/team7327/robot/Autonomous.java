package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
<<<<<<< HEAD
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






=======
	public static void Auto() {

		while (true) {
			double timer = Robot.myTimer.get();

			if (timer < 10) {
				Robot.drivetrain.setRaw1(.27, .27);
				// Robot.MoveForward();
			}

			else if (timer < 16) {
				Robot.TurnRight();
			} else if (timer < 30) {
				Robot.drivetrain.setRaw1(.35, .35);
				Robot.MoveForward();
			}

			else {
				Robot.drivetrain.setRaw1(0, 0);
			}

		}
	}
}
>>>>>>> 969e526d24478283337661d05e4bf25f2653b931
