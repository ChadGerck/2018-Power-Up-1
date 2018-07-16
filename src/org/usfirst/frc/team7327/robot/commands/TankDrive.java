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
	
	//TalonSRX TestTalon = new TalonSRX(0); 

	Servo Servo1 = new Servo(8);
	Servo Servo2 = new Servo(9);
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
	
	//test

	static double distanceL = Robot.encoderL.getDistance();
	static double distanceR = Robot.encoderR.getDistance();
	
	protected void execute(){
		

		distanceL = Robot.encoderL.getDistance();
		distanceR = Robot.encoderR.getDistance();

		//SmartDashboard.putNumber("Range: ", Robot.ultra.GetRangeMM());
		SmartDashboard.putNumber("DistanceL: ", distanceL);
		SmartDashboard.putNumber("DistanceR: ", distanceR);
		SmartDashboard.putNumber("Gyro: ", Robot.GyroAngle());
		
		if(Robot.oi.getBButton(Player1)) {
			if(Servo1.get() == 0) {Servo1.setSpeed(1); }
			else { Servo1.setSpeed(-1);}
		}
		if(Robot.oi.getXButton(Player1)) {
			//if(Robot.drivetrain.getTalon() == 0) {Robot.drivetrain.setTalon(.5); }
			//else { Robot.drivetrain.setTalon(0); }
		}
		
		if(Robot.oi.getYButton(Player2)) { Robot.ShootBox(); }
		if(Robot.oi.getLeftBumper(Player2)) { Grabbers = DoubleSolenoid.Value.kReverse; }
		else if(Robot.oi.getRightBumper(Player2)){ Grabbers = DoubleSolenoid.Value.kForward; }
		else { Grabbers = DoubleSolenoid.Value.kOff; }
		Robot.drivetrain.setRawGrabber(Grabbers);
		
		if(Robot.oi.getRightTrigger(Player2) == 1){ Punchers = DoubleSolenoid.Value.kReverse; }
		if(Robot.oi.getLeftTrigger(Player2) == 1) { Punchers = DoubleSolenoid.Value.kForward; }
		Robot.drivetrain.setPunchers(Punchers);
		
		if(Robot.oi.Dpad(Player2) >= 0) { Dpressed = true; }else{ Dpressed = false; }
		
		if((Robot.oi.Dpad(Player2) >= 0 && Robot.oi.Dpad(Player2) < 45) || (Robot.oi.Dpad(Player2) >= 315 && Robot.oi.Dpad(Player2) < 360) ) { 
			DRight = throttleS; DLeft = -throttleS; }
		else if(Robot.oi.Dpad(Player2) >= 45 && Robot.oi.Dpad(Player2) < 135) { DRight = throttleS; DLeft = throttleS; }
		else if(Robot.oi.Dpad(Player2) >= 135 && Robot.oi.Dpad(Player2) < 225) { DRight = -throttleS; DLeft = throttleS; }
		else if(Robot.oi.Dpad(Player2) >= 225 && Robot.oi.Dpad(Player2) < 315) { DRight = -throttleS; DLeft = -throttleS; }
		else { DRight = 0; DLeft = 0; } 
		
		if( !Dpressed && !SinglePlayer) { Robot.drivetrain.setRawSpinner(Robot.oi.getLeftStickX(Player2)*throttleS-Robot.oi.getLeftStickY(Player2)*throttleS, Robot.oi.getLeftStickX(Player2)*throttleS + Robot.oi.getLeftStickY(Player2)*throttleS ); }
		else if(Dpressed && !SinglePlayer) { Robot.drivetrain.setRawSpinner(DLeft, DRight); }
		if(SinglePlayer) { Robot.drivetrain.setRawSpinner(DLeft, DRight); }
		
		//if(Robot.oi.getAButton(Player1) && SinglePlayer) { if(!armOn) { armOn = true;} else { armOn = false; } }
		//if(armOn) { Robot.drivetrain.setRawArm(Robot.oi.getRightStickY(Player2)*throttleA); }
		Robot.drivetrain.setRawArm(Robot.oi.getRightStickY(Player2)*throttleA);

		if(!SinglePlayer) {
			if(Robot.oi.getRightTrigger(Player1) == 1) { throttleL = .85; throttleR = .85; }
			else if(Robot.oi.getLeftTrigger(Player1) == 1) { throttleL = .4; throttleR = .4; }
			else { throttleL = .6; throttleR = .6; }
			
			Robot.drivetrain.setRaw1(-Robot.oi.getLeftStickY(Player1)* throttleL+Robot.oi.getRightStickX(Player1)*throttleL, -Robot.oi.getLeftStickY(Player1) * throttleR-Robot.oi.getRightStickX(Player1)* throttleR);
			
		} else if(SinglePlayer){
			if(Robot.oi.getStartButton(Player1)) { if(Speed == 0 || Speed == 2) { Speed = 1; } else { Speed = 2; }}
			else if(Robot.oi.getSlowButton(Player1)) { if(Speed == 2 || Speed == 0) { Speed = 1; } else { Speed = 0; }}
			if(Speed == 1) { throttleL = .6; throttleR = .6; }
			else if(Speed == 2){ throttleL = .85; throttleR = .85; }
			else if(Speed == 0) { throttleL = .4; throttleR = .4; }
			
			//if(armOn) { Robot.drivetrain.setRaw1(-Robot.oi.getLeftStickY(Player1)* throttleL, -Robot.oi.getLeftStickY(Player1) * throttleR ); }
			//else { 

				Robot.drivetrain.setRaw1(-Robot.oi.getLeftStickY(Player1)* throttleL+Robot.oi.getRightStickX(Player1)*throttleL, -Robot.oi.getLeftStickY(Player1) * throttleR-Robot.oi.getRightStickX(Player1)* throttleR);
			
			//}
		}
	}

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
