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

	protected void execute() {
		Robot.drivetrain.setRaw1(Robot.oi.getRightStickY(Player1)+ Robot.oi.getLeftStickX(Player1)* throttleL,
				(-Robot.oi.getRightStickY(Player1)+ -Robot.oi.getLeftStickX(Player1)* throttleL));
				
			
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
	}

	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
// HELLLLOOOOOO!!!!!!
