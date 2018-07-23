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
	protected void execute(){
		
		Robot.drivetrain.setRaw(Robot.oi.getLeftStickX(Player1)*throttle, Robot.oi.getRightStickY(Player1)*throttle, 
				Robot.oi.getLeftStickX(Player1)*throttle, Robot.oi.getRightStickY(Player1)*throttle, 
				Robot.oi.getLeftStickX(Player1)*throttle, Robot.oi.getRightStickY(Player1)*throttle, 
				Robot.oi.getLeftStickX(Player1)*throttle, Robot.oi.getRightStickY(Player1)*throttle);
		
		Robot.CorrectYourself(); 
		
	}
	

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
