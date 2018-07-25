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
	XboxController Player1 = Robot.oi.Controller0;
	XboxController Player2 = Robot.oi.Controller1;
	double throttleW = 0.5;
	double throttleA = 0.5;
	DoubleSolenoid.Value Grabbers = DoubleSolenoid.Value.kOff;
	DoubleSolenoid.Value Punchers = DoubleSolenoid.Value.kOff;
	boolean flag = true;
	
	public TankDrive() {
		requires(Robot.drivetrain); 
	}
	protected void execute() {
		if(Robot.oi.getYButton(Player1)) {
			if(flag) {
				flag = false;
			}
			else {
				flag = true;
			}
		}
		if(flag) {
			Robot.drivetrain.setRaw1(Robot.oi.getLeftStickY(Player1)*-throttleW, Robot.oi.getRightStickY(Player1)*-throttleW);
			if(Robot.oi.getRightBumper(Player1)) {
				Grabbers = DoubleSolenoid.Value.kForward;
				Robot.drivetrain.setRawGrabber(Grabbers);
			}
			if(Robot.oi.getLeftBumper(Player1)) {
				Grabbers = DoubleSolenoid.Value.kReverse;
				Robot.drivetrain.setRawGrabber(Grabbers);
			}
			if(Robot.oi.getAButton(Player1)) {
				Punchers = DoubleSolenoid.Value.kForward;
				Robot.drivetrain.setPunchers(Punchers);
			}
			if(Robot.oi.getBButton(Player1)) {
				Punchers = DoubleSolenoid.Value.kReverse;
				Robot.drivetrain.setPunchers(Punchers);
			}
			if((Robot.oi.Dpad(Player1) >= 0 && Robot.oi.Dpad(Player1) <=45)
					||(Robot.oi.Dpad(Player1) <=360 && Robot.oi.Dpad(Player1) >=315)) {
				Robot.drivetrain.setRawSpinner(-.35,.35);
			}
			if(Robot.oi.Dpad(Player1) >= 135 && Robot.oi.Dpad(Player1) <=225) {
				Robot.drivetrain.setRawSpinner(.35,-.35);
			}
		}
		if(!flag) {
			Robot.drivetrain.setRawArm(Robot.oi.getRightStickY(Player1)*throttleA);
			if(Robot.oi.getRightBumper(Player1)) {
				Grabbers = DoubleSolenoid.Value.kForward;
				Robot.drivetrain.setRawGrabber(Grabbers);
			}
			if(Robot.oi.getLeftBumper(Player1)) {
				Grabbers = DoubleSolenoid.Value.kReverse;
				Robot.drivetrain.setRawGrabber(Grabbers);
			}
			if(Robot.oi.getAButton(Player1)) {
				Punchers = DoubleSolenoid.Value.kForward;
				Robot.drivetrain.setPunchers(Punchers);
			}
			if(Robot.oi.getBButton(Player1)) {
				Punchers = DoubleSolenoid.Value.kReverse;
				Robot.drivetrain.setPunchers(Punchers);
			}
			if((Robot.oi.Dpad(Player1) >= 0 && Robot.oi.Dpad(Player1) <=45)
					||(Robot.oi.Dpad(Player1) <=360 && Robot.oi.Dpad(Player1) >=315)) {
				Robot.drivetrain.setRawSpinner(-.55,.55);
			}
			else {
				Robot.drivetrain.setRawSpinner(0,0);
			}
			if(Robot.oi.Dpad(Player1) >= 135 && Robot.oi.Dpad(Player1) <=225) {
				Robot.drivetrain.setRawSpinner(.55,-.55);
			}
			else {
				Robot.drivetrain.setRawSpinner(0,0);
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