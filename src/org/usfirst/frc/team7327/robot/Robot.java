/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7327.robot;

import java.io.IOException;

import org.usfirst.frc.team7327.robot.subsystems.DriveTrain;
//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
//import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import java.util.Timer;
import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.Solenoid;

public class Robot extends TimedRobot {
	public static OI oi;
	public static DriveTrain drivetrain;
	CameraServer Camera;
	
	//Compressor c = new Compressor(0);
	
	private DriverStation.Alliance color = DriverStation.getInstance().getAlliance();
	private int station = DriverStation.getInstance().getLocation();
	private String gameData = DriverStation.getInstance().getGameSpecificMessage();
	private char SwitchSide = gameData.charAt(0);
	private char ScaleSide = gameData.charAt(1);
	
	//Change based on alliance
	private char RobotLocation = 'L';
	

	
	Timer myTimer = new Timer();
	

	@Override
	public void robotInit() {
		oi = new OI();
		drivetrain = new DriveTrain();
		Camera = CameraServer.getInstance();
				Camera.startAutomaticCapture();
				Camera.getVideo();
		
		//c.setClosedLoopControl(false);
		
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
		
		
		
		//DoubleSolenoid.Value FlapOff = DoubleSolenoid.Value.kOff;
		

		/*
		if(color == DriverStation.Alliance.Blue || color == DriverStation.Alliance.Red) {
			switch(station) {
			case 1:
				if(gameData.length() > 1)
				{
					if(gameData.charAt(0) == 'L')
					{
						//Goes forward and pushes cube on switch
						while(isAutonomous() && elapsedSeconds < 7.3) {

							elapsedTime = System.currentTimeMillis() - startTime;
							elapsedSeconds = elapsedTime /1000;
							if(elapsedSeconds < 1.2) {drivetrain.setRaw(0,0,0,-.35,FlapOff,0);}
							if(elapsedSeconds >= 1.2 && elapsedSeconds < 5) {drivetrain.setRaw(-.35,-.353,0,0,FlapOff,0);}
							if(elapsedSeconds >= 5 && elapsedSeconds < 6) {drivetrain.setRaw(-.3,.3,0,0,FlapOff,0);}
							if(elapsedSeconds >= 6 && elapsedSeconds < 7) {drivetrain.setRaw(0,0,0,-.35,FlapOff,0);}
							if(elapsedSeconds >= 7 && elapsedSeconds < 7.3) {drivetrain.setRaw(0,0,.5,0,FlapOff,0);}
						
						}
					} else if(gameData.charAt(1) == 'L') {
						while(isAutonomous() && elapsedSeconds < 13.3) {

							elapsedTime = System.currentTimeMillis() - startTime;
							elapsedSeconds = elapsedTime /1000;
							
							if(elapsedSeconds < 1.2) {drivetrain.setRaw(0,0,0,-.35,FlapOff,0);}
							if(elapsedSeconds >= 1.2 && elapsedSeconds < 8) {drivetrain.setRaw(-.35,-.353,0,0,FlapOff,0);}
							if(elapsedSeconds >= 8 && elapsedSeconds < 9) {drivetrain.setRaw(.3,-.3,0,0,FlapOff,0);}
							if(elapsedSeconds >= 9 && elapsedSeconds < 11) {drivetrain.setRaw(0,0,0,-.5,FlapOff,0);}
							if(elapsedSeconds >= 11 && elapsedSeconds < 13) {drivetrain.setRaw(0,0,0,-.3,FlapOff,0);}
							if(elapsedSeconds >= 13 && elapsedSeconds < 13.3) {drivetrain.setRaw(0,0,.5,0,FlapOff,0);}
						
						}
					} else {
						while(isAutonomous() && elapsedSeconds < 5) {
							
							elapsedTime = System.currentTimeMillis() - startTime;
							elapsedSeconds = elapsedTime /1000;
							if(elapsedSeconds < 1.2) {drivetrain.setRaw(0,0,0,-.35,FlapOff,0);}
							if(elapsedSeconds >= 1.2 && elapsedSeconds < 5) {drivetrain.setRaw(-.35,-.353,0,0,FlapOff,0);}
						}
						
						}
						
				}
				break;
			case 2:
				if(gameData.length() > 1)
				{
					if(gameData.charAt(0) == 'R')
					{
				
						while(isAutonomous() && elapsedSeconds < 10.3) {
							elapsedTime = System.currentTimeMillis() - startTime;
							elapsedSeconds = elapsedTime /1000;
							
							if(elapsedSeconds < 1.2) {drivetrain.setRaw(0,0,0,-.35,FlapOff,0);}
							if(elapsedSeconds >= 1.2 && elapsedSeconds < 4) {drivetrain.setRaw(-.35,-.353,0,0,FlapOff,0);}
							if(elapsedSeconds >= 4 && elapsedSeconds < 5) {drivetrain.setRaw(-.3,.4,0,0,FlapOff,0);}
							if(elapsedSeconds >= 5 && elapsedSeconds < 7) {drivetrain.setRaw(-.35,-.353,0,0,FlapOff,0);}
							if(elapsedSeconds >= 7 && elapsedSeconds < 8) {drivetrain.setRaw(.3,-.3,0,0,FlapOff,0);}
							if(elapsedSeconds >= 8 && elapsedSeconds < 9) {drivetrain.setRaw(-.35,-.353,0,0,FlapOff,0);}
							if(elapsedSeconds >= 9 && elapsedSeconds < 10) {drivetrain.setRaw(0,0,0,-.35,FlapOff,0);}
							if(elapsedSeconds >= 10 && elapsedSeconds < 10.3) {drivetrain.setRaw(0,0,.5,0,FlapOff,0);}
							
						}
					} else if(gameData.charAt(0) == 'L'){
						while(isAutonomous() && elapsedSeconds < 10.3) {
							elapsedTime = System.currentTimeMillis() - startTime;
							elapsedSeconds = elapsedTime /1000;
							
							if(elapsedSeconds < 1.2) {drivetrain.setRaw(0,0,0,-.35,FlapOff,0);}
							if(elapsedSeconds >= 1.2 && elapsedSeconds < 4) {drivetrain.setRaw(-.35,-.353,0,0,FlapOff,0);}
							if(elapsedSeconds >= 4 && elapsedSeconds < 5) {drivetrain.setRaw(.3,-.4,0,0,FlapOff,0);}
							if(elapsedSeconds >= 5 && elapsedSeconds < 7) {drivetrain.setRaw(-.35,-.353,0,0,FlapOff,0);}
							if(elapsedSeconds >= 7 && elapsedSeconds < 8) {drivetrain.setRaw(-.3,.3,0,0,FlapOff,0);}
							if(elapsedSeconds >= 8 && elapsedSeconds < 9) {drivetrain.setRaw(-.35,-.353,0,0,FlapOff,0);}
							if(elapsedSeconds >= 9 && elapsedSeconds < 10) {drivetrain.setRaw(0,0,0,-.35,FlapOff,0);}
							if(elapsedSeconds >= 10 && elapsedSeconds < 10.3) {drivetrain.setRaw(0,0,.5,0,FlapOff,0);}
							
						}
					}
				}
				break;
			case 3: 
				if(gameData.length() > 1)
				{
					if(gameData.charAt(0) == 'R')
					{
						//Goes forward and pushes cube on switch
						while(isAutonomous() && elapsedSeconds < 7.3) {

							elapsedTime = System.currentTimeMillis() - startTime;
							elapsedSeconds = elapsedTime /1000;
							if(elapsedSeconds < 1.2) {drivetrain.setRaw(0,0,0,-.35,FlapOff,0);}
							if(elapsedSeconds >= 1.2 && elapsedSeconds < 5) {drivetrain.setRaw(-.35,-.353,0,0,FlapOff,0);}
							if(elapsedSeconds >= 5 && elapsedSeconds < 6) {drivetrain.setRaw(.3,-.3,0,0,FlapOff,0);}
							if(elapsedSeconds >= 6 && elapsedSeconds < 7) {drivetrain.setRaw(0,0,0,-.35,FlapOff,0);}
							if(elapsedSeconds >= 7 && elapsedSeconds < 7.3) {drivetrain.setRaw(0,0,.5,0,FlapOff,0);}
						
						}
					} else if(gameData.charAt(1) == 'R') {
						while(isAutonomous() && elapsedSeconds < 13.3) {

							elapsedTime = System.currentTimeMillis() - startTime;
							elapsedSeconds = elapsedTime /1000;
							
							if(elapsedSeconds < 1.2) {drivetrain.setRaw(0,0,0,-.35,FlapOff,0);}
							if(elapsedSeconds >= 1.2 && elapsedSeconds < 8) {drivetrain.setRaw(-.35,-.353,0,0,FlapOff,0);}
							if(elapsedSeconds >= 8 && elapsedSeconds < 9) {drivetrain.setRaw(-.3,.3,0,0,FlapOff,0);}
							if(elapsedSeconds >= 9 && elapsedSeconds < 11) {drivetrain.setRaw(0,0,0,-.5,FlapOff,0);}
							if(elapsedSeconds >= 11 && elapsedSeconds < 13) {drivetrain.setRaw(0,0,0,-.3,FlapOff,0);}
							if(elapsedSeconds >= 13 && elapsedSeconds < 13.3) {drivetrain.setRaw(0,0,.5,0,FlapOff,0);}
						
						}
					} else {
						while(isAutonomous() && elapsedSeconds < 5) {
							
							elapsedTime = System.currentTimeMillis() - startTime;
							elapsedSeconds = elapsedTime /1000;
							if(elapsedSeconds < 1.2) {drivetrain.setRaw(0,0,0,-.35,FlapOff,0);}
							if(elapsedSeconds >= 1.2 && elapsedSeconds < 5) {drivetrain.setRaw(-.35,-.353,0,0,FlapOff,0);}
						}
						
					}
				}
				break;
				
			}
			
		}
		*/
		//Attempting to simplify the code
		switch(station)
		{
		case 1:
			if(RobotLocation == 'L') { BackwardsPrioritizeScale(); }
			else if(RobotLocation == 'M') { MiddlePrioritizeSwitch(); }
			else if(RobotLocation == 'R') { BackwardsPrioritizeScale(); }
			break;
		case 2:
			if(RobotLocation == 'L') { BackwardsPrioritizeScalev2(); }
			else if(RobotLocation == 'M') { MiddlePrioritizeSwitch();  }
			else if(RobotLocation == 'R') { BackwardsPrioritizeScale(); }
			break;
		case 3: 
			if(RobotLocation == 'L') { BackwardsPrioritizeScale(); }
			else if(RobotLocation == 'M') { MiddlePrioritizeSwitch(); }
			else if(RobotLocation == 'R') { BackwardsPrioritizeScale(); }
			break;
		}
		
		 
		
		drivetrain.setRaw(0, 0, 0, 0,0);
		
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
		}
	

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	

	@Override
	public void testPeriodic() {
	}
	
	public void ForwardPrioritizeScale() {
		BeginLift();
	}
	
	public void BackwardsPrioritizeScale() {
		if(RobotLocation == ScaleSide) {
			double x = .35;
			double y = .36; 
			double arm1 = -.6;
			double arm2 = -.3; 
			double shoot = .5; 
			while(isAutonomous() && myTimer.get() < 10.3) {
				if(myTimer.get() < 6) {drivetrain.setRaw(x, y, 0, 0, 0);}	
				if(myTimer.get() >= 6 && myTimer.get() < 8)  {drivetrain.setRaw(0,0,0,arm1,0);}
				if(myTimer.get() >= 8 && myTimer.get() < 10) {drivetrain.setRaw(0,0,0,arm2,0);}
				if(myTimer.get() >= 10 && myTimer.get() < 10.3){drivetrain.setRaw(0,0,shoot,0,0);}
			}	
		}
		else {
			while(isAutonomous() && myTimer.get() < 5) {
				if(myTimer.get() < 4.0) {drivetrain.setRaw(.5, .5, 0, 0, 0);}
				if(myTimer.get() >= 4 && myTimer.get() < 5)  {drivetrain.setRaw(-.3,.4,0,0,0);}
			}
		}
		drivetrain.setRaw(0, 0, 0, 0, 0);
	}
	public void BackwardsPrioritizeScalev2() {
		if(RobotLocation == ScaleSide) {
			double x = .35;
			double y = .36; 
			double arm1 = -.6;
			double arm2 = -.3; 
			double shoot = .5; 
			
			MoveForward(x, y, 6); 
			MoveArm(arm1, 2);
			MoveForward(x, 0, 2);
			
		}
		else {
			while(isAutonomous() && myTimer.get() < 5) {
				if(myTimer.get() < 4.0) {drivetrain.setRaw(.5, .5, 0, 0, 0);}
				if(myTimer.get() >= 4 && myTimer.get() < 5)  {drivetrain.setRaw(-.3,.4,0,0,0);}
			}
		}
		drivetrain.setRaw(0, 0, 0, 0, 0);
	}
	public void ResetBackwardsTest() {
		if(RobotLocation == ScaleSide) {
			
		}
	}
	
	public void MiddlePrioritizeSwitch() {
		if(gameData.charAt(0) == 'R')
		{
	
			while(isAutonomous() && myTimer.get() < 10.3) {
				
				if(myTimer.get() < 1.2) {drivetrain.setRaw(0,0,0,-.35,0);}
				if(myTimer.get() >= 1.2 && myTimer.get() < 4) {drivetrain.setRaw(-.35,-.353,0,0,0);}
				if(myTimer.get() >= 4 && myTimer.get() < 5) {drivetrain.setRaw(-.3,.4,0,0,0);}
				if(myTimer.get() >= 5 && myTimer.get() < 7) {drivetrain.setRaw(-.35,-.353,0,0,0);}
				if(myTimer.get() >= 7 && myTimer.get() < 8) {drivetrain.setRaw(.3,-.3,0,0,0);}
				if(myTimer.get() >= 8 && myTimer.get() < 9) {drivetrain.setRaw(-.35,-.353,0,0,0);}
				if(myTimer.get() >= 9 && myTimer.get() < 10) {drivetrain.setRaw(0,0,0,-.35,0);}
				if(myTimer.get() >= 10 && myTimer.get() < 10.3) {drivetrain.setRaw(0,0,.5,0,0);}
				
			}
		} else if(gameData.charAt(0) == 'L'){
			while(isAutonomous() && myTimer.get() < 10.3) {
				if(myTimer.get() < 1.2) {drivetrain.setRaw(0,0,0,-.35,0);}
				if(myTimer.get() >= 1.2 && myTimer.get() < 4) {drivetrain.setRaw(-.35,-.353,0,0,0);}
				if(myTimer.get() >= 4 && myTimer.get() < 5) {drivetrain.setRaw(.3,-.4,0,0,0);}
				if(myTimer.get() >= 5 && myTimer.get() < 7) {drivetrain.setRaw(-.35,-.353,0,0,0);}
				if(myTimer.get() >= 7 && myTimer.get() < 8) {drivetrain.setRaw(-.3,.3,0,0,0);}
				if(myTimer.get() >= 8 && myTimer.get() < 9) {drivetrain.setRaw(-.35,-.353,0,0,0);}
				if(myTimer.get() >= 9 && myTimer.get() < 10) {drivetrain.setRaw(0,0,0,-.35,0);}
				if(myTimer.get() >= 10 && myTimer.get() < 10.3) {drivetrain.setRaw(0,0,.5,0,0);}
				
			}
		}
	}
	
	public void BeginLift() {
		while(isAutonomous()) {
			if(myTimer.get() < 1.2) {drivetrain.setRaw(0,0,0,-.3,0);}
		}
	}
	
	public void MoveForward(double x, double y, double time) {
		time = myTimer.get() + time; 
		while(isAutonomous() && myTimer.get() < time) {
			drivetrain.setRaw(x, y, 0, 0, 0);
		}
		drivetrain.setRaw(0, 0, 0, 0, 0);
	}
	
	public void MoveArm(double arm, double time) {
		time = myTimer.get() + time; 
		while(isAutonomous() && myTimer.get() < time) {
			drivetrain.setRaw(0, 0, 0, arm, 0);
		}
		drivetrain.setRaw(0, 0, 0, 0, 0);
		
	}
	
}