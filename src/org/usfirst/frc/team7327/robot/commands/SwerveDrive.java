package org.usfirst.frc.team7327.robot.commands;

import org.usfirst.frc.team7327.robot.Robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwerveDrive extends Command {
	public SwerveDrive() {
		requires(Robot.drivetrain); 
	}

	int setting = 0; 
	public static XboxController Player1 = Robot.oi.Controller0; 
	protected void initialize() { 
		setting = 0; 
	}
	double setDegree = 0;
	
	
	protected void execute(){
		
		Robot.vision.testGearPixy();
		
		
		if(Robot.oi.getYButton(Player1)) {
			Robot.AddressWorking();
		}
		
		SmartDashboard.putNumber("Gyro: ", Robot.GyroAngle());
		SmartDashboard.putNumber("Angular Setpoint", Robot.drivetrain.getSteeringSetpoint());
		SmartDashboard.putNumber("Angular Error", Robot.drivetrain.getSteeringError());
		SmartDashboard.putNumber("Angular Position", Robot.drivetrain.getSteeringPosition());
		
		double degreesL = Math.toDegrees(Math.atan2(Robot.oi.getLeftStickY(Player1),  Robot.oi.getLeftStickX(Player1))) + 90;
		double magnitudeL = Math.sqrt(Math.pow(Robot.oi.getLeftStickX(Player1), 2) + Math.pow(Robot.oi.getLeftStickY(Player1), 2));

		double degreesR = Math.toDegrees(Math.atan2(Robot.oi.getRightStickY(Player1),  Robot.oi.getRightStickX(Player1))) + 90;
		double magnitudeR = Math.sqrt(Math.pow(Robot.oi.getRightStickX(Player1), 2) + Math.pow(Robot.oi.getRightStickY(Player1), 2));
		
		if(magnitudeR > .5) setDegree = 360-degreesR;
		
		
		if(Robot.oi.getStartButton(Player1)) Robot.gyro.reset();
		
		if(Robot.oi.getAButton(Player1))    { setting = 0; Robot.drivetrain.turning.setOn(false); }
		if(Robot.oi.getLeftBumper(Player1)) { setting = 0; Robot.drivetrain.turning.setOn(false); }
		if(Robot.oi.getRightBumper(Player1)){ setting = 1; Robot.drivetrain.turning.setOn(false); }
		if(Robot.oi.getBButton(Player1))    { setting = 4; Robot.drivetrain.turning.setOn(false); }
		
		if(Robot.oi.Dpad(Player1) >= 0 )    { setting = 2; Robot.drivetrain.turning.setOn(true);  }
		
		
		switch(setting) {
		case 0: //Power Mode
			Robot.drivetrain.setAllDegrees(setDegree+Robot.GyroAngle());
			Robot.drivetrain.setAllSpeed(Robot.oi.getLeftStickY(Player1)-Robot.oi.getRightTrigger(Player1)+Robot.oi.getLeftTrigger(Player1));
			break;
		case 1: //Turn Mode
			Robot.drivetrain.setEachDegree(225, 315, 135, 45);
			Robot.drivetrain.setAllSpeed(Robot.oi.getLeftStickX(Player1)+Robot.oi.getRightTrigger(Player1)-Robot.oi.getLeftTrigger(Player1));
			break;
		case 2: //D-Pad in Use
			Robot.drivetrain.setEachDegree(225, 315, 135, 45);
			Robot.drivetrain.turning.setYaw(Robot.oi.Dpad(Player1));
			if(Robot.oi.Dpad(Player1) == -1) { setting = 0; Robot.drivetrain.turning.setOn(false); }
			break; 
		case 4: //Precision Mode 
			Robot.drivetrain.setAllDegrees(setDegree+Robot.GyroAngle());
			Robot.drivetrain.setAllSpeed(-Robot.oi.getRightTrigger(Player1)+Robot.oi.getLeftTrigger(Player1));
			if(magnitudeL > .5) { setting = 5; Robot.drivetrain.turning.setOn(true); }
			break; 
		case 5: 
			Robot.drivetrain.setEachDegree(225, 315, 135, 45);
			Robot.drivetrain.turning.setYaw(degreesL);
			if(magnitudeL <= .5) { setting = 4; Robot.drivetrain.turning.setOn(false); }
			break; 
		}
		
	}
	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
