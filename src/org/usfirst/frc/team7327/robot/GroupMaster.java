package org.usfirst.frc.team7327.robot;

public class GroupMaster {
	public static void Project2() {
		int count = 0;
		while(count < 12){
			Robot.MoveForward();
			count++;
		}
		
		
	}
	
	public static void Project3() {
		int count = 0;
		while(count < 32){
			Robot.MoveForward();
			if(count == 16){
				Robot.TurnLeft();
				Robot.TurnLeft();
				count++;
			}
		}
		
		
	}
	
	public static void Project4() {
		
		//Switch 
		int station = 1; 
		switch(station) {
		case 1:
			Robot.MoveForward();
			Robot.TurnLeft();
			Robot.TurnLeft();
			Robot.MoveForward();
			break; 
		}
		
	}
	
	public static void Project5() {
		
		
		while(true) {
			double timer = Robot.myTimer.get(); 
			//leftvalue and rightvalue from 0 - 1
			Robot.drivetrain.setRaw1(.3, .3);
			
			if(timer < 10 ) {
				Robot.MoveForward();
			}
			else if( timer < 13 ) {
				Robot.TurnLeft();
				
			}
			else if(timer < 24) {
				Robot.MoveForward();
				
			}
			else {
				Robot.drivetrain.setRaw1(0, 0);
			}
		}
	}

}
