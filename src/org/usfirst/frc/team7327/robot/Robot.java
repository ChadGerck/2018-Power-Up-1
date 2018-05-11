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
	//import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.XboxController;
	//import edu.wpi.first.wpilibj.Timer;
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
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Talon;
	//import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.*;

public class Robot extends TimedRobot { 
	//public static final ADIS16448_IMU imu = new ADIS16448_IMU();
	//public static SPI spi;
	public static OI oi;
	public static DriveTrain drivetrain;
	CameraServer Camera;
	public static Encoder encoderL1;
	public static Encoder encoderL2;
	public static Encoder encoderR1;
	public static Encoder encoderR2;

	//public double gyro; 
	//public double gyroOffset;
	//private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
    XboxController Controller1;
    Talon talon;
	Compressor c0 = new Compressor(0);
	
	static DoubleSolenoid.Value GrabOff = DoubleSolenoid.Value.kOff; 
	
	//private DriverStation.Alliance color = DriverStation.getInstance().getAlliance();
	//private int station = DriverStation.getInstance().getLocation();
	//private String gameData;
	
	//Change based on alliance
	//private char RobotLocation = 'L';
	
	//public static Timer myTimer = new Timer();
	public static boolean done = true; 
	//public static boolean killButton = true; 
	

	@Override
	public void robotInit() {
		
		encoderL1 = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		encoderL1.setMaxPeriod(.1);
		encoderL1.setMinRate(10);
		encoderL1.setDistancePerPulse(5);
		encoderL1.setReverseDirection(false);
		encoderL1.setSamplesToAverage(7);
		
		encoderL2 = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		encoderL2.setMaxPeriod(.1);
		encoderL2.setMinRate(10);
		encoderL2.setDistancePerPulse(5);
		encoderL2.setReverseDirection(false);
		encoderL2.setSamplesToAverage(7);
		
		encoderR1 = new Encoder(4, 5, false, Encoder.EncodingType.k4X);
		encoderR1.setMaxPeriod(.1);
		encoderR1.setMinRate(10);
		encoderR1.setDistancePerPulse(5);
		encoderR1.setReverseDirection(true);
		encoderR1.setSamplesToAverage(7);
		encoderR1.reset();
		
		encoderR2 = new Encoder(6, 7, false, Encoder.EncodingType.k4X);
		encoderR2.setMaxPeriod(.1);
		encoderR2.setMinRate(10);
		encoderR2.setDistancePerPulse(5);
		encoderR2.setReverseDirection(true);
		encoderR2.setSamplesToAverage(7);
		encoderR2.reset();
				
		oi = new OI();
		drivetrain = new DriveTrain();
		Camera = CameraServer.getInstance();
		Camera.startAutomaticCapture();
		Camera.getVideo();
		c0.setClosedLoopControl(true); 

   /*  encoder.setSamplesToAverage(5); // Used to reduce noise in period
     encoder.setDistancePerPulse(1.0/360); // This makes it so that GetDistance will return 1 when the shaft 
     // makes a full rotation and that GetRate will be in Revs per second
	*/
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
		//myTimer.reset();
		//myTimer.start();
/*
 
		gameData = ("NULL".equalsIgnoreCase(gameData)) ? null : gameData; 
		while(gameData == null) {
			gameData = DriverStation.getInstance().getGameSpecificMessage();
		}
		

		gameData = DriverStation.getInstance().getGameSpecificMessage();
		System.out.println("This is your gameData" + gameData.charAt(0)); 
		
		*/
		long startTime = System.currentTimeMillis();
		long elapsedTime = System.currentTimeMillis() - startTime;
		long elapsedSeconds = elapsedTime /1000; 
		
		
		while(isAutonomous() && elapsedSeconds < 10) {
			elapsedTime = System.currentTimeMillis() - startTime;
			elapsedSeconds = elapsedTime /1000;
			if(elapsedSeconds < 2) {drivetrain.setRaw(.35,.36,0,0);}
			if(elapsedSeconds >= 2 && elapsedSeconds < 4) {drivetrain.setRaw(0,0, 0, -.55);}
			if(elapsedSeconds >= 4 && elapsedSeconds < 10) {drivetrain.setRaw(.35,.36, 0, 0);}
			//if(elapsedSeconds >= 2 && elapsedSeconds <6) {drivetrain.setRaw(-.35,-.36, 0, 0,);}
			//if(elapsedSeconds >= 6 && elapsedSeconds <7 && gameData.charAt(0) == 'R'  ) { drivetrain.setRaw(0, 0, 0, 0, DoubleSolenoid.Value.kReverse);}
		//drivetrain.setRaw(leftvalue, rightvalue, wheelvalue, armvalue, grabbervalue);	
			
		}
		
       
		drivetrain.setRaw(0, 0, 0, 0);
		
		/*
		switch(station){
		case 1: // Q 15
			if(RobotLocation == 'L') { 
				MoveForward(-.35,-.36, 3); }//BackwardsPrioritizeScale(); } //Match 2
			else if(RobotLocation == 'M') { MiddlePrioritizeSwitch(); }
			else if(RobotLocation == 'R') { BackwardsPrioritizeScale(); }
			break;
		case 2: // Q 79
			if(RobotLocation == 'L') { BackwardsPrioritizeScale(); }
			else if(RobotLocation == 'M') { MiddlePrioritizeSwitch();  }//Match 8
			else if(RobotLocation == 'R') { BackwardsPrioritizeScale(); }
			break;
		case 3: // Q 49, 96, and 103
			while(isAutonomous() && elapsedSeconds < 3) {
				elapsedTime = System.currentTimeMillis() - startTime;
				elapsedSeconds = elapsedTime /1000; 
				if(elapsedSeconds <3) {drivetrain.setRaw(-.3,-.31, 0, 0,);}
			}
		*/	
		
		 
		
		drivetrain.setRaw(0, 0, 0, 0);
		
	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

		encoderL1.reset();
		encoderL2.reset();
		encoderR1.reset();
		encoderR2.reset();
		//imu.reset();
		//imu.calibrate();
		//gyroOffset = imu.getYaw(); 
		
	}
	

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	    //SmartDashboard.putNumber("Gyro-X", imu.getAngleX());
	    //SmartDashboard.putNumber("Gyro-Y", imu.getAngleY());
	    //SmartDashboard.putNumber("Gyro-Z", imu.getAngleZ());
	    //SmartDashboard.putNumber("Gyro-X", getAngle());
	    //SmartDashboard.putNumber("Accel-X", imu.getAccelX());
	    //SmartDashboard.putNumber("Accel-Y", imu.getAccelY());
	    //SmartDashboard.putNumber("Accel-Z", imu.getAccelZ());
	    
	    //SmartDashboard.putNumber("Pitch", imu.getPitch());
	    //SmartDashboard.putNumber("Roll", imu.getRoll());
	    //gyro = imu.getYaw() - gyroOffset;
	    //if(gyro < 0) {
	    	//gyro = 360+gyro; 
	    }
	    //SmartDashboard.putNumber("Gyro: ", gyro);
	    
	    //SmartDashboard.putNumber("Pressure: ", imu.getBarometricPressure());
	    //SmartDashboard.putNumber("Temperature: ", imu.getTemperature()); 
	//}

	@Override
	public void testPeriodic() {
	}
	
	/*
	public void ForwardPrioritizeScale() {
		BeginLift();
	}
	
	public void BackwardsPrioritizeScale() {
		if(RobotLocation == gameData.charAt(1)) {
			double x = .35;
			double y = .36; 
			
			MoveForward(x, y, 1); 
			MoveRaw(x, y, 0, -.35, 2);
			MoveForward(x, y, 3);
			ArmBasetoTop();
			ShootBox();
			//MoveForward(-x, -y, 1);
			
		}
		else {
			MoveForward(.5, .5, 4);
			MoveForward(-.3, .4, 1);
		}
		drivetrain.setRaw(0, 0, 0, 0); 
	}
	
	public void BackwardsPrioritizeSwitch() {
		if(RobotLocation == gameData.charAt(0)) {
			double x = .35;
			double y = .36; 
			MoveForward(x, y, 1);
			MoveRaw(x, y, 0, -.35, 2);
			BeginLift(); 
			TurnLeft(); 
			MoveForward(-x, -y, 1);
			ShootBox(); 
			
		}
		else { BackwardsPrioritizeScale(); }
		drivetrain.setRaw(0, 0, 0, 0);
	}
	
	public void ForwardsPrioritizeSwitch() {
		if(RobotLocation == gameData.charAt(0)) {
			double x = .35;
			double y = .36; 
			MoveForward(-x, -y, 1);
			MoveRaw(-x, -y, 0, -.35, 2);
			BeginLift(); 
			TurnRight(); 
			MoveForward(-x, -y, 1);
			//ShootBox(); 
			drivetrain.setRaw(0, 0, 0, 0,DoubleSolenoid.Value.kForward);
			
		}
		else { MoveForward(-.35, -.36, 3); }
		drivetrain.setRaw(0, 0, 0, 0);
	}
	
	public void ResetBackwards() {
		if(RobotLocation == gameData.charAt(1)) {
			double x = -.35;
			double y = -.36; 
			
			ArmToptoBase();
			MoveForward(x, y, 3);
			MoveRaw(x, y, 0, .35, 2);
			MoveForward(x, y, 1); 
			
		}
		else {
			MoveForward(.3, -.4, 1);
			MoveForward(-.5, -.5, 4);
		}
		drivetrain.setRaw(0, 0, 0, 0); 
	}
	
	public void MiddlePrioritizeSwitch() {
		if(gameData.charAt(0) == 'R')
		{
				//changing code to start robot on Right middle side in front of switch. 
				BeginLift(); 
				BeginLift();
				MoveForward(-.35, -.353, 3.8);
				ShootBox();
		} else if(gameData.charAt(0) == 'L'){
				BeginLift(); 
				MoveForward(-.35, -.353, 1.8);
				TurnLeft();
				MoveForward(-.35,-.353,3);
				TurnRight(); 
				BeginLift();
				MoveForward(-.35, -.35, 2);
				ShootBox();
		}
	}
	
	public static void BeginLift() {
		Robot.done = false; 
		double time = myTimer.get() + 1.2; 
		while(myTimer.get() < time && killButton) {drivetrain.setRaw(0,0,0,-.3); }
		Robot.done = true; 
	}
	
	public void MoveRaw(double x, double y, double wheel, double arm, double time) {
		time = myTimer.get() + time; 
		while(isAutonomous() && myTimer.get() < time) {
			drivetrain.setRaw(x, y, wheel, arm); 
		}
		drivetrain.setRaw(0, 0, 0, 0); 
		
	}
	
	public void MoveForward(double x, double y, double time) {
		time = myTimer.get() + time; 
		while(isAutonomous() && myTimer.get() < time) {
			drivetrain.setRaw(x, y, 0, 0); 
		}  
		drivetrain.setRaw(0, 0, 0, 0); 
	}
	public void TurnLeft() {
		double time = myTimer.get() + 1; 
		while(myTimer.get() < time) {
			drivetrain.setRaw(.3, -.4, 0, 0); 
		}
		drivetrain.setRaw(0, 0, 0, 0); 
	}
	
	public void TurnRight() {
		double time = myTimer.get() + 1; 
		while(myTimer.get() < time) {
			drivetrain.setRaw(-.4, .3, 0, 0); 
		}
		drivetrain.setRaw(0, 0, 0, 0); 
	}
	
	public void MoveArm(double arm, double time) {
		time = myTimer.get() + time; 
		while(isAutonomous() && myTimer.get() < time) {
			drivetrain.setRaw(0, 0, 0, arm);  
		}
		drivetrain.setRaw(0, 0, 0, 0); 
		
	}
	
	public void ShootBox() {
		double time = myTimer.get() + .3; 
		while(isAutonomous() && myTimer.get() < time) {
			drivetrain.setRaw(0, 0, .5, 0);  
		}
		drivetrain.setRaw(0, 0, 0, 0); 
		
	}
	
	public static void ArmBasetoTop() {
		Robot.done = false; 
		double time = myTimer.get() + 3.27;
		double arm0 = -.6, arma = 0, armd = 0;
		while( myTimer.get() < time && killButton) {
			if(myTimer.get() < time - 2.27) { 
				arma = arm0 - .2*(time - myTimer.get());
				drivetrain.setRaw(0, 0, 0, arma); 
			} 
			else if(myTimer.get() < time) { 
				armd = arma + .2*(time - myTimer.get() - 1);
				drivetrain.setRaw(0, 0, 0, armd); 
			}
			
		}
		drivetrain.setRaw(0, 0, 0, 0); 
		Robot.done = true; 
	}
	
	public static void ArmToptoBase() {
		Robot.done = false; 
		double time = myTimer.get() + 3.27;
		double arm0 = .6, arma = 0, armd = 0;
		while( myTimer.get() < time && killButton) {
			if(myTimer.get() < time - 2.27) { 
				arma = arm0 + .2*(time - myTimer.get());
				drivetrain.setRaw(0, 0, 0, arma); 
			} 
			else if(myTimer.get() < time) { 
				armd = arma - .2*(time - myTimer.get() - 1);
				drivetrain.setRaw(0, 0, 0, armd); 
			}
			
		}
		drivetrain.setRaw(0, 0, 0, 0); 
		Robot.done = true; 
	}
	
	public static void DelayedStart() {
		double time = myTimer.get() + 14; 
		while(myTimer.get() < time) {
			//raise arm here
			if(myTimer.get() > time - 7) {
				drivetrain.setRaw(.45, .45, 0, 0); 
			}
		}
		drivetrain.setRaw(0, 0, 0, 0); 
	}
	
	public static void ReleaseFunction() {
		double time = myTimer.get();
		if(myTimer.get() < time + .6) { drivetrain.setRaw(0, 0, 0, .5); }
		if(myTimer.get() >= time + .6 && myTimer.get() < .7) drivetrain.setRaw(0, 0, 0, .5, DoubleSolenoid.Value.kForward);
		if(myTimer.get() >= time + .7 && myTimer.get() < 1) drivetrain.setRaw(0, 0, 0, .5, GrabOff);
	}*/
	
}