package org.usfirst.frc.team7327.robot.commands;

import org.usfirst.frc.team7327.robot.Robot;




import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;

public class TankDrive extends Command {
	public TankDrive(){
	requires(Robot.drivetrain);
	}

    
	
	XboxController Player1= Robot.oi.Controller0;
	double throttleL=0.25;
	double throttleR= -.25;
	
	protected void initialize() {
	}
	protected void execute(){
		Robot.drivetrain.setRaw1((Robot.oi.getLeftTrigger(Player1)* throttleR)  + (Robot.oi.getLeftStickX(Player1)* throttleL) + (Robot.oi.getRightTrigger(Player1)* throttleL )  ,   (Robot.oi.getLeftTrigger(Player1)* throttleR) + (Robot.oi.getLeftStickX(Player1)* throttleR) + (Robot.oi.getRightTrigger(Player1)*throttleL)  );
		
		Robot.drivetrain.setRawArm(Robot.oi.getLeftStickY(Player1));	
		
		if((Robot.oi.Dpad(Player1) >= 0 && (Robot.oi.Dpad(Player1)) <= 45) || (Robot.oi.Dpad(Player1) <= 360 && (Robot.oi.Dpad(Player1)) >= 315)){

			Robot.drivetrain.setRawSpinner(-0.3, 0.3);	
		}
		else if (Robot.oi.Dpad(Player1) > 45 && (Robot.oi.Dpad(Player1) <= 135)){
			Robot.drivetrain.setRawSpinner(0.3, 0.3);
		}
		else if((Robot.oi.Dpad(Player1) > 135 && (Robot.oi.Dpad(Player1)) <= 225)){
			Robot.drivetrain.setRawSpinner(-0.3, 0.3);
		}
		else if(Robot.oi.Dpad(Player1) <= 225 && (Robot.oi.Dpad(Player1)) >= 315){
			Robot.drivetrain.setRawSpinner(-0.3, 0.3);	
		}
		else  {
			Robot.drivetrain.setRawSpinner(0.3, 0.3);
		}
		
		
	}

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
	
	}
}


//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;


/*public TankDrive() {p
	requires(Robot.drivetrain); 
}*/


//Robot.drivetrain.setRawGrabber(Robot.oi.getAButton(Player1) * throttleL);

	///////	hiii
		
			
		/*
		if(Robot.oi.getRightBumper(Player1))
			Robot.drivetrain.setRaw1(Robot.oi.getLeftStickX(Player1))
			*/
		/*	
		if (Robot.oi.getBButton(Player1)){
			Robot.TurnRight();
		}
		 if (Robot.oi.getXButton(Player1)){
			 Robot.TurnLeft();
		 }
		 */
		 
		/*if(Robot.oi.getAButton(Player1)){
			Robot.MoveForward();
		}
		/*
		if(Robot.oi.getRightTrigger(Player1)==1){
			Robot.TurnRight();
		}
		*/
		 /*
		Robot.drivetrain.setRaw1(Robot.oi.get(Player1),0);
		
		Robot.drivetrain
		*/

