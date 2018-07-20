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
	protected void initialize() {
	}
	static double distanceNW = Robot.encoderNW.getDistance();
	static double distanceNE = Robot.encoderNE.getDistance();


	int wheel = 0; 
	protected void execute(){

		distanceNW = Robot.encoderNW.getDistance();
		distanceNE = Robot.encoderNE.getDistance();
		
		//SmartDashboard
		
		if(Robot.oi.getYButton(Player1)) {
			wheel = 1; 
		}
		if(wheel == 1) {
			Robot.drivetrain.setRaw(Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1), 0, 0, 0, 0, 0, 0);
		}
		if(Robot.oi.getBButton(Player1)) {
			wheel = 2; 
		}
		if(wheel == 2) {
			Robot.drivetrain.setRaw(0, 0, Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1), 0, 0, 0, 0);
		}

		if(Robot.oi.getXButton(Player1)) {
			wheel = 3; 
		}
		if(wheel == 3) {
			Robot.drivetrain.setRaw(0, 0, 0, 0, Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1), 0, 0);
		}

		if(Robot.oi.getAButton(Player1)) {
			wheel = 4; 
		}
		if(wheel == 4) {
			Robot.drivetrain.setRaw(0, 0, 0, 0, 0, 0, Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1));
		}
		if(Robot.oi.getStartButton(Player1)) {
			wheel = 5; 
		}
		if(wheel == 5) {
			Robot.drivetrain.setRaw(Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1), Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1), Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1), Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1));
		}

		//SmartDashboard.putNumber("DistanceL: ", distanceL);
		//SmartDashboard.putNumber("DistanceR: ", distanceR);
		//SmartDashboard.putNumber("Gyro: ", Robot.GyroAngle());
		
		
	}

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
