package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
	  int i = 0;
	  while (i<50) {
		  Robot.MoveForward();
		  if (i==25) {
			  Robot.TurnRight();
			  Robot.TurnRight();
		  }
		  i = i +1;
		   }
	  Robot.TurnRight();
	  Robot.TurnRight();
	  
	  int station = 2;
      switch(station){
      case 1:
          Robot.TurnRight();
          Robot.TurnRight();
          Robot.TurnRight();
          Robot.TurnRight();
          break;
      case 2:
    	  Robot.MoveForward();
    	  Robot.TurnRight();
    	  Robot.MoveForward();
    	  Robot.TurnLeft();
    	  Robot.MoveForward();
    	  Robot.TurnRight();
    	  break;
      case 3:
    	  Robot.MoveForward();
    	  Robot.TurnLeft();
    	  Robot.TurnRight();
    	  Robot.MoveForward();
    	  Robot.TurnRight();
    	  Robot.MoveForward();
    	  break;
    	  
      
      }
      while(true) {
    	  double timer = Robot.myTimer.get();
    	  
    	  if(timer < 10){
    		  Robot.drivetrain.setRaw1(.25, .25);
    	  }
    	  else if(timer < 20){
    		  Robot.drivetrain.setRaw1(.05, .05);
    	  }
    	  else if(timer < 30){
    		 
    	  }
    	  else{
    		  Robot.drivetrain.setRaw1(0, 0);
    		  
    		  
    		  
    	  }
    		  
      }
	 
	  //Moveforward(26)
	

	}
	public static void Moveforward(int distance) {
	   int i = 0;
       while(i<distance) {
    	   Robot .MoveForward();
    	   i = i +1;
       }
	}
}
	    



