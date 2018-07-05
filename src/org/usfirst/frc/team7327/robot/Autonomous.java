package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	
	public static void Auto() {
	
	int station = 3;
			switch(station){
			case 1 :
				Robot.TurnRight();
				Robot.TurnRight();
				Robot.TurnRight();
				Robot.TurnRight();
				break;
			case 2:
				Robot.MoveForward();
				Robot.MoveForward();
				Robot.MoveForward();
				Robot.MoveForward();	
				Robot.TurnRight();
				Robot.TurnRight();
				Robot.MoveForward();
				Robot.MoveForward();
				Robot.MoveForward();
				Robot.MoveForward();
				Robot.TurnRight();
				Robot.TurnRight();
				Robot.MoveForward();
				Robot.MoveForward();
				Robot.MoveForward();
				Robot.MoveForward();
				break;
			case 3:
				Robot.TurnRight();
				Robot.MoveForward();
				Robot.MoveForward();
				Robot.MoveForward();
				Robot.TurnRight();	
				Robot.MoveForward();
				Robot.MoveForward();
				Robot.MoveForward();
				Robot.TurnRight();
				Robot.MoveForward();
				Robot.MoveForward();
				Robot.MoveForward();
				Robot.TurnRight();
				Robot.MoveForward();
				Robot.MoveForward();
				Robot.MoveForward();
				break;
				
			}
	}
	
	// other challenge 
	public static void MoveAngle(double angle) {
		Robot.drivetrain.setRaw1(.25,  .25);
		double gyroAngle = Robot.GyroAngle();
		gyroAngle = Math.toRadians(gyroAngle);
		
		try{
			Thread.sleep(20);
		}
		
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
		
		
		/*int i = 0;
	while (i <= 54) {
		Robot.MoveForward();
		//sorry;
		if (i == 27 || i == 54) {
			Robot.TurnRight();
			Robot.TurnRight();
		}
	i++;

	}
		
		 int i = 0;
		while (i < 26) {
			Robot.MoveForward();
			i++;
		}
		Robot.TurnRight();
		Robot.TurnRight();

		i = 0;
		while (i < 26) {
			Robot.MoveForward();
			i++;
		}
		Robot.TurnRight();
		Robot.TurnRight();

		// moveForward(27);
		// Robot.TurnRight();
		// Robot.TurnRight();
		// moveForward(27);
		// Robot.TurnRight();
		 Robot.TurnRight();*/

	

	public static void moveForward(int distance) {
		
	}
}
