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
		
		/*
		DoubleSolenoid.Value Flappers  = DoubleSolenoid.Value.kOff;
		double WinchMotor = 0;
		
		
		if(Robot.oi.getRightBumper(Robot.oi.Controller1)) {
			Flappers = DoubleSolenoid.Value.kForward; 
		}else if(Robot.oi.getLeftBumper(Robot.oi.Controller1)) {
			Flappers = DoubleSolenoid.Value.kReverse;
		}else {
			Flappers = DoubleSolenoid.Value.kOff;
		}
		
		if(Robot.oi.getXButton(Robot.oi.Controller2)) {
			WinchMotor = .3; 
		}else if(Robot.oi.getYButton(Robot.oi.Controller2)) {
			WinchMotor = -.3;
		}else {
			WinchMotor = 0;
		}
		
		
		if(SinglePlayer) {
			double WheelMotor = 0;
			if(Robot.oi.getRightTrigger(Robot.oi.Controller1) == 1) {
				WheelMotor = .4; 
			}else if(Robot.oi.getLeftTrigger(Robot.oi.Controller1) == 1) {
				WheelMotor = -.4;
			}else {
				WheelMotor = 0;
			}
			Robot.drivetrain.setRaw(Robot.oi.getLeftStickY (Robot.oi.Controller1)* throttleL, Robot.oi.getLeftStickX(Robot.oi.Controller1)* throttleR,
									WheelMotor, Robot.oi.getRightStickY (Robot.oi.Controller1)* throttleA, WinchMotor); 
		}else {
			Robot.drivetrain.setRaw(Robot.oi.getLeftStickY (Robot.oi.Controller1)* throttleL, Robot.oi.getRightStickY(Robot.oi.Controller1)* throttleR,
					Robot.oi.getRightStickY(Robot.oi.Controller2)* throttleW, Robot.oi.getLeftStickY (Robot.oi.Controller2)* throttleA, WinchMotor); 
		}
		*/
		Robot.drivetrain.setRaw1(Robot.oi.getLeftStickY(Robot.oi.Controller1)* throttleL, Robot.oi.getRightStickY(Robot.oi.Controller1)* throttleR);
		if(Robot.oi.getAButton(Robot.oi.Controller2)) {
			Robot.BeginLift();
		}
		 if(Robot.oi.getBButton(Robot.oi.Controller2)) {
			Robot.ArmBasetoTop();
		}
		if(Robot.done) {
			Robot.drivetrain.setRaw2(Robot.oi.getRightStickY(Robot.oi.Controller2)* throttleW, Robot.oi.getLeftStickY(Robot.oi.Controller2)*throttleA);
		}
		
				
	}
	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
