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
		if (Robot.oi.getStartButton(Player1)) {
			Robot.TurnLeft();
			Robot.TurnLeft();
			Robot.MoveForward();
		}
		
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
		} else 
		{
			Robot.drivetrain.setRaw1(Robot.oi.getLeftStickY(Player1)*throttleL, Robot.oi.getRightStickY(Player1)*throttleL);
		}
	
		if (Robot.oi.getRightBumper(Player1)) {
			Puncher = DoubleSolenoid.Value.kForward;
			Robot.drivetrain.setPunchers(Puncher);
		}
		else if (Robot.oi.getLeftBumper(Player1)){
			Puncher = DoubleSolenoid.Value.kReverse;
			Robot.drivetrain.setPunchers(Puncher);
		}
		
		if (Robot.oi.getRightTrigger(Player1) == 1) {
			Hands = DoubleSolenoid.Value.kForward;
			Robot.drivetrain.setRawGrabber(Hands);
		} 
		else if (Robot.oi.getLeftTrigger(Player1) == 1 ) {
			Hands = DoubleSolenoid.Value.kReverse;
			Robot.drivetrain.setRawGrabber(Hands);
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
