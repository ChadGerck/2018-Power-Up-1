package org.usfirst.frc.team7327.robot;

public class GroupD {

	public static void Project2() {
		int i = 0;
		while (i < 26) {
			Robot.MoveForward();
			i++;
		}
		Robot.TurnLeft();
		Robot.TurnLeft();
		i = 0;
		while (i < 26) {
			Robot.MoveForward();
			i++;
		}
		Robot.TurnLeft();
		Robot.TurnLeft();
	}
	
	public static void Project3(){
		int i = 0;
		while(i < 52){
			Robot.MoveForward();
			if(i == 25 || i == 51){
				Robot.TurnLeft();
				Robot.TurnLeft();
			}
			i++;
		}
	}

	public static void Project4(){
		int station = 1; 
		switch(station){
		case 1:
			Robot.MoveForward();
			Robot.TurnLeft();
			Robot.TurnRight();
			Robot.MoveForward();
			break;
			
		case 2:
			Robot.TurnLeft();
			Robot.TurnLeft();
			Robot.TurnLeft();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.TurnRight();
			break;
			
		case 3:
			Robot.TurnLeft();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.TurnRight();
			break;
		}
	}
	
	public static void Project5(){
		while(true){
			double timer = Robot.myTimer.get();
			Robot.drivetrain.setRaw1(.25, .25);
			if(timer < 10){
				
			}
			else if(timer < 20){
				
			}
			else if
				
			}
		}
	}















}
