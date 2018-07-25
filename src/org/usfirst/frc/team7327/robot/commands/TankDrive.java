package org.usfirst.frc.team7327.robot.commands;

import org.usfirst.frc.team7327.robot.Robot;

//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;

public class TankDrive extends Command {
	public TankDrive() {
		requires(Robot.drivetrain);
	}

	XboxController Player1 = Robot.oi.Controller0;

	double throttleL = .25;
	double throttleA = .6;
	DoubleSolenoid.Value grabber = DoubleSolenoid.Value.kOff;
	DoubleSolenoid.Value puncher = DoubleSolenoid.Value.kOff;

	protected void initialize() {
	}

	Servo Servo1 = new Servo(1);
	Servo Servo2 = new Servo(2);

	protected void execute() {

		if (Robot.oi.getBButton(Player1)) {
			if (Servo1.get() == 0) {
				Servo1.setSpeed(1);
			} else {
				Servo1.setSpeed(-1);
				 
			}
		}

		//This is for the wheels
		Robot.drivetrain.setRaw1(-Robot.oi.getRightStickY(Player1)*throttleL + Robot.oi.getRightStickX(Player1)*throttleL, -Robot.oi.getLeftStickY(Player1) * throttleL + - Robot.oi.getRightStickX(Player1)*throttleL);

		//This is for the arm
		Robot.drivetrain.setRawArm(Robot.oi.getRightTrigger(Player1) * throttleA);

		//This is for the spinners
		if (Robot.oi.Dpad(Player1) >= 0 && Robot.oi.Dpad(Player1) <= 45 || Robot.oi.Dpad(Player1) <= 360 && Robot.oi.Dpad(Player1) >= 315) 
		{
			Robot.drivetrain.setRawSpinner(0.5, 0.5);
		} 
		else if (Robot.oi.Dpad(Player1) >= 45 && Robot.oi.Dpad(Player1) <= 135) 
		{
			Robot.drivetrain.setRawSpinner(0.5, -0.5);
		} 
		else if (Robot.oi.Dpad(Player1) >= 135 && Robot.oi.Dpad(Player1) <= 225) 
		{
			Robot.drivetrain.setRawSpinner(-0.5, -0.5);
		} 
		else if (Robot.oi.Dpad(Player1) >= 225 && Robot.oi.Dpad(Player1) <= 300) 
		{
			Robot.drivetrain.setRawSpinner(-0.5, 0.5);
		}
		else
		{
			Robot.drivetrain.setRawSpinner(0, 0);
		}
		
		
		if (Robot.oi.getXButton(Player1)) {
			grabber = DoubleSolenoid.Value.kForward;
		}
		if (Robot.oi.getYButton(Player1)) {
			grabber = DoubleSolenoid.Value.kReverse;  
		}
		Robot.drivetrain.setRawGrabber(grabber); 

		if (Robot.oi.getRightBumper(Player1)) { 
			puncher = DoubleSolenoid.Value.kForward; 
		}
		if (Robot.oi.getLeftBumper(Player1)) {
			puncher = DoubleSolenoid.Value.kReverse;
		}
		Robot.drivetrain.setPunchers(puncher);
	}

	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
// HELLLLOOOOOOO!!!!!
