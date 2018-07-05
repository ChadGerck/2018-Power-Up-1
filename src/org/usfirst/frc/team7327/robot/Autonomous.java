package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;


	public class Autonomous {
	public static void Auto() {
	/*
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
	*/
	int station = 2;
	switch(station){
	case 1:
		
		Robot.MoveForward();
		Robot.TurnRight();
		Robot.MoveForward();
		Robot.TurnLeft();
		Shake();
		
		break;
	case 2:
		
		Robot.MoveForward();
		Robot.MoveForward();
		Shake();
		
		break;
	case 3:
		
		Robot.MoveForward();
		Robot.TurnLeft();
		Robot.MoveForward();
		Robot.TurnRight();
		Shake();
		
		break;
	}
	}
	
	public static void Shake(){
		Robot.TurnRight();
		Robot.TurnLeft();
		Robot.TurnLeft();
		Robot.TurnRight();
		Robot.TurnRight();
		Robot.TurnLeft();
	}
	
	}


