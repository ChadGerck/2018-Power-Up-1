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

	XboxController Player1 = Robot.oi.Controller0;
	double throttleL = .25; 
	double throttleA= 0.55;

	protected void initialize() {
	}

	protected void execute() {
		
		
		Robot.drivetrain.setRaw1((-Robot.oi.getLeftStickY(Player1)+ Robot.oi.getRightStickX(Player1))* throttleL, 
				(-Robot.oi.getLeftStickY(Player1)+ -Robot.oi.getRightStickX(Player1)) * throttleL);
		
		Robot.drivetrain.setRawArm((Robot.oi.getRightTrigger(Player1)+ -Robot.oi.getLeftTrigger(Player1))*throttleA);
		
		
		if(Robot.oi.Dpad(Player1)<180 && Robot.oi.Dpad(Player1)>=0) {
			Robot.drivetrain.setRawSpinner(0.4,-0.4);
		}
		
		else if(Robot.oi.Dpad(Player1)>180 && Robot.oi.Dpad(Player1)<=359) {
			Robot.drivetrain.setRawSpinner(-0.4, 0.4);
		}
		
		else {Robot.drivetrain.setRawSpinner(0,0);
		
		}
		
		
	}

	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
