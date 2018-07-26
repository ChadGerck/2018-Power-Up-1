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
	static double throttle = .65; 
	static boolean fix = false; 

	int wheel = -1; 
	protected void execute(){
		
		if(Robot.oi.getYButton(Player1)) { wheel = 0; }
		if(Robot.oi.getBButton(Player1)) { wheel = 1; }
		if(Robot.oi.getXButton(Player1)) { wheel = 2; }
		if(Robot.oi.getAButton(Player1)) { wheel = 3; }
		if(Robot.oi.getStartButton(Player1)) { wheel = 4; }
		
		if(Robot.oi.getStartButton(Player1)) {
			throttle = 1; 
		}
		if(Robot.oi.getSlowButton(Player1)) {
			throttle = .65; 
		}
		
		switch(wheel) {
		case -1: break; 
		case 0: Robot.drivetrain.setRaw(Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1), 0, 0, 0, 0, 0, 0); fix = false; break; 
		case 1: Robot.drivetrain.setRaw(0, 0, Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1), 0, 0, 0, 0); fix = false; break; 
		case 2: Robot.drivetrain.setRaw(0, 0, 0, 0, Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1), 0, 0); fix = false; break; 
		case 3: Robot.drivetrain.setRaw(0, 0, 0, 0, 0, 0, Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1)); fix = false; break; 
		case 4: Robot.drivetrain.setRaw(Robot.oi.getLeftStickX(Player1)*throttle, (Robot.oi.getRightStickY(Player1)+Robot.oi.getRightTrigger(Player1))*throttle, Robot.oi.getLeftStickX(Player1)*throttle, (Robot.oi.getRightStickY(Player1)-Robot.oi.getRightTrigger(Player1))*throttle, Robot.oi.getLeftStickX(Player1)*throttle, (Robot.oi.getRightStickY(Player1)+Robot.oi.getRightTrigger(Player1))*throttle, Robot.oi.getLeftStickX(Player1)*throttle, (Robot.oi.getRightStickY(Player1)-Robot.oi.getRightTrigger(Player1))*throttle);
			fix = true; 
			break; 
		}
		
		if(fix) {Robot.CorrectYourself(); }
		
	}
	

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
