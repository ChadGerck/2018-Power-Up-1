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
	public static XboxController Player1 = Robot.oi.Controller0; 
	protected void initialize() {
	}
	static double throttle = .25; 
	static int wheel=1;
	protected void execute() {
		
		
		
		//Robot.drivetrain.setRaw(Robot.oi.getLeftStickX(Player1)*throttle, Robot.oi.getRightStickY(Player1)*throttle, 
				//Robot.oi.getLeftStickX(Player1)*throttle, Robot.oi.getRightStickY(Player1)*throttle, 
				//Robot.oi.getLeftStickX(Player1)*throttle, Robot.oi.getRightStickY(Player1)*throttle, 
				//Robot.oi.getLeftStickX(Player1)*throttle, Robot.oi.getRightStickY(Player1)*throttle);
		
		Robot.drivetrain.setRaw(Robot.oi.getLeftStickY(Player1)*throttle, Robot.oi.getLeftStickY(Player1)*throttle,
				Robot.oi.getLeftStickX(Player1)*throttle,  Robot.oi.getLeftStickY(Player1)*throttle,
				Robot.oi.getLeftStickX(Player1)*throttle, -Robot.oi.getLeftStickY(Player1)*throttle,
				Robot.oi.getLeftStickX(Player1)*throttle,  -Robot.oi.getLeftStickY(Player1)*throttle); 
		
		
		switch(wheel) {
		case 1: if(Robot.oi.getXButton(Player1)) {
			Robot.drivetrain.setRaw(Robot.oi.getLeftStickX(Player1)*throttle,0,0,0,0,0,0,0);
			wheel = 2;
			
		}
		case 2: if(Robot.oi.getYButton(Player1)) {
			Robot.drivetrain.setRaw(0,0,Robot.oi.getLeftStickX(Player1)*throttle,0,0,0,0,0);
			wheel = 3;
		}
		case 3: if(Robot.oi.getAButton(Player1)) {
			Robot.drivetrain.setRaw(0,0,0,0,Robot.oi.getLeftStickX(Player1)*throttle,0,0,0);
			wheel = 4;
		}
		case 4: if(Robot.oi.getBButton(Player1)) {
			Robot.drivetrain.setRaw(0,0,0,0,0,0,Robot.oi.getLeftStickX(Player1)*throttle,0);
			wheel = 5;
		}
		case 5:
			wheel = 1;
			break;
		
		}
		Robot.CorrectYourself(); 
		
	}
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}

/*
 * package org.usfirst.frc.team7327.robot.commands;

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
	public static XboxController Player1 = Robot.oi.Controller0; 
	
	protected void initialize() {
	} 
	
	static double throttle = .50; 
	protected void execute(){ 
		Robot.drivetrain.setRaw(Robot.oi.getLeftStickY(Player1)*throttle, Robot.oi.getLeftStickX(Player1)*throttle, Robot.oi.getLeftStickY(Player1)*throttle,  Robot.oi.getLeftStickX(Player1)*throttle, Robot.oi.getLeftStickY(Player1)*throttle, Robot.oi.getLeftStickX(Player1)*throttle, Robot.oi.getLeftStickY(Player1)*throttle,  Robot.oi.getLeftStickX(Player1)*throttle); 
		
		
		
		
		Robot.CorrectYourself(); 
		
	}
	
	
		
		
	

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}

 */



