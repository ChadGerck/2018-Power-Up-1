/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.commands.SwerveDrive;
import org.usfirst.frc.team7327.robot.subsystems.DriveTrain;
import org.usfirst.frc.team7327.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.command.Scheduler;

import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

import edu.wpi.first.wpilibj.I2C; 

public class Robot extends TimedRobot { 
	public static OI oi;
	public static DriveTrain drivetrain;
	public static SwerveDrive swervedrive; 
	//CameraServer Camera;
	
	public static ADXRS450_Gyro gyro; 
	
	public static Vision vision; 
	
	public static double NWdegree, NEdegree, SWdegree, SEdegree = 0;
	
	public static Timer myTimer = new Timer();
	public static boolean done = true; 
	
	public static I2C arduino; 
	
	@Override
	public void robotInit() {
		myTimer.reset();
		myTimer.start();
		
		gyro = new ADXRS450_Gyro(Port.kOnboardCS0);
				
		oi = new OI();
		drivetrain = new DriveTrain();
		//Camera = CameraServer.getInstance();
		//Camera.startAutomaticCapture();
		//Camera.getVideo();
		
		gyro.calibrate();
		
		arduino = new I2C(I2C.Port.kOnboard, 0x54);
		
		vision = new Vision();
		
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
		
	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		gyro.reset();
		
	}
	

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
	
	static void UpdateLEDs(String WriteString) // Constructor, pass it a string argument.
	{
		char[] CharArray = WriteString.toCharArray();  //Create an array of characters.  This breaks up the information into something that can be passed over the I2C bus.
		byte[] RobotStatus = new byte[CharArray.length]; //Characters cannot be passed over I2C, thus we must convert them to bytes. This line creates the byte array.  
		for (int i = 0; i < CharArray.length; i++)//Create a loop that fills the new  byte array. The new byte array is the same size as the character array. 
		{
			RobotStatus[i] = (byte) CharArray[i];  //Pass information slot by slot. This also converts the characters into bytes.
		}
		
		//arduino.transaction(RobotStatus, RobotStatus.length, null, 0);  //One type of sending info over the I2C bus.  This method asks for a response from the receiving unit. Caused null point exceptions. 
		arduino.writeBulk(RobotStatus, RobotStatus.length); //This method sends info one way, without demanding a response from reader unit. 
		
	}
	
	public static void ReadData()
	{
		byte[] f = new byte[16];
		 arduino.readOnly(f, f.length);
		 for( int i = 0; i < f.length; i++ ) {
			System.out.print(f[i]+", ");
		 }
		 System.out.println("");
	}
	
	public static void AddressWorking()
	{
		System.out.println(arduino.addressOnly()); 
	}
	
	public static double GyroAngle() {
		double angle = Robot.gyro.getAngle();
		while(angle > 360) angle -= 360; 
		while(angle < 0)   angle += 360;
		return angle; 
	}
	
	public static double GyroAngle(double add) {
		double angle = Robot.gyro.getAngle() + add;
		while(angle > 360)  angle -= 360; 
		while(angle < 0)    angle += 360; 
		return angle; 
	}
	
}