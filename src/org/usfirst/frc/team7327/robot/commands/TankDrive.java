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
	double throttleL = .25; 
	
	protected void initialize() {
	}
	
	protected void execute(){
			
			Robot.drivetrain.setRaw1((Robot.oi.getRightTrigger(Player1) - Robot.oi.getLeftTrigger(Player1) + Robot.oi.getLeftStickX(Player1))*throttleL, (Robot.oi.getRightTrigger(Player1) - Robot.oi.getLeftTrigger(Player1) - Robot.oi.getLeftStickX(Player1))*throttleL);
										//move the left motor forward	  will move the robot backwards      will make the robot's left side motor go	  move the right motor forward		  
										//When Right Trigger is pressed   when the left trigger is pressed   while the right side motor stops so it can   When Right Trigger is pressed
										//																	 stop
										//
			
			boolean flag = true;
			
			if (Robot.oi.getAButton(Player1)){
				if (flag = false){
					Robot.drivetrain.setRaw1((Robot.oi.getRightTrigger(Player1) - Robot.oi.getLeftTrigger(Player1) + Robot.oi.getLeftStickX(Player1))*throttleL, (Robot.oi.getRightTrigger(Player1) - Robot.oi.getLeftTrigger(Player1) - Robot.oi.getLeftStickX(Player1))*throttleL);
					flag = true;
				}else if (flag = true){
					Robot.drivetrain.setRaw1(0, 0);
					flag = false; 
				}
				
			}

	}

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}