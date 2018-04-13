package org.usfirst.frc.team7327.robot.commands;

import org.usfirst.frc.team7327.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {

	private boolean SinglePlayer = false; 

	public TankDrive() {
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute(){
		//throttle speed from 1 to 0 based on desired speed
		double throttleL = .6;
		double throttleR = .6;
		double throttleW = .4;
		double throttleA = .4;  
		double throttleS = .7;
		
		/*
		DoubleSolenoid.Value Flappers  = DoubleSolenoid.Value.kOff;
		 
		
		if(Robot.oi.getRightBumper(Robot.oi.Controller2)) {
			Flappers = DoubleSolenoid.Value.kForward; 
		}else if(Robot.oi.getLeftBumper(Robot.oi.Controller2)) {
			Flappers = DoubleSolenoid.Value.kReverse;
		}else {
			Flappers = DoubleSolenoid.Value.kOff;
		}
		
		
		if(SinglePlayer) {
			Robot.drivetrain.setRaw(Robot.oi.getLeftStickY (Robot.oi.Controller1)* throttleL, Robot.oi.getLeftStickX(Robot.oi.Controller1)* throttleR,
									WheelMotor, Robot.oi.getRightStickY (Robot.oi.Controller1)* throttleA, 0); 
		}else {
			
			Robot.drivetrain.setRaw(Robot.oi.getLeftStickY (Robot.oi.Controller1)* throttleL, Robot.oi.getRightStickY(Robot.oi.Controller1)* throttleR,
					Robot.oi.getRightStickY(Robot.oi.Controller2)* throttleW, Robot.oi.getLeftStickY (Robot.oi.Controller2)* throttleA, 0); 
		}
		*/

		
		if(SinglePlayer) {
			double DRight = 0;
			double DLeft = 0;
			if((Robot.oi.Dpad(Robot.oi.Controller1) >= 0 && Robot.oi.Dpad(Robot.oi.Controller1) < 45) || (Robot.oi.Dpad(Robot.oi.Controller1) >= 315 && Robot.oi.Dpad(Robot.oi.Controller1) < 360) ) {
				DRight = throttleS;
				DLeft = -throttleS;
			}
			else if(Robot.oi.Dpad(Robot.oi.Controller1) >= 45 && Robot.oi.Dpad(Robot.oi.Controller1) < 135) {
				DRight = throttleS;
				DLeft = throttleS;
			}
			else if(Robot.oi.Dpad(Robot.oi.Controller1) >= 135 && Robot.oi.Dpad(Robot.oi.Controller1) < 225) {
				DRight = throttleS;
				DLeft = throttleS;
			}
			else if(Robot.oi.Dpad(Robot.oi.Controller1) >= 225 && Robot.oi.Dpad(Robot.oi.Controller1) < 315) {
				DRight = throttleS;
				DLeft = throttleS;
			}
			else {
				DRight = 0;
				DLeft = 0;
			}
			Robot.drivetrain.setRawSpinner(DLeft, DRight);
			
			if(Robot.oi.getXButton(Robot.oi.Controller1)) {
				Robot.BeginLift();
			}
			 if(Robot.oi.getBButton(Robot.oi.Controller1)) {
				Robot.ArmBasetoTop();
			}
			
			double unkillTimer = 0; 
			if(unkillTimer >= Robot.myTimer.get() + 1) {
				Robot.killButton = true; 
			}
			if(Robot.oi.getYButton(Robot.oi.Controller1)) {
				if(Robot.killButton == false) {
					Robot.killButton = true; 
				} else {
					Robot.killButton = false;
					unkillTimer = Robot.myTimer.get();
				}
			}
			

			double WheelMotor = 0;
			if(Robot.oi.getRightTrigger(Robot.oi.Controller1) == 1) {
				WheelMotor = 1; 
			}else if(Robot.oi.getLeftTrigger(Robot.oi.Controller1) == 1) {
				WheelMotor = -1;
			}else {
				WheelMotor = 0;
			}
			
			if(Robot.done) {
				Robot.drivetrain.setRawArm(Robot.oi.getRightStickY(Robot.oi.Controller1)*throttleA);
			}
			

			Robot.drivetrain.setRaw1(Robot.oi.getLeftStickY(Robot.oi.Controller1)* throttleL, Robot.oi.getLeftStickX(Robot.oi.Controller1)* throttleR, WheelMotor * throttleW);
			
		}
		else {
			
			Robot.drivetrain.setRawSpinner(Robot.oi.getRightStickX(Robot.oi.Controller2)*throttleS-Robot.oi.getRightStickY(Robot.oi.Controller2)*throttleS, Robot.oi.getRightStickX(Robot.oi.Controller2)*throttleS + Robot.oi.getRightStickY(Robot.oi.Controller2)*throttleS );
			
			if(Robot.oi.getXButton(Robot.oi.Controller2)) {
				Robot.BeginLift();
			}
			 if(Robot.oi.getBButton(Robot.oi.Controller2)) {
				Robot.ArmBasetoTop();
			}
			
			double unkillTimer = 0; 
			if(unkillTimer >= Robot.myTimer.get() + 1) {
				Robot.killButton = true; 
			}
			if(Robot.oi.getYButton(Robot.oi.Controller2)) {
				if(Robot.killButton == false) {
					Robot.killButton = true; 
				} else {
					Robot.killButton = false;
					unkillTimer = Robot.myTimer.get();
				}
			}
			
			double WheelMotor = 0;
			if(Robot.oi.getRightTrigger(Robot.oi.Controller2) == 1) {
				WheelMotor = 1; 
			}else if(Robot.oi.getLeftTrigger(Robot.oi.Controller2) == 1) {
				WheelMotor = -1;
			}else {
				WheelMotor = 0;
			}
			
			if(Robot.oi.getRightTrigger(Robot.oi.Controller2) == 1) {
				throttleL = .85;
				throttleR = .85;
			}else if(Robot.oi.getLeftTrigger(Robot.oi.Controller2) == 1) {
				throttleL = .4;
				throttleR = .4;
			}else {
				throttleL = .6;
				throttleR = .6;
			}

			if(Robot.done) {
				Robot.drivetrain.setRawArm(Robot.oi.getLeftStickY(Robot.oi.Controller2)*throttleA);
			}
			Robot.drivetrain.setRaw1(Robot.oi.getLeftStickY(Robot.oi.Controller1)* throttleL, Robot.oi.getRightStickY(Robot.oi.Controller1)* throttleR, WheelMotor * throttleW);
		}
	}
	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
