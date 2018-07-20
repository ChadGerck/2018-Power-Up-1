/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7327.robot;

import com.analog.adis16448.frc.ADIS16448_IMU;

import java.io.IOException;

import org.usfirst.frc.team7327.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Timer;
	//import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.CameraServer;

import edu.wpi.first.wpilibj.Compressor;

import edu.wpi.first.wpilibj.DoubleSolenoid;
	//import edu.wpi.first.wpilibj.Compressor;
	//import java.util.Timer;

import edu.wpi.first.wpilibj.DriverStation;

import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
	//import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.*;

public class Robot extends TimedRobot { 
	//public static final ADIS16448_IMU imu = new ADIS16448_IMU();
	//public static SPI spi;
	public static OI oi;
	public static DriveTrain drivetrain;
	//CameraServer Camera;
	public static Encoder encoderNW;
	public static Encoder encoderNE;
	public static Encoder encoderSW;
	public static Encoder encoderSE;
	//public static ADXRS450_Gyro gyro; 

	
	//public static boolean tele = false;
	
	
	//private DriverStation.Alliance color = DriverStation.getInstance().getAlliance();
	public static int station = DriverStation.getInstance().getLocation();
	//private String gameData;
	
	//Change based on alliance
	//private char RobotLocation = 'L';
	
	public static Timer myTimer = new Timer();
	public static boolean done = true; 
	//public static boolean killButton = true; 

	@Override
	public void robotInit() {
		myTimer.reset();
		myTimer.start();
		
		//limitSwitch = new DigitalInput(8);
		//gyro = new ADXRS450_Gyro(Port.kOnboardCS0);
		
		encoderSE = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		encoderSE.setMaxPeriod(.1);
		encoderSE.setMinRate(10);
		encoderSE.setDistancePerPulse(.0073);
		encoderSE.setReverseDirection(false);
		encoderSE.setSamplesToAverage(7);
		encoderSE.reset();
		
		
		encoderSW = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		encoderSW.setMaxPeriod(.1);
		encoderSW.setMinRate(10);
		encoderSW.setDistancePerPulse(.0073);
		encoderSW.setReverseDirection(true);
		encoderSW.setSamplesToAverage(7);
		encoderSW.reset();
		
		encoderNW = new Encoder(7, 6, false, Encoder.EncodingType.k4X);
		encoderNW.setMaxPeriod(.1);
		encoderNW.setMinRate(10);
		encoderNW.setDistancePerPulse(.0073);
		encoderNW.setReverseDirection(true);
		encoderNW.setSamplesToAverage(7);
		encoderNW.reset();
		
		encoderNE = new Encoder(9, 8, false, Encoder.EncodingType.k4X);
		encoderNE.setMaxPeriod(.1);
		encoderNE.setMinRate(10);
		encoderNE.setDistancePerPulse(.0073);
		encoderNE.setReverseDirection(true);
		encoderNE.setSamplesToAverage(7);
		encoderNE.reset();
		
				
		oi = new OI();
		drivetrain = new DriveTrain();
		//Camera = CameraServer.getInstance();
		//Camera.startAutomaticCapture();
		//Camera.getVideo();
		
		//gyro.calibrate();
		
	}


	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		myTimer.reset();
		myTimer.start();
		//gyro.reset();
		encoderNW.reset();
		encoderNE.reset();
		encoderSW.reset();
		encoderSE.reset();
		//Autonomous.Auto();
		//station = DriverStation.getInstance().getLocation();
		
		
	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {


		encoderNW.reset();
		encoderNE.reset();
		encoderSW.reset();
		encoderSE.reset();
		//gyro.reset();
		//tele = true; 
		
		
		//imu.reset();
		//imu.calibrate();
		//gyroOffset = imu.getYaw(); 
		
	}
	

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		
	}

	@Override
	public void testPeriodic() {
	}
	/*
	public static void MoveForward() {
		MoveDistance(GyroAngle(), .25, 1); 
	}

	public static void MoveDistance(double angle, double speed, double distance) { 
		
		double distanceL = Robot.encoderL.getDistance();
		double distanceR = Robot.encoderR.getDistance();
		double avgDistance = 0; 
		double distanceDone = ((Robot.encoderL.getDistance()) + (Robot.encoderR.getDistance()))/2;
		double templ = speed; 
		double tempr = speed; 
		
		while(!tele && avgDistance < distance ) {
			SmartDashboard.putNumber("Gyro: ", GyroAngle());
			distanceL = Robot.encoderL.getDistance();
			distanceR = Robot.encoderR.getDistance();
			SmartDashboard.putNumber("DistanceL: ", distanceL);
			SmartDashboard.putNumber("DistanceR: ", distanceR);
			drivetrain.setRaw(templ, tempr, 0);
			if(Math.sin(Math.toRadians(GyroAngle()+angle)) < -.01) {
				if(templ < speed + .05) { templ += .001;  }
				else { templ -= .001; tempr -= .002; }
			}else if(Math.sin(Math.toRadians(GyroAngle()+angle)) > .01 ) {
				if(tempr < speed + .05) { tempr += .001; }
				else { tempr -= .001; templ -= .002; } 
			}else {
				templ = speed; 
				tempr = speed; 
			}
			try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
			avgDistance = (((Robot.encoderL.getDistance()) + (Robot.encoderR.getDistance()))/2)-distanceDone;
			System.out.println(avgDistance); 
			
		}  
		drivetrain.setRaw(0, 0, 0); 
	}
	
	
	public void MoveTime(double angle, double speed, double time) { 
		
		time = myTimer.get() + time;
		double templ = speed; 
		double tempr = speed; 
		while(!tele && myTimer.get() < time ) {
			
			SmartDashboard.putNumber("Gyro: ", GyroAngle());
			drivetrain.setRaw(templ, tempr, 0);
			if(Math.sin(Math.toRadians(GyroAngle()+angle)) < -.01) {
				if(templ < speed + .05) { templ += .001;  }
				else { templ -= .001; tempr -= .002; }
			}else if(Math.sin(Math.toRadians(GyroAngle()+angle)) > .01 ) {
				if(tempr < speed + .05) { tempr += .001; }
				else { tempr -= .001; templ -= .002; } 
			}else {
				templ = speed; 
				tempr = speed; 
			}
			try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
		}  
		drivetrain.setRaw(0, 0, 0); 
		
	}
	
	public static void TurnRight() {
		TurnTo(GyroAngle(90)); 
	}
	
	public static void TurnLeft() {
		TurnTo(GyroAngle(-90)); 
	}
	
	public static void TurnTo(double degrees){
		double Phi = GyroAngle(); 
		if(Math.sin(Math.toRadians(degrees - Phi)) < 0) {
			while(!tele && Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("Gyro: ", GyroAngle());
				drivetrain.setRaw(-.3, .4, 0); 
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = GyroAngle();
			} 
			while(!tele && Math.sin(Math.toRadians(degrees-Phi)) > 0) {
				SmartDashboard.putNumber("Gyro: ", GyroAngle());
				drivetrain.setRaw(.25, -.25, 0); 
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = GyroAngle();
			} 
		}else {
			while(!tele && Math.sin(Math.toRadians(degrees-Phi)) >= 0) {
				SmartDashboard.putNumber("Gyro: ", GyroAngle());
				drivetrain.setRaw(.4, -.3, 0); 
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = GyroAngle();
			}
			while(!tele && Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("Gyro: ", GyroAngle());
				drivetrain.setRaw(-.25, .25, 0); 
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = GyroAngle();
			}
		}
	}
	
	public static double GyroAngle() {
		double angle = Robot.gyro.getAngle();
		while(angle > 360) { angle -= 360; }
		while(angle < 0)   { angle += 360; }
		return angle; 
	}
	
	public static double GyroAngle(double add) {
		double angle = Robot.gyro.getAngle() + add;
		while(angle > 360) { angle -= 360; }
		while(angle < 0)   { angle += 360; }
		return angle; 
	}
	
	public static void ShootBox() {
		double time = myTimer.get() + .15;
		while(myTimer.get() < time) { Robot.drivetrain.setPunchers(DoubleSolenoid.Value.kReverse); }
		while(myTimer.get() < time + .1) { Robot.drivetrain.setRawGrabber(DoubleSolenoid.Value.kForward); }
	}
	*/
	
}