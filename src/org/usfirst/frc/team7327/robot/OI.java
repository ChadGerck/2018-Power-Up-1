/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7327.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
public class OI {
	
	// new code 1/29
	 public static final double LEFT_DEADZONE_LIMIT = 0.2;
	 public static final double RIGHT_DEADZONE_LIMIT = 0.2;
	
	public final XboxController Controller0 = new XboxController(RobotMap.XBOX_CONTROLLER0.value);
	public final XboxController Controller1 = new XboxController(RobotMap.XBOX_CONTROLLER1.value);
	
	public double getLeftStickX(XboxController Controller) {
		double raw = Controller.getRawAxis(0);
		return Math.abs(raw) < LEFT_DEADZONE_LIMIT ? 0.0 : raw;
	}
	public double getLeftStickY(XboxController Controller) {
		double raw = Controller.getRawAxis(1);
		return Math.abs(raw) < LEFT_DEADZONE_LIMIT ? 0.0 : raw;
	}
	
	public double getRightStickX(XboxController Controller) {
		double raw = Controller.getRawAxis(4);
		return Math.abs(raw) < RIGHT_DEADZONE_LIMIT ? 0.0 : raw;
	}
	public double getRightStickY(XboxController Controller) {
		double raw = Controller.getRawAxis(5);
		return Math.abs(raw) < RIGHT_DEADZONE_LIMIT ? 0.0 : raw;
	}

	public double getLeftTrigger(XboxController Controller) {
		double raw = Controller.getRawAxis(2);
		return Math.abs(raw) < RIGHT_DEADZONE_LIMIT ? 0.0 : raw;
	}
	public double getRightTrigger(XboxController Controller) {
		double raw = Controller.getRawAxis(3);
		return Math.abs(raw) < RIGHT_DEADZONE_LIMIT ? 0.0 : raw;
	}
	public boolean getLeftBumper(XboxController Controller) {
		boolean raw = Controller.getBumperPressed(Hand.kLeft);
		return raw;
	}
	public boolean getRightBumper(XboxController Controller) {
		boolean raw = Controller.getBumperPressed(Hand.kRight);
		return raw;
	}
	public boolean getXButton(XboxController Controller) {
		boolean raw = Controller.getXButtonPressed();
		return raw;
	}
	public boolean getYButton(XboxController Controller) {
		boolean raw = Controller.getYButtonPressed();
		return raw;
	}

	public boolean getAButton(XboxController Controller) {
		boolean raw = Controller.getAButtonPressed();
		return raw;
	}

	public boolean getBButton(XboxController Controller) {
		boolean raw = Controller.getBButtonPressed();
		return raw;
	}
	
	public double Dpad(XboxController Controller) {
		double raw = Controller.getPOV();
		return raw;
	}
	
	public boolean getSlowButton(XboxController Controller) {
		boolean raw = Controller.getRawButtonPressed(7);
		return raw; 
	}
	
	public boolean getStartButton(XboxController Controller) {
		boolean raw = Controller.getStartButtonPressed();
		return raw; 
	}
	
	public OI () {
		
	}
}                                                                  