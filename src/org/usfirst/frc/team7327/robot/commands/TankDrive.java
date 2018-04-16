package org.usfirst.frc.team7327.robot.commands;

import org.usfirst.frc.team7327.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {

	private boolean SinglePlayer = false; 

	boolean Dpressed = false;
	boolean armOn = true;
	int Speed = 1; 

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
		
		DoubleSolenoid.Value Grabbers  = DoubleSolenoid.Value.kOff;
		XboxController Player1 = Robot.oi.Controller1; 
		XboxController Player2 = Robot.oi.Controller2;
		if(SinglePlayer) { Player2 = Robot.oi.Controller1; }
		
		if(Robot.oi.getRightBumper(Player2)) {
			Grabbers = DoubleSolenoid.Value.kForward;
		}else if(Robot.oi.getLeftBumper(Player2)) {
			Grabbers = DoubleSolenoid.Value.kReverse;
		}else {
			Grabbers = DoubleSolenoid.Value.kOff;
		}
		Robot.drivetrain.setRawGrabber(Grabbers);
		
		double DRight = 0;
		double DLeft = 0;
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
		else if(Dpressed) {Robot.drivetrain.setRawSpinner(DLeft, DRight);}
		
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
		
		double WheelMotor = 0;
		if(Robot.oi.getRightTrigger(Player2) == 1) {
			WheelMotor = 1; 
		}else if(Robot.oi.getLeftTrigger(Player2) == 1) {
			WheelMotor = -1;
		}else {
			WheelMotor = 0;
		}
		
		if(Robot.oi.getAButton(Player1) && SinglePlayer) {
			if(armOn) { armOn = false;} else { armOn = true; }
		}
		
		if(Robot.done && armOn) {
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
			Robot.drivetrain.setRaw1(Robot.oi.getLeftStickY(Player1)* throttleL, Robot.oi.getRightStickY(Player1)* throttleR, WheelMotor * throttleW);
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
			
			if(!armOn) {
				Robot.drivetrain.setRaw1(Robot.oi.getLeftStickY(Player1)* throttleL, 0, WheelMotor * throttleW);
			}else {
				Robot.drivetrain.setRaw1(Robot.oi.getLeftStickY(Player1)* throttleL, Robot.oi.getRightStickY(Player1)* throttleR, WheelMotor * throttleW);
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
