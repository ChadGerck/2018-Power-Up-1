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
	XboxController Player2 = Robot.oi.Controller0;
	double throttleL = 0.25;
	
	
	protected void initialize() {
		
	}

	protected void execute() {
		if(Robot.oi.getRightTrigger(Player1) == 1 || Robot.oi.getRightTrigger(Player2) == 1) {
			Robot.drivetrain.setRaw1(.5,.5);
		}
		if (Robot.oi.getStartButton(Player1) || Robot.oi.getStartButton(Player2)) {
			Robot.TurnLeft();
			Robot.TurnLeft();
			Robot.MoveForward();
		}
	
		Robot.drivetrain.setRaw1(Robot.oi.getLeftStickY(Player1)*throttleL, Robot.oi.getRightStickY(Player1)*throttleL);
		Robot.drivetrain.setRaw1(Robot.oi.getLeftStickY(Player2)*throttleL, Robot.oi.getRightStickY(Player2)*throttleL);
	/*	
		 if (Robot.oi.getLeftStick(Player1)) {
		   Robot.drivetrain.setRaw1(Robot.drivetrain.setRaw1(Robot.oi.getLeftStickX(Player1))* throttleL, Robot.oi.getLeftStickY(Player1)*throttleL);
		   }
		   else if (Robot.oi.getRightStick(Player1)) {
		 	 Robot.drivetrain.setRaw1(Robot.drivetrain.setRaw1(Robot.oi.getRightStickX(Player1)* -throttleL, Robot.oi.getRightStickY(Player1)*-throttleL));
		   }
 */
	
	}

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
