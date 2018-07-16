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

	double throttleL = 0.25;
	double throttleX = 0.30;
	boolean Arm = false;
	
	DoubleSolenoid.Value Puncher = DoubleSolenoid.Value.kOff;
	DoubleSolenoid.Value Hands =  DoubleSolenoid.Value.kOff; 
	
	protected void initialize() {
		     
	}

	protected void execute() {
		// BOOLEAN
		if (Robot.oi.getStartButton(Player1))
		{
			Arm = true;
		}
		if (Arm = true && Robot.oi.getStartButton(Player1))
		{
			Arm = false;
		}
		
		if (Arm) {
			Robot.drivetrain.setRawArm(Robot.oi.getLeftStickY(Player1)*throttleX);
		} 
		else 
			// REGULAR MOVEMENT
		{
			Robot.drivetrain.setRaw1(Robot.oi.getLeftStickY(Player1)*throttleL, Robot.oi.getRightStickY(Player1)*throttleL);
		}
		
		// 			BUMPERS
		if (Robot.oi.getRightBumper(Player1)) {
			Puncher = DoubleSolenoid.Value.kForward;
			Robot.drivetrain.setPunchers(Puncher);
		}
		else if (Robot.oi.getLeftBumper(Player1)){
			Puncher = DoubleSolenoid.Value.kReverse;
			Robot.drivetrain.setPunchers(Puncher);
		}
		
		// 			 TRIGGERS	
		if (Robot.oi.getRightTrigger(Player1) == 1) {
			Hands = DoubleSolenoid.Value.kForward;
			Robot.drivetrain.setRawGrabber(Hands);
		} 
		else if (Robot.oi.getLeftTrigger(Player1) == 1 ) {
			Hands = DoubleSolenoid.Value.kReverse;
			Robot.drivetrain.setRawGrabber(Hands);
		}
        
        /* UP          0; 
         * RIGHT       90; 
         * DOWN        180; 
         * LEFT        270; 
         */ 
		// 			DPAD
		
	if (Robot.oi.Dpad(Player1) >= 0 && Robot.oi.Dpad(Player1) <= 45 || (Robot.oi.Dpad(Player1) <= 360 && Robot.oi.Dpad(Player1) >= 315)) {
			Robot.drivetrain.setRawSpinner(-.3,  .3);
		}
	// Spin Right
	else if (Robot.oi.Dpad(Player1) >= 45 && Robot.oi.Dpad(Player1) <= 135) {
		Robot.drivetrain.setRawSpinner(.3, .3);
	}
	// Pull In 
	else if (Robot.oi.Dpad(Player1) >= 135 && Robot.oi.Dpad(Player1) <= 225) {
		Robot.drivetrain.setRawSpinner(.3,-.3);
	}
	// Spin Left
	else if (Robot.oi.Dpad(Player1) >= 225 && Robot.oi.Dpad(Player1) <= 315){
		Robot.drivetrain.setRawSpinner(-.3, -.3);
	}
		// execute  
	} 

	
	protected boolean isFinished() {
		return false;
	}

	protected void interrupted() {
		end();
	}
}
