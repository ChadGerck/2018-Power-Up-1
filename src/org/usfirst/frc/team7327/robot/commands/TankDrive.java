package org.usfirst.frc.team7327.robot.commands;

import org.usfirst.frc.team7327.robot.Robot;

//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Servo;

public class TankDrive extends Command {
	public TankDrive() {
		requires(Robot.drivetrain);
	}

	XboxController Player1 = Robot.oi.Controller0;

	double throttleL = .25;
	double throttleA = .55;
	
	protected void initialize() {
	}

		Servo Servo1 = new Servo(1);
		Servo Servo2 = new Servo(2);
		

	protected void execute() {
		
		
		if(Robot.oi.getBButton(Player1)) {
			if(Servo1.get() == 0) {Servo1.setSpeed(1); }
			else { Servo1.setSpeed(-1);;}
		}
		
		Robot.drivetrain.setRaw1(-Robot.oi.getLeftTrigger(Player1), Robot.oi.getRightTrigger(Player1)* throttleL);
	
		Robot.drivetrain.setRawArm(Robot.oi.getLeftStickY(Player1)* throttleL);
		
		if(Robot.oi.Dpad(Player1) >= 0 && Robot.oi.Dpad(Player1) <= 45 || Robot.oi.Dpad(Player1) <= 360 && Robot.oi.Dpad(Player1) >= 315) {
			Robot.drivetrain.setRawSpinner(-0.3, 0.3);
		}
		else if (Robot.oi.Dpad(Player1) >= 45 && Robot.oi.Dpad(Player1) <= 135) {
			Robot.drivetrain.setRawSpinner(0.3, 0.3);
		}
		else if (Robot.oi.Dpad(Player1) >= 135 && Robot.oi.Dpad(Player1) <= 225) {
			Robot.drivetrain.setRawSpinner(-0.3, 0.3);
		}
		else if (Robot.oi.Dpad(Player1) >= 225 && Robot.oi.Dpad(Player1) <= 300) {
			Robot.drivetrain.setRawSpinner(-0.3, -0.3);
	
		}
	 {
		Robot.drivetrain.setRawSpinner(0, 0);
		
	}
	}

	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
// HELLLLOOOOOOOO!!!!!!




	



