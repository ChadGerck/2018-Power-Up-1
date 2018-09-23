/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7327.robot;

import com.analog.adis16448.frc.ADIS16448_IMU;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.io.IOException;

//import org.usfirst.frc.team7327.robot.commands.TankDrive;
import org.usfirst.frc.team7327.robot.commands.SwerveDrive;
import org.usfirst.frc.team7327.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Timer;
	//import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
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
	public static OI oi;
	public static DriveTrain drivetrain;
	//public static TankDrive tankdrive; 
	public static SwerveDrive swervedrive; 
	//CameraServer Camera;
	public static Encoder encoderNW;
	public static Encoder encoderNE;
	public static Encoder encoderSW;
	public static Encoder encoderSE;
	
	ExecutorService executorService = Executors.newFixedThreadPool(4);

	public static Potentiometer abeNW = new AnalogPotentiometer(0, 360, -184.2);
	public static Potentiometer abeNE = new AnalogPotentiometer(1, 360, -73.85);
	public static Potentiometer abeSW = new AnalogPotentiometer(2, 360, -281.3);
	public static Potentiometer abeSE = new AnalogPotentiometer(3, 360, -70.7);
	public static ADXRS450_Gyro gyro; 
	
	
	public static double NWdegree = 0; 
	public static double NEdegree = 0;
	public static double SWdegree = 0;
	public static double SEdegree = 0;
	
	
	public static Timer myTimer = new Timer();
	public static boolean done = true; 
	
	@Override
	public void robotInit() {
		myTimer.reset();
		myTimer.start();
		
		gyro = new ADXRS450_Gyro(Port.kOnboardCS0);
		
		
		encoderSE = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
		encoderSE.setMaxPeriod(.1);
		encoderSE.setMinRate(10);
		encoderSE.setDistancePerPulse(.0073);
		encoderSE.setSamplesToAverage(7);
		encoderSE.reset();
		
		
		encoderSW = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
		encoderSW.setMaxPeriod(.1);
		encoderSW.setMinRate(10);
		encoderSW.setDistancePerPulse(.0073);
		encoderSW.setSamplesToAverage(7);
		encoderSW.reset();
		
		encoderNW = new Encoder(7, 6, true, Encoder.EncodingType.k4X);
		encoderNW.setMaxPeriod(.1);
		encoderNW.setMinRate(10);
		encoderNW.setDistancePerPulse(.0073);
		encoderNW.setSamplesToAverage(7);
		encoderNW.reset();
		
		encoderNE = new Encoder(9, 8, true, Encoder.EncodingType.k4X);
		encoderNE.setMaxPeriod(.1);
		encoderNE.setMinRate(10);
		encoderNE.setDistancePerPulse(.0073);
		encoderNE.setSamplesToAverage(7);
		encoderNE.reset();
		
				
		oi = new OI();
		drivetrain = new DriveTrain();
		//Camera = CameraServer.getInstance();
		//Camera.startAutomaticCapture();
		//Camera.getVideo();
		
		gyro.calibrate();
		
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
		gyro.reset();
		encoderNW.reset();
		encoderNE.reset();
		encoderSW.reset();
		encoderSE.reset();
		/*
		while(myTimer.get() < 6) {
			if(myTimer.get() < 5) {
				Robot.drivetrain.setautoSpeed(.25);
			}
			else {
				Robot.drivetrain.setautoSpeed(0);
			}
			System.out.println(myTimer.get());
		}
		
		AllTurnTo(75);
		
		while(myTimer.get() > 10 && myTimer.get() < 15) {
			Robot.drivetrain.setautoSpeed(.25);
		}
		Robot.drivetrain.setautoSpeed(0);
		*/
		
		SwerveDrive.fix = false; 
		
		NWdegree = 315; 
		executorService.submit(this::NWSpin);
		NEdegree = 225; 
		executorService.submit(this::NESpin);
		SWdegree = 45; 
		executorService.submit(this::SWSpin);
		SEdegree = 135; 
		executorService.submit(this::SESpin); 
		
		double timer = myTimer.get(); 
		while(myTimer.get() < timer+5) {
			Robot.drivetrain.setautoSpeed(.25);
			
		}
		
		Robot.drivetrain.setautoSpeed(0);
		/*
		NWdegree = 0; 
		executorService.execute(this::SESpin);
		NEdegree = 0; 
		executorService.execute(this::NESpin);
		SWdegree = 0; 
		executorService.execute(this::SWSpin);
		SEdegree = 0; 
		executorService.execute(this::SESpin); 
		*/
		//executorService.shutdown();
		
		
		
		
			//Autonomous.Auto();
		
		
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
		gyro.reset();
		
	}
	

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		
	}

	@Override
	public void testPeriodic() {
	}

	
	static double totalDistance = 0; 
	static double distanceNW = 0;
	static double distanceNE = 0;
	static double distanceSW = 0;
	static double distanceSE = 0;
	static double errorNW = 0; 
	static double errorNE = 0; 
	static double errorSW = 0; 
	static double errorSE = 0; 
	public static void CorrectYourself() {


		distanceNW = Robot.encoderNW.getDistance();
		distanceNE = Robot.encoderNE.getDistance();
		distanceSW = Robot.encoderSW.getDistance();
		distanceSE = Robot.encoderSE.getDistance();
		

		SmartDashboard.putNumber("DistanceNW: ", distanceNW);
		SmartDashboard.putNumber("DistanceNE: ", distanceNE);
		SmartDashboard.putNumber("DistanceSW: ", distanceSW);
		SmartDashboard.putNumber("DistanceSE: ", distanceSE);
		totalDistance = (distanceNW+distanceNE+distanceSW+distanceSE)/4;

		if(Robot.oi.getLeftStickX(SwerveDrive.Player1) == 0 ) {
			errorNW = totalDistance - distanceNW;
			errorNE = totalDistance - distanceNE;
			errorSW = totalDistance - distanceSW;
			errorSE = totalDistance - distanceSE;
			if(Math.abs(errorNW) > Math.abs(errorNE)) {
				if(Math.abs(errorNW)>Math.abs(errorSW)) {
					if(Math.abs(errorNW)>Math.abs(errorSE)) {
						if(errorNW > .01) {if(errorNW > .2) {Robot.drivetrain.setlNW(.3);}else if(errorNW > .1) {Robot.drivetrain.setlNW(.25);} else if(errorNW > .05) {Robot.drivetrain.setlNW(.2);}else{Robot.drivetrain.setlNW(.15);}} 
						else if(errorNW < -.01){if(errorNW < -.2) {Robot.drivetrain.setlNW(-.3);}else if(errorNW < -.1) {Robot.drivetrain.setlNW(-.25);} else if(errorNW < -.05) {Robot.drivetrain.setlNW(-.2);}else{Robot.drivetrain.setlNW(-.15);}} 
					}
					else {
						if(errorSE > .01) {if(errorSE > .2) {Robot.drivetrain.setlSE(-.3);}else if(errorSE > .1) {Robot.drivetrain.setlSE(-.25);} else if(errorSE > .05) {Robot.drivetrain.setlSE(-.2);}else{Robot.drivetrain.setlSE(-.15);}}
						else if(errorSE < -.01) {if(errorSE < -.2) {Robot.drivetrain.setlSE(.3);}else if(errorSE < -.1) {Robot.drivetrain.setlSE(.25);} else if(errorSE < -.05) {Robot.drivetrain.setlSE(.2);}else{Robot.drivetrain.setlSE(.15);}} 
					}
				}
				else {
					if(Math.abs(errorSW)>Math.abs(errorSE)) {
						if(errorSW > .01 )  {if(errorSW > .2) {Robot.drivetrain.setlSW(-.3);}else if(errorSW > .1) {Robot.drivetrain.setlSW(-.25);} else if(errorSW > .05) {Robot.drivetrain.setlSW(-.2);}else{Robot.drivetrain.setlSW(-.15);}}
						else if(errorSW < -.01) {if(errorSW < -.2) {Robot.drivetrain.setlSW(.3);}else if(errorSW < -.1) {Robot.drivetrain.setlSW(.25);} else if(errorSW < -.05) {Robot.drivetrain.setlSW(.2);}else{Robot.drivetrain.setlSW(.15);}} 
					}
					else {
						if(errorSE > .01) {if(errorSE > .2) {Robot.drivetrain.setlSE(-.3);}else if(errorSE > .1) {Robot.drivetrain.setlSE(-.25);} else if(errorSE > .05) {Robot.drivetrain.setlSE(-.2);}else{Robot.drivetrain.setlSE(-.15);}}
						else if(errorSE < -.01) {if(errorSE < -.2) {Robot.drivetrain.setlSE(.3);}else if(errorSE < -.1) {Robot.drivetrain.setlSE(.25);} else if(errorSE < -.05) {Robot.drivetrain.setlSE(.2);}else{Robot.drivetrain.setlSE(.15);}} 
					}
				}
			}
			else {
				if(Math.abs(errorNE)>Math.abs(errorSW)) {
					if(Math.abs(errorNE)>Math.abs(errorSE)) {
						if(errorNE > .01)  {if(errorNE > .2) {Robot.drivetrain.setlNE(-.3);}else if(errorNE > .1) {Robot.drivetrain.setlNE(-.25);} else if(errorNE > .05) {Robot.drivetrain.setlNE(-.2);}else{Robot.drivetrain.setlNE(-.15);}}
						else if(errorNE < -.01) {if(errorNE < -.2) {Robot.drivetrain.setlNE(.3);}else if(errorNE < -.1) {Robot.drivetrain.setlNE(.25);} else if(errorNE < -.05) {Robot.drivetrain.setlNE(.2);}else{Robot.drivetrain.setlNE(.15);}} 
					}
					else {
						if(errorSE > .01) {if(errorSE > .2) {Robot.drivetrain.setlSE(-.3);}else if(errorSE > .1) {Robot.drivetrain.setlSE(-.25);} else if(errorSE > .05) {Robot.drivetrain.setlSE(-.2);}else{Robot.drivetrain.setlSE(-.15);}}
						else if(errorSE < -.01) {if(errorSE < -.2) {Robot.drivetrain.setlSE(.3);}else if(errorSE < -.1) {Robot.drivetrain.setlSE(.25);} else if(errorSE < -.05) {Robot.drivetrain.setlSE(.2);}else{Robot.drivetrain.setlSE(.15);}} 
					
					}
				}
				else {
					if(Math.abs(errorSW)>Math.abs(errorSE)) {
						if(errorSW > .01 )  {if(errorSW > .2) {Robot.drivetrain.setlSW(-.3);}else if(errorSW > .1) {Robot.drivetrain.setlSW(-.25);} else if(errorSW > .05) {Robot.drivetrain.setlSW(-.2);}else{Robot.drivetrain.setlSW(-.15);}}
						else if(errorSW < -.01) {if(errorSW < -.2) {Robot.drivetrain.setlSW(.3);}else if(errorSW < -.1) {Robot.drivetrain.setlSW(.25);} else if(errorSW < -.05) {Robot.drivetrain.setlSW(.2);}else{Robot.drivetrain.setlSW(.15);}} 
					}
					else {
						if(errorSE > .01) {if(errorSE > .2) {Robot.drivetrain.setlSE(-.3);}else if(errorSE > .1) {Robot.drivetrain.setlSE(-.25);} else if(errorSE > .05) {Robot.drivetrain.setlSE(-.2);}else{Robot.drivetrain.setlSE(-.15);}}
						else if(errorSE < -.01) {if(errorSE < -.2) {Robot.drivetrain.setlSE(.3);}else if(errorSE < -.1) {Robot.drivetrain.setlSE(.25);} else if(errorSE < -.05) {Robot.drivetrain.setlSE(.2);}else{Robot.drivetrain.setlSE(.15);}} 
					
					}
				}
			}
		}	
		
	}
	public static double NWAngle() {
		double angle = abeNW.get();
		while(angle > 360) { angle -= 360; }
		while(angle < 0)   { angle += 360; }
		return angle; 
	}
	public static double NEAngle() {
		double angle = abeNE.get();
		while(angle > 360) { angle -= 360; }
		while(angle < 0)   { angle += 360; }
		return angle; 
	}
	public static double SWAngle() {
		double angle = abeSW.get();
		while(angle > 360) { angle -= 360; }
		while(angle < 0)   { angle += 360; }
		return angle; 
	}
	public static double SEAngle() {
		double angle = abeSE.get();
		while(angle > 360) { angle -= 360; }
		while(angle < 0)   { angle += 360; }
		return angle; 
	}
	
	static double angleNW; 
	static double angleNE; 
	static double angleSW; 
	static double angleSE; 
	static double averageCos;
	static double averageAngle; 
	public static void AbsolutelyCorrectYourself() {

		angleNW = NWAngle();
		angleNE = NEAngle();
		angleSW = SWAngle();
		angleSE = SEAngle();
		
		SmartDashboard.putNumber("abeNW: ", Robot.NWAngle());
		SmartDashboard.putNumber("abeNE: ", Robot.NEAngle());
		SmartDashboard.putNumber("abeSW: ", Robot.SWAngle());
		SmartDashboard.putNumber("abeSE: ", Robot.SEAngle());
		
		
		averageCos = (Math.cos(Math.toRadians(angleNW))+Math.cos(Math.toRadians(angleNE))+
				Math.cos(Math.toRadians(angleSW))+Math.cos(Math.toRadians(angleSE)))/4;
		
		averageAngle = Math.acos(averageCos);

		if(Robot.oi.getLeftStickX(SwerveDrive.Player1) == 0 ) {
			errorNW = averageCos - Math.cos(Math.toRadians(angleNW));
			errorNE = averageCos - Math.cos(Math.toRadians(angleNE));
			errorSW = averageCos - Math.cos(Math.toRadians(angleSW));
			errorSE = averageCos - Math.cos(Math.toRadians(angleSE));
			if(Math.abs(errorNW) > Math.abs(errorNE)) {
				if(Math.abs(errorNW)>Math.abs(errorSW)) {
					if(Math.abs(errorNW)>Math.abs(errorSE)) {
						if(errorNW > .01) {Robot.drivetrain.setlNW(.15);} else if(errorNW < -.01){Robot.drivetrain.setlNW(-.15);} 
					}
					else {
						if(errorSE > .01) {Robot.drivetrain.setlSE(-.15);} else if(errorSE < -.01) {Robot.drivetrain.setlSE(.15);}
					}
				}
				else {
					if(Math.abs(errorSW)>Math.abs(errorSE)) {
						if(errorSW > .01 ) {Robot.drivetrain.setlSW(-.15);} else if(errorSW < -.01) {Robot.drivetrain.setlSW(.15);}
					}
					else {
						if(errorSE > .01) {Robot.drivetrain.setlSE(-.15);} else if(errorSE < -.01){Robot.drivetrain.setlSE(.15);}
					}
				}
			}
			else {
				if(Math.abs(errorNE)>Math.abs(errorSW)) {
					if(Math.abs(errorNE)>Math.abs(errorSE)) {
						if(errorNE > .01) {Robot.drivetrain.setlNE(-.15);} else if(errorNE < -.01) {Robot.drivetrain.setlNE(.15);}
					}
					else {
						if(errorSE > .01) {Robot.drivetrain.setlSE(-.15);} else if(errorSE < -.01) {Robot.drivetrain.setlSE(.15);}
					}
				}
				else {
					if(Math.abs(errorSW)>Math.abs(errorSE)) {
						if(errorSW > .01 ) {Robot.drivetrain.setlSW(-.15);} else if(errorSW < -.01) {Robot.drivetrain.setlSW(.15);}
					}
					else {
						if(errorSE > .01) {Robot.drivetrain.setlSE(-.15);} else if(errorSE < -.01) {Robot.drivetrain.setlSE(.15);}
					}
				}
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
	
	public static void AllTurnTo(double degrees) {

		NWTurnTo(degrees); 
		NETurnTo(degrees);
		SWTurnTo(degrees);
		SETurnTo(degrees);
	}
	
	public static int NWTurnTo(double degrees){
		if(degrees != -1) {
		double Phi = NWAngle(); 
		if(Math.sin(Math.toRadians(degrees - Phi)) < 0) {
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeNW: ", NWAngle());
				Robot.drivetrain.setlNW(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = NWAngle();
			} 
			while(Math.sin(Math.toRadians(degrees-Phi)) > 0) {
				SmartDashboard.putNumber("abeNW: ", NWAngle());
				Robot.drivetrain.setlNW(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = NWAngle();
			} 
			Robot.drivetrain.setlNW(0);
		}else {
			while(Math.sin(Math.toRadians(degrees-Phi)) >= 0) {
				SmartDashboard.putNumber("abeNW: ", NWAngle());
				Robot.drivetrain.setlNW(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = NWAngle(); 
			}
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeNW: ", NWAngle());
				Robot.drivetrain.setlNW(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = NWAngle(); 
			}
			Robot.drivetrain.setlNW(0);
		}
		}
		return 0; 
	}
	public static int NETurnTo(double degrees){
		if(degrees != -1) {
		double Phi = NEAngle(); 
		if(Math.sin(Math.toRadians(degrees - Phi)) < 0) {
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeNE: ", NEAngle());
				Robot.drivetrain.setlNE(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = NEAngle();
			} 
			while(Math.sin(Math.toRadians(degrees-Phi)) > 0) {
				SmartDashboard.putNumber("abeNE: ", NEAngle());
				Robot.drivetrain.setlNE(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = NEAngle();
			} 
			Robot.drivetrain.setlNE(0);
		}else {
			while(Math.sin(Math.toRadians(degrees-Phi)) >= 0) {
				SmartDashboard.putNumber("abeNE: ", NEAngle());
				Robot.drivetrain.setlNE(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = NEAngle(); 
			}
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeNE: ", NEAngle());
				Robot.drivetrain.setlNE(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = NEAngle(); 
			}
			Robot.drivetrain.setlNE(0);
		}
		}
		return 0; 
	}
	public static int SWTurnTo(double degrees){
		if(degrees != -1) {
		double Phi = SWAngle(); 
		if(Math.sin(Math.toRadians(degrees - Phi)) < 0) {
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeSW: ", SWAngle());
				Robot.drivetrain.setlSW(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = SWAngle();
			} 
			while(Math.sin(Math.toRadians(degrees-Phi)) > 0) {
				SmartDashboard.putNumber("abeSW: ", SWAngle());
				Robot.drivetrain.setlSW(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = SWAngle();
			} 
			Robot.drivetrain.setlSW(0);
		}else {
			while(Math.sin(Math.toRadians(degrees-Phi)) >= 0) {
				SmartDashboard.putNumber("abeSW: ", SWAngle());
				Robot.drivetrain.setlSW(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = SWAngle(); 
			}
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeSW: ", SWAngle());
				Robot.drivetrain.setlSW(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = SWAngle(); 
			}
			Robot.drivetrain.setlSW(0);
		}
		}
		return 0; 
	}

	public static int SETurnTo(double degrees){
		if(degrees != -1) {
		double Phi = SEAngle(); 
		if(Math.sin(Math.toRadians(degrees - Phi)) < 0) {
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeSE: ", SEAngle());
				Robot.drivetrain.setlSE(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = SEAngle();
			} 
			while(Math.sin(Math.toRadians(degrees-Phi)) > 0) {
				SmartDashboard.putNumber("abeSE: ", SEAngle());
				Robot.drivetrain.setlSE(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = SEAngle();
			} 
			Robot.drivetrain.setlSE(0);
		}else {
			while(Math.sin(Math.toRadians(degrees-Phi)) >= 0) {
				SmartDashboard.putNumber("abeSE: ", SEAngle());
				Robot.drivetrain.setlSE(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = SEAngle(); 
			}
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeSE: ", SEAngle());
				Robot.drivetrain.setlSE(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = SEAngle(); 
			}
			Robot.drivetrain.setlSE(0);
		}
		}
		return 0; 
	}

	public int NWSpin() {
		double degrees = NWdegree; 
		double Phi = Robot.NWAngle(); 
		if(Math.sin(Math.toRadians(degrees - Phi)) < 0) {
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeNW: ", Robot.NWAngle());
				Robot.drivetrain.setlNW(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.NWAngle();
			} 
			while(Math.sin(Math.toRadians(degrees-Phi)) > 0) {
				SmartDashboard.putNumber("abeNW: ", Robot.NWAngle());
				Robot.drivetrain.setlNW(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.NWAngle();
			} 
			Robot.drivetrain.setlNW(0);
		}else {
			while(Math.sin(Math.toRadians(degrees-Phi)) >= 0) {
				SmartDashboard.putNumber("abeNW: ", Robot.NWAngle());
				Robot.drivetrain.setlNW(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.NWAngle(); 
			}
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeNW: ", Robot.NWAngle());
				Robot.drivetrain.setlNW(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.NWAngle(); 
			}
			Robot.drivetrain.setlNW(0);
		}
		
		
		return 0; 
	}

	public int NESpin(){
		double degrees = NEdegree; 
		double Phi = Robot.NEAngle(); 
		if(Math.sin(Math.toRadians(degrees - Phi)) < 0) {
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeNE: ", Robot.NEAngle());
				Robot.drivetrain.setlNE(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.NEAngle();
			} 
			while(Math.sin(Math.toRadians(degrees-Phi)) > 0) {
				SmartDashboard.putNumber("abeNE: ", Robot.NEAngle());
				Robot.drivetrain.setlNE(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.NEAngle();
			} 
			Robot.drivetrain.setlNE(0);
		}else {
			while(Math.sin(Math.toRadians(degrees-Phi)) >= 0) {
				SmartDashboard.putNumber("abeNE: ", Robot.NEAngle());
				Robot.drivetrain.setlNE(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.NEAngle(); 
			}
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeNE: ", Robot.NEAngle());
				Robot.drivetrain.setlNE(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.NEAngle(); 
			}
			Robot.drivetrain.setlNE(0);
		}
		
		return 0;
		
	}
	

	public int SWSpin(){
		double degrees = SWdegree; 
		double Phi = Robot.SWAngle(); 
		if(Math.sin(Math.toRadians(degrees - Phi)) < 0) {
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeSW: ", Robot.SWAngle());
				Robot.drivetrain.setlSW(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.SWAngle();
			} 
			while(Math.sin(Math.toRadians(degrees-Phi)) > 0) {
				SmartDashboard.putNumber("abeSW: ", Robot.SWAngle());
				Robot.drivetrain.setlSW(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.SWAngle();
			} 
			Robot.drivetrain.setlSW(0);
		}else {
			while(Math.sin(Math.toRadians(degrees-Phi)) >= 0) {
				SmartDashboard.putNumber("abeSW: ", Robot.SWAngle());
				Robot.drivetrain.setlSW(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.SWAngle(); 
			}
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeSW: ", Robot.SWAngle());
				Robot.drivetrain.setlSW(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.SWAngle(); 
			}
			Robot.drivetrain.setlSW(0);
		}
		
		return 0; 
	}

	public int SESpin(){
		double degrees = SEdegree; 
		double Phi = Robot.SEAngle(); 
		if(Math.sin(Math.toRadians(degrees - Phi)) < 0) {
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeSE: ", Robot.SEAngle());
				Robot.drivetrain.setlSE(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.SEAngle();
			} 
			while(Math.sin(Math.toRadians(degrees-Phi)) > 0) {
				SmartDashboard.putNumber("abeSE: ", Robot.SEAngle());
				Robot.drivetrain.setlSE(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.SEAngle();
			} 
			Robot.drivetrain.setlSE(0);
		}else {
			while(Math.sin(Math.toRadians(degrees-Phi)) >= 0) {
				SmartDashboard.putNumber("abeSE: ", Robot.SEAngle());
				Robot.drivetrain.setlSE(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.SEAngle(); 
			}
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeSE: ", Robot.SEAngle());
				Robot.drivetrain.setlSE(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.SEAngle(); 
			}
			Robot.drivetrain.setlSE(0);
		}
		
		
		return 0; 
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
	
	public static void ShootBox() {
		double time = myTimer.get() + .15;
		while(myTimer.get() < time) { Robot.drivetrain.setPunchers(DoubleSolenoid.Value.kReverse); }
		while(myTimer.get() < time + .1) { Robot.drivetrain.setRawGrabber(DoubleSolenoid.Value.kForward); }
	}
	*/
	
}