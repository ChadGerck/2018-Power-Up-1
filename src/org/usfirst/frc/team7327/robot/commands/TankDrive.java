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

	Thread NWthread = new Thread() {
		public void run() {
			Robot.NWTurnTo(Robot.oi.Dpad(Player1));
		}
	};
	
	Thread NEthread = new Thread() {
		public void run() {
			Robot.NETurnTo(Robot.oi.Dpad(Player1));
		}
	}; 
	
	public static XboxController Player1 = Robot.oi.Controller0; 
	protected void initialize() {
		NWthread.start();
		NEthread.start();

		try {NWthread.join();} catch (InterruptedException e) {e.printStackTrace();}
		try {NEthread.join();} catch (InterruptedException e) {e.printStackTrace();}
	}
	static double throttle = .45; 
	//static boolean fix = false; 

	int wheel = -1; 
	

	protected void execute(){
		SmartDashboard.putNumber("abeNW: ", Robot.NWAngle());
		SmartDashboard.putNumber("abeNE: ", Robot.NEAngle());
		SmartDashboard.putNumber("abeSW: ", Robot.SWAngle());
		SmartDashboard.putNumber("abeSE: ", Robot.SEAngle());
		
		SmartDashboard.putNumber("Gyro: ", Robot.GyroAngle());
		
		
		
		if(Robot.oi.getYButton(Player1)) { wheel = 0; }
		if(Robot.oi.getBButton(Player1)) { wheel = 1; }
		if(Robot.oi.getXButton(Player1)) { wheel = 2; }
		if(Robot.oi.getAButton(Player1)) { wheel = 3; }
		if(Robot.oi.getStartButton(Player1)) { wheel = 4; }
		if(Robot.oi.getRightBumper(Player1)) { wheel = 6; }
		
		if(Robot.oi.getStartButton(Player1)) {
			throttle = .45; 
		}
		if(Robot.oi.getSlowButton(Player1)) {
			throttle = .25; 
		}
		
		switch(wheel) {
		case -1: break; 
		case 0: Robot.drivetrain.setRaw(Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1), 0, 0, 0, 0, 0, 0);  break; 
		case 1: Robot.drivetrain.setRaw(0, 0, Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1), 0, 0, 0, 0);  break; 
		case 2: Robot.drivetrain.setRaw(0, 0, 0, 0, Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1), 0, 0);  break; 
		case 3: Robot.drivetrain.setRaw(0, 0, 0, 0, 0, 0, Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1));  break; 
		case 4: Robot.drivetrain.setRaw(Robot.oi.getLeftStickX(Player1)*throttle, (Robot.oi.getRightStickY(Player1)+Robot.oi.getRightTrigger(Player1))*throttle, Robot.oi.getLeftStickX(Player1)*throttle, (Robot.oi.getRightStickY(Player1)-Robot.oi.getRightTrigger(Player1))*throttle, Robot.oi.getLeftStickX(Player1)*throttle, (Robot.oi.getRightStickY(Player1)+Robot.oi.getRightTrigger(Player1))*throttle, Robot.oi.getLeftStickX(Player1)*throttle, (Robot.oi.getRightStickY(Player1)-Robot.oi.getRightTrigger(Player1))*throttle); break;
		case 6:  break; 
		}
		
		
		//Robot.CorrectYourself();
		
	}
	

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
