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
	static double distanceSW = Robot.encoderSW.getDistance();
	static double distanceSE = Robot.encoderSE.getDistance();
	static double errorNW = 0; 
	static double errorNE = 0; 
	static double errorSW = 0; 
	static double errorSE = 0; 
	static double totalDistance = 0; 


	int wheel = 0; 
	protected void execute(){

		distanceNW = Robot.encoderNW.getDistance();
		distanceNE = Robot.encoderNE.getDistance();
		distanceSW = Robot.encoderSW.getDistance();
		distanceSE = Robot.encoderSE.getDistance();
		

		SmartDashboard.putNumber("DistanceNW: ", distanceNW);
		SmartDashboard.putNumber("DistanceNE: ", distanceNE);
		SmartDashboard.putNumber("DistanceSW: ", distanceSW);
		SmartDashboard.putNumber("DistanceSE: ", distanceSE);
		
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
		
		totalDistance = (distanceNW+distanceNE+distanceSW+distanceSE)/4;

		if(Robot.oi.getLeftStickX(Player1) == 0 ) {
			errorNW = totalDistance - distanceNW;
			errorNE = totalDistance - distanceNE;
			errorSW = totalDistance - distanceSW;
			errorSE = totalDistance - distanceSE;
			if(Math.abs(errorNW) > Math.abs(errorNE)) {
				if(Math.abs(errorNW)>Math.abs(errorSW)) {
					if(Math.abs(errorNW)>Math.abs(errorSE)) {
						if(errorNW > 0) {Robot.drivetrain.setlNW(.15);} else {Robot.drivetrain.setlNW(-.15);}
					}
					else {
						if(errorSE > 0) {Robot.drivetrain.setlSE(-.15);} else {Robot.drivetrain.setlSE(.15);}
					}
				}
				else {
					if(Math.abs(errorSW)>Math.abs(errorSE)) {
						if(errorSW > 0 ) {Robot.drivetrain.setlSW(-.15);} else {Robot.drivetrain.setlSW(.15);}
					}
					else {
						if(errorSE > 0) {Robot.drivetrain.setlSE(-.15);} else {Robot.drivetrain.setlSE(.15);}
					}
				}
			}
			else {
				if(Math.abs(errorNE)>Math.abs(errorSW)) {
					if(Math.abs(errorNE)>Math.abs(errorSE)) {
						if(errorNE > 0) {Robot.drivetrain.setlNE(-.15);} else {Robot.drivetrain.setlNE(.15);}
					}
					else {
						if(errorSE > 0) {Robot.drivetrain.setlSE(-.15);} else {Robot.drivetrain.setlSE(.15);}
					}
				}
				else {
					if(Math.abs(errorSW)>Math.abs(errorSE)) {
						if(errorSW > 0 ) {Robot.drivetrain.setlSW(-.15);} else {Robot.drivetrain.setlSW(.15);}
					}
					else {
						if(errorSE > 0) {Robot.drivetrain.setlSE(-.15);} else {Robot.drivetrain.setlSE(.15);}
					}
				}
			}
		}
		
		
		/*
		if(Robot.oi.getLeftStickX(Player1) == 0 ) {
			if(distanceNW < totalDistance) {
				Robot.drivetrain.setlNW(.15);
			}
			else if(distanceNW > totalDistance) {
				Robot.drivetrain.setlNW(-.15);
			}
			if(distanceNE < totalDistance) {
				Robot.drivetrain.setlNE(-.15);
			}
			else if(distanceNE > totalDistance) {
				Robot.drivetrain.setlNE(.15);
			}
			if(distanceSW < totalDistance) {
				Robot.drivetrain.setlSW(-.15);
			}
			else if(distanceSW > totalDistance) {
				Robot.drivetrain.setlSW(.15);
			}
			if(distanceSE < totalDistance) {
				Robot.drivetrain.setlSE(-.15);
			}
			else if(distanceSE > totalDistance) {
				Robot.drivetrain.setlSE(.15);
			}
			
			
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
