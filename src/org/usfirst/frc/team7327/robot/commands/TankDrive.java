package org.usfirst.frc.team7327.robot.commands;

import org.usfirst.frc.team7327.robot.Robot;

//import com.ctre.phoenix.motorcontrol.ControlMode; 
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;

public class TankDrive extends Command {
    
	public TankDrive() {
		requires(Robot.drivetrain); 
	}
	XboxController Player1 = Robot.oi.Controller0;
	XboxController Player2 = Robot.oi.Controller1;
		double throttleL = .25;
		double throttleA = .55;

	 protected void initialize() {
	}
		Servo Servo1 = new Servo(8);
		Servo Servo2 = new Servo(9);
		double timer =  Robot.myTimer.get();
	protected void execute(){
				
		if(Robot.oi.getBButton (Player1))	{
			if(Servo1.get() == 0) {Servo1.setSpeed(1); }
			else { Servo1.setSpeed(-1);}
		}
		
		if(Robot.oi.getXButton (Player1))	{
			if(Servo2.get() == 0) {Servo2.setSpeed(1); }
			else { Servo2.setSpeed(-1);}
		}
		
	      timer =  Robot.myTimer.get();
    	  
    	  if(timer < 10){
    		  Servo2.setSpeed(1);
    	  }
    	  else if(timer < 15){
    		  Servo2.setSpeed(-1);
    	  }
    	  else if(timer < 20){
    		   Servo2.setSpeed(1);
    	  }
    	  else if(timer < 25){
   		   Servo2.setSpeed(-1);
    	  }	
    	  else
    	  {
    		  Servo2.setSpeed(1);
    	  }     	  
    	  
			Robot.drivetrain.setRaw1(Robot.oi.getLeftStickY(Player1)*throttleL, Robot.oi.getRightStickY(Player1)*throttleL);
			Robot.drivetrain.setRawArm(Robot.oi.getRightStickY(Player2)*throttleA);
		
			
			if(( Robot.oi.Dpad(Player1) >= 0 && Robot.oi.Dpad(Player1)<=45) 
				||(Robot.oi.Dpad(Player1) <= 360 && Robot.oi.Dpad(Player1) >=315)){
				Robot.drivetrain.setRawSpinner(-0.30,0.30);
			}
			else if (Robot.oi.Dpad(Player1) > 45 && Robot.oi.Dpad(Player1) <=135){
				Robot.drivetrain.setRawSpinner(0.30,-0.30);
			}
			else if (Robot.oi.Dpad(Player1) >= 135 && Robot.oi.Dpad(Player1) <=225){
				Robot.drivetrain.setRawSpinner(0.30,-0.30);
			}	
			
    	  }
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
		}
	}		