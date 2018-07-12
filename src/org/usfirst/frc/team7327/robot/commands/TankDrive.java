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
	double spinner = 0; 
	

	protected void initialize() {
	}

	protected void execute() {
		
		
		Robot.drivetrain.setRaw1((-Robot.oi.getLeftStickY(Player1)+ Robot.oi.getRightStickX(Player1))* throttleL, 
				(-Robot.oi.getLeftStickY(Player1)+ -Robot.oi.getRightStickX(Player1)) * throttleL);
		
		Robot.drivetrain.setRawArm((Robot.oi.getRightTrigger(Player1)+ -Robot.oi.getLeftTrigger(Player1))*throttleL);
		
		//Robot.drivetrain.setRawGrabber(grabbervalue);
		
		/*if(Robot.oi.getLeftBumper(Player1) && !Robot.oi.getRightBumper(Player1)) {
			spinner = .5; 
		}
		
		else if(Robot.oi.getRightBumper(Player1) && !Robot.oi.getLeftBumper(Player1)) {
			Robot.drivetrain.setRawSpinner(-0.5, 0.5);
		}

		Robot.drivetrain.setRawSpinner(spinner,-0.5);
		
		//Robot.drivetrain.setRaw((Robot.oi.getRightBumper(Player1)), (Robot.oi.getRightBumper(Player1)));
*/
	}

	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
