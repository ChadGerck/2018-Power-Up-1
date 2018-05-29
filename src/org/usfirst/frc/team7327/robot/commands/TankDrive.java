package org.usfirst.frc.team7327.robot.commands;

import org.usfirst.frc.team7327.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Servo;

public class TankDrive extends Command {

	private boolean SinglePlayer = true; 

	boolean Dpressed = false;
	boolean armOn = true;
	int Speed = 1; 
    
	public TankDrive() {
		requires(Robot.drivetrain);
	}

		//throttle speed from 1 to 0 based on desired speed
		double throttleL = .6;
		double throttleR = .6;
		double throttleA = .65;  
		double throttleS = .7;
		
		Servo screamServo = new Servo(1);
		XboxController Player1 = Robot.oi.Controller0; 
		XboxController Player2 = Robot.oi.Controller1;
	protected void initialize() {
		if(SinglePlayer) { Player2 = Robot.oi.Controller0; }
		DoubleSolenoid.clearAllPCMStickyFaults(0);
	}
	DoubleSolenoid.Value Grabbers  = DoubleSolenoid.Value.kOff;
	DoubleSolenoid.Value Punchers  = DoubleSolenoid.Value.kOff;

	double DRight = 0;
	double DLeft = 0;
	double distanceL = Robot.encoderL.getDistance()/686;
	double distanceR = Robot.encoderR.getDistance()/686;
	
	protected void execute(){

		//int count = Robot.encoderR1.get();
		//double rate = Robot.encoderR1.getRate();
		//boolean direction = Robot.encoderR1.getDirection();
		//boolean stopped = Robot.encoderR1.getStopped();
		
		//Distance to feet is approximately /686
		distanceL = Robot.encoderL.getDistance()/686;
		distanceR = Robot.encoderR.getDistance()/686;

		SmartDashboard.putNumber("DistanceL: ", distanceL);
		SmartDashboard.putNumber("DistanceR: ", distanceR);
		SmartDashboard.putNumber("Gyro: ", Robot.GyroAngle());
		/*
		if(Robot.oi.getYButton(Player2)) {
			Robot.ShootBox(); 
		}
		*/
		if(Robot.oi.getLeftBumper(Player2)) {
			Grabbers = DoubleSolenoid.Value.kReverse;
		}else if(Robot.oi.getRightBumper(Player2)) {
			Grabbers = DoubleSolenoid.Value.kForward;

		}else {
			Grabbers = DoubleSolenoid.Value.kOff;
		}
		
		Robot.drivetrain.setRawGrabber(Grabbers);
		
		if(Robot.oi.getRightTrigger(Player2) == 1) {
			Punchers = DoubleSolenoid.Value.kReverse;
			System.out.println("It went,");
		}else if(Robot.oi.getLeftTrigger(Player2) == 1) {
			Punchers = DoubleSolenoid.Value.kForward;
			System.out.println("It went, it's not the code");
		}/*else {
			Punchers = DoubleSolenoid.Value.kOff;
		}
		*/
		Robot.drivetrain.setPunchers(Punchers);
		
		if(Robot.oi.Dpad(Player2) >= 0) {
			Dpressed = true;
		}
		else { Dpressed = false; }
		
		if((Robot.oi.Dpad(Player2) >= 0 && Robot.oi.Dpad(Player2) < 45) || (Robot.oi.Dpad(Player2) >= 315 && Robot.oi.Dpad(Player2) < 360) ) {
			DRight = -throttleS;
			DLeft = throttleS;

		}
		else if(Robot.oi.Dpad(Player2) >= 45 && Robot.oi.Dpad(Player2) < 135) {
			DRight = throttleS;
			DLeft = throttleS;
		}
		else if(Robot.oi.Dpad(Player2) >= 135 && Robot.oi.Dpad(Player2) < 225) {
			DRight = throttleS;
			DLeft = -throttleS;
		}
		else if(Robot.oi.Dpad(Player2) >= 225 && Robot.oi.Dpad(Player2) < 315) {
			DRight = -throttleS;
			DLeft = -throttleS;
		}
		else {
			DRight = 0;
			DLeft = 0;
		} 
		if( !Dpressed && !SinglePlayer) { Robot.drivetrain.setRawSpinner(Robot.oi.getLeftStickX(Player2)*throttleS-Robot.oi.getLeftStickY(Player2)*throttleS, Robot.oi.getLeftStickX(Player2)*throttleS + Robot.oi.getLeftStickY(Player2)*throttleS ); }
		else if(Dpressed && !SinglePlayer) { Robot.drivetrain.setRawSpinner(DLeft, DRight); }
		if(SinglePlayer) { Robot.drivetrain.setRawSpinner(DLeft, DRight); }
		/*
		if(Robot.oi.getXButton(Player2)) {
			Robot.BeginLift();
		}
		 if(Robot.oi.getBButton(Player2)) {
			Robot.ArmBasetoTop();
		}
		 
		double unkillTimer = 0; 
		if(unkillTimer >= Robot.myTimer.get() + 1) {
			Robot.killButton = true; 
		}
		if(Robot.oi.getYButton(Player2)) {
			if(Robot.killButton == false) {
				Robot.killButton = true; 
			} else {
				Robot.killButton = false;
				unkillTimer = Robot.myTimer.get();
			}
		}
		*/
		if(Robot.oi.getAButton(Player1) && SinglePlayer) {
			if(!armOn) { armOn = true;} 
			else { armOn = false; }
		}
	
		if(armOn) {
			Robot.drivetrain.setRawArm(Robot.oi.getRightStickY(Player2)*throttleA);
		}

		if(!SinglePlayer) {
			if(Robot.oi.getRightTrigger(Player1) == 1) {
				throttleL = .85;
				throttleR = .85;
			}else if(Robot.oi.getLeftTrigger(Player1) == 1) {
				throttleL = .4;
				throttleR = .4;
			}else {
				throttleL = .6;
				throttleR = .6;
			}
			Robot.drivetrain.setRaw1(-Robot.oi.getLeftStickY(Player1)* throttleL, -Robot.oi.getRightStickY(Player1)* throttleR);
		} else if(SinglePlayer){
			if(Robot.oi.getStartButton(Player1)) {
				if(Speed == 0 || Speed == 2) { Speed = 1; }
				else { Speed = 2; }
			}else if(Robot.oi.getSlowButton(Player1)) {
				if(Speed == 2 || Speed == 0) { Speed = 1; }
				else { Speed = 0; }
			}
			if(Speed == 1) { throttleL = .6; throttleR = .6; }
			else if(Speed == 2){ throttleL = .85; throttleR = .85; }
			else { throttleL = .4; throttleR = .4; }
			
			if(armOn) {
				Robot.drivetrain.setRaw1(-Robot.oi.getLeftStickY(Player1)* throttleL, 0 );
			}else {
				Robot.drivetrain.setRaw1(-Robot.oi.getLeftStickY(Player1)* throttleL, -Robot.oi.getRightStickY(Player1)* throttleR);
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
