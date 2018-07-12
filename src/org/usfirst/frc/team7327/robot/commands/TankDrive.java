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
	//cbange
	DoubleSolenoid value = new DoubleSolenoid(5,-5);
	value.set(value.kOff);
	boolean isGrabbed = false;
	boolean isPunched = false;
	XboxController Player1 = Robot.oi.Controller0; 
	double throttleL = .25;
	double throttleA = .55;
	protected void initialize() {
		value.set(value.kReverse);
		Robot.drivetrain.setRawArm(value.kReverse);
		Robot.drivetrain.set
		Robot.drivetrain.setRawGrabber(value.kReverse);
	}
	
	
	
	protected void execute(){
		Robot.drivetrain.setRaw((-Robot.oi.getLeftStickY(Player1) - Robot.oi.getRightStickX(Player1))*throttleL, (-Robot.oi.getLeftStickY(Player1) + Robot.oi.getRightStickX(Player1))*throttleL, Robot.oi.getRightStickY(Player1)*throttleA);
		Robot.drivetrain.setRawSpinner(Robot.oi.getLeftStickX(Player1),-Robot.oi.getLeftStickX(Player1) );
		if(!isPunched && Robot.oi.getAButton(Player1) == 1){
			value.set(value.kForward);
			Robot.drivetrain.setPunchers(value.kForward);
			isPunched = true;
		}
		else if(isPunched && Robot.oi.getAButton(Player1) == 1){
			value.set(value.kReverse);
			Robot.drivetrain.setPunchers(value.kReverse));
			isPunched = false;
		}
		if(!isGrabbed && Robot.oi.getRightBumper(Player1) == 1){
			value.set(value.kForward)
			Robot.drivetrain.setRawGrabber(value.kForward);
			isGrabbed = true;
		}
		
		else if(isGrabbed && Robot.oi.getRightBumper(Player1) == 1){
			value.set(value.kReverse)
			Robot.drivetrain.setRawGrabber(value.kReverse);
			isGrabbed = false;
		}		
	}

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
