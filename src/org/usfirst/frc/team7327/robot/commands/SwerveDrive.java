package org.usfirst.frc.team7327.robot.commands;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.opencv.core.RotatedRect;
import org.usfirst.frc.team7327.robot.Robot;
import org.usfirst.frc.team7327.robot.SwerveModule;

//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;

public class SwerveDrive extends Command {
	public SwerveDrive() {
		requires(Robot.drivetrain); 
	}
	

	int setting = 0; 
	public static XboxController Player1 = Robot.oi.Controller0; 
	protected void initialize() { 
		setting = 0; 
		addDegree = 0; 
	}

	double setDegree = 0;
	double addDegree = 0; 
	
	protected void execute(){
		
		SmartDashboard.putNumber("Gyro: ", Robot.GyroAngle());
		SmartDashboard.putNumber("Angular Setpoint", Robot.drivetrain.getSteeringSetpoint());
		SmartDashboard.putNumber("Angular Error", Robot.drivetrain.getSteeringError());
		SmartDashboard.putNumber("Angular Position", Robot.drivetrain.getSteeringPosition());
		
		
		
		
		boolean A = Robot.oi.getAButton(Player1); 
		boolean B = Robot.oi.getBButton(Player1); 
		boolean Y = Robot.oi.getYButton(Player1);
		
		double Lx = Robot.oi.getLeftStickX(Player1); 
		double Ly = Robot.oi.getLeftStickY(Player1); 
		
		double Rx = Robot.oi.getRightStickX(Player1); 
		double Ry = Robot.oi.getRightStickY(Player1);
		
		double LT = Robot.oi.getLeftTrigger(Player1); 
		double RT = Robot.oi.getRightTrigger(Player1); 
		boolean Lb = Robot.oi.getLeftBumper(Player1);
		boolean Rb = Robot.oi.getRightBumper(Player1);
		boolean StartButton = Robot.oi.getStartButton(Player1); 
		boolean BackButton = Robot.oi.getSlowButton(Player1); 
		
		
		double degreesL = Math.toDegrees(Math.atan2(Ly,  Lx)) + 90;
		double magnitudeL = Math.sqrt(Math.pow(Lx, 2) + Math.pow(Ly, 2));
		

		double degreesR = Math.toDegrees(Math.atan2(Ry,  Rx)) + 90;
		double magnitudeR = Math.sqrt(Math.pow(Rx, 2) + Math.pow(Ry, 2));
		
		 
		
		if(magnitudeR > .5) {
			setDegree = 360-degreesR;
		}
		
		
		
		
		if(StartButton) Robot.gyro.reset();
		if(BackButton) addDegree = setDegree; 
		
		if(A)  { setting = 0; Robot.drivetrain.turning.setOn(false); }
		if(Lb) { setting = 0; Robot.drivetrain.turning.setOn(false); }
		if(Rb) { setting = 1; Robot.drivetrain.turning.setOn(false); }
		if(Y)  { setting = 3; Robot.drivetrain.turning.setOn(false); }
		if(B)  { setting = 4; Robot.drivetrain.turning.setOn(false); }
		
		if(Robot.oi.Dpad(Player1) >= 0 ) { setting = 2; Robot.drivetrain.turning.setOn(true); }
	
		switch(setting) {
		case 0: 
			Robot.drivetrain.setAllDegrees(setDegree+Robot.GyroAngle()+addDegree);
			Robot.drivetrain.setAllSpeed(Ly-RT+LT);
			break;
		case 1:
			Robot.drivetrain.setEachDegree(225, 315, 135, 45);
			Robot.drivetrain.setAllSpeed(Lx+RT-LT);
			break;
		case 2: 
			Robot.drivetrain.setEachDegree(225, 315, 135, 45);
			Robot.drivetrain.turning.setYaw(Robot.oi.Dpad(Player1));
			if(Robot.oi.Dpad(Player1) == -1) { setting = 0; Robot.drivetrain.turning.setOn(false); }
			break; 
		case 3: 
			Robot.drivetrain.setAllDegrees(setDegree+Robot.GyroAngle()+addDegree);
			//NW, NE, SW, SE
			//sin(gyro), cos(gyro), -sin(gyro), -cos(gyro) 
			
			if(Robot.GyroAngle() >= 0 && Robot.GyroAngle() < 45 )
			{
				Robot.drivetrain.setEachSpeed((Ly-RT+LT+(Lx))*.5,(Ly-RT+LT-(Lx))*.5,(Ly-RT+LT+(Lx))*.5,(Ly-RT+LT-(Lx))*.5);
			}
			else if(Robot.GyroAngle() >= 45 && Robot.GyroAngle() < 90 )
			{
				Robot.drivetrain.setEachSpeed((Ly-RT+LT)*.5,(Ly-RT+LT-(Lx))*.5,(Ly-RT+LT+(Lx))*.5,(Ly-RT+LT)*.5);
			}
			else if(Robot.GyroAngle() >= 90 && Robot.GyroAngle() < 135 )
			{
				Robot.drivetrain.setEachSpeed((Ly-RT+LT-(Lx))*.5,(Ly-RT+LT-(Lx))*.5,(Ly-RT+LT+(Lx))*.5,(Ly-RT+LT+(Lx))*.5);
			}
			else if(Robot.GyroAngle() >= 135 && Robot.GyroAngle() < 180 )
			{
				Robot.drivetrain.setEachSpeed((Ly-RT+LT-(Lx))*.5,(Ly-RT+LT)*.5,(Ly-RT+LT)*.5,(Ly-RT+LT+(Lx))*.5);
			}
			else if(Robot.GyroAngle() >= 180 && Robot.GyroAngle() < 225 )
			{
				Robot.drivetrain.setEachSpeed((Ly-RT+LT-(Lx))*.5,(Ly-RT+LT+(Lx))*.5,(Ly-RT+LT-(Lx))*.5,(Ly-RT+LT+(Lx))*.5);
			}
			else if(Robot.GyroAngle() >= 225 && Robot.GyroAngle() < 270 )
			{
				Robot.drivetrain.setEachSpeed((Ly-RT+LT)*.5,(Ly-RT+LT+(Lx))*.5,(Ly-RT+LT-(Lx))*.5,(Ly-RT+LT)*.5);
			}
			else if(Robot.GyroAngle() >= 270 && Robot.GyroAngle() < 325 )
			{
				Robot.drivetrain.setEachSpeed((Ly-RT+LT+(Lx))*.5,(Ly-RT+LT+(Lx))*.5,(Ly-RT+LT-(Lx))*.5,(Ly-RT+LT-(Lx))*.5);
			}
			else if( Robot.GyroAngle() >= 325 && Robot.GyroAngle() <= 360 )
			{
				Robot.drivetrain.setEachSpeed((Ly-RT+LT+(Lx))*.5,(Ly-RT+LT)*.5,(Ly-RT+LT)*.5,(Ly-RT+LT-(Lx))*.5);
			}
			break;
		case 4: //Precision Mode 
			Robot.drivetrain.setAllDegrees(setDegree+Robot.GyroAngle()+addDegree);
			Robot.drivetrain.setAllSpeed(-RT+LT);
			if(magnitudeL > .5) { setting = 5; Robot.drivetrain.turning.setOn(true); }
			break; 
		case 5: 
			Robot.drivetrain.setEachDegree(225, 315, 135, 45);
			Robot.drivetrain.turning.setYaw(degreesL);
			if(magnitudeL <= .5) { setting = 4; Robot.drivetrain.turning.setOn(false); }
		}
		
	}
	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
