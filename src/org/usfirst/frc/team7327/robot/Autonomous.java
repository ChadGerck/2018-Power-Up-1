package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
<<<<<<< HEAD
	
		while(true) {
			double timer = Robot.myTimer.get();
			//leftvaule and rightvalue from 0 - 1
			Robot.drivetrain.setRaw1(0.25,  0.25);
			
			if(timer < 10){
				Robot.MoveForward();
			}
			else if(timer<20); {
				Robot.TurnRight();
			}
		 if(timer<30) {
				}
			}
		
		}
	}

	    
	    
	
	
=======
		int station = 2;
		int i = 0;
		switch (station) {
		case 1:
			Robot.TurnLeft();
			Robot.TurnLeft();
			Robot.TurnLeft();
			Robot.TurnLeft();
			break;

		case 2:
			while (i < 2) {
				Robot.TurnRight();
				i++;
			}
			i = 0;
			while (i < 4) {
				Robot.MoveForward();
				i++;
			}

			Robot.TurnRight();
			Robot.TurnLeft();
			Robot.TurnLeft();
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.TurnLeft();

			break;

		case 3:
			Robot.TurnLeft();
			Robot.TurnLeft();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			i = 0;
			while (i < 4) {
				Robot.TurnRight();
				i++;
			}

			Robot.TurnLeft();
			Robot.MoveForward();

		}
	}
}
>>>>>>> f2569eb29ff20ae3a1a00b7446bff94d37a42e50
