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
	double throttleL = 1.0; 
	double throttleA= 1.0;
	boolean arm=true;
	DoubleSolenoid.Value grabber = DoubleSolenoid.Value.kOff;
	DoubleSolenoid.Value puncher = DoubleSolenoid.Value.kOff;
	
	protected void initialize() {
	}

	protected void execute() {
		
		System.out.println(Robot.limitSwitch.get());
		
		SmartDashboard.putNumber("Range: ", Robot.ultra.GetRangeMM());
		SmartDashboard.putNumber("Angle: ", Robot.GyroAngle()); 
		
	
		if(Robot.oi.getAButton(Player1)){
			if(arm == false){
				 arm=true; }
			else if( arm == true){
				arm = false; }
			
		}
		
		 if(arm) {
			 
			 Robot.drivetrain.setRaw1((-Robot.oi.getLeftStickY(Player1)+ Robot.oi.getRightStickX(Player1))* throttleL, 
						(-Robot.oi.getLeftStickY(Player1)+ -Robot.oi.getRightStickX(Player1)) * throttleL);
		 }
		 else {
			 Robot.drivetrain.setRawArm((Robot.oi.getRightStickY(Player1)*throttleA));
		 }
		if(Robot.oi.Dpad(Player1)<180 && Robot.oi.Dpad(Player1)>=0) {
			Robot.drivetrain.setRawSpinner(0.7,-0.7);
		}
		
		else if(Robot.oi.Dpad(Player1)>180 && Robot.oi.Dpad(Player1)<=359) {
			Robot.drivetrain.setRawSpinner(-0.7, 0.7);
		}
		
		else {Robot.drivetrain.setRawSpinner(0,0);
		
		}
		
		if(Robot.oi.getYButton(Player1)) {
			grabber = DoubleSolenoid.Value.kForward;
		}
			
		if(Robot.oi.getBButton(Player1)) {
			grabber = DoubleSolenoid.Value.kReverse;
		}
		
		Robot.drivetrain.setRawGrabber(grabber);
		
		if(Robot.oi.getRightBumper(Player1)) {
			puncher = DoubleSolenoid.Value.kForward;
		}
		
		if(Robot.oi.getLeftBumper(Player1)) {
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
