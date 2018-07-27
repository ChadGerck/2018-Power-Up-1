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
	double throttleL = .3; 
	double Nthrottle = -.3;
	double Athrottle = .8;
	DoubleSolenoid.Value grabber = DoubleSolenoid.Value.kOff;
	DoubleSolenoid.Value puncher = DoubleSolenoid.Value.kOff;
	boolean flag = true;
	
	
	protected void initialize() {
	}
	
	
	
	protected void execute(){
			
			//Robot.drivetrain.setRaw1((Robot.oi.getRightTrigger(Player1) - Robot.oi.getLeftTrigger(Player1) + Robot.oi.getLeftStickX(Player1))*throttleL, (Robot.oi.getRightTrigger(Player1) - Robot.oi.getLeftTrigger(Player1) - Robot.oi.getLeftStickX(Player1))*throttleL);
										//move the left motor forward	  will move the robot backwards      will make the robot's left side motor go	  move the right motor forward		  
										//When Right Trigger is pressed   when the left trigger is pressed   while the right side motor stops so it can   When Right Trigger is pressed
 										//																	 stop
										//
			
			//boolean flag = true;
			
			if (Robot.oi.getAButton(Player1)){
				if (flag == false){
					flag = true;
				}else if (flag == true){
					
					flag = false; 
				}
			}
			
			if(flag){
				Robot.drivetrain.setRaw1((Robot.oi.getRightTrigger(Player1) - Robot.oi.getLeftTrigger(Player1) + Robot.oi.getLeftStickX(Player1))*throttleL, (Robot.oi.getRightTrigger(Player1) - Robot.oi.getLeftTrigger(Player1) - Robot.oi.getLeftStickX(Player1))*throttleL);
			}
			else{
				Robot.drivetrain.setRaw1(0, 0);
			}

			
			if ((Robot.oi.Dpad(Player1) >= 0 && Robot.oi.Dpad(Player1) <= 45) || (Robot.oi.Dpad(Player1) >= 315 && Robot.oi.Dpad(Player1) <= 360)){
				Robot.drivetrain.setRawSpinner(-.3, .3);
			}else if (Robot.oi.Dpad(Player1) <= 225 && Robot.oi.Dpad(Player1) >= 135){
				Robot.drivetrain.setRawSpinner(.3, -.3);
			}else {
				Robot.drivetrain.setRawSpinner(0, 0);
			}

					Robot.drivetrain.setRawArm(Robot.oi.getRightStickY(Player1) * Athrottle);
					
			
			if (flag == true && Robot.oi.getBButton(Player1)){
				grabber = DoubleSolenoid.Value.kForward;
			}else if (flag == false && Robot.oi.getBButton(Player1)){
				grabber = DoubleSolenoid.Value.kReverse;
			}
			
					Robot.drivetrain.setRawGrabber(grabber);
			
			if (flag == true && Robot.oi.getXButton(Player1)){
				puncher = DoubleSolenoid.Value.kForward;
			}else if (flag == false && Robot.oi.getXButton(Player1)){
				puncher = DoubleSolenoid.Value.kReverse;
			}
			
					Robot.drivetrain.setPunchers(puncher);
					
	}

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}