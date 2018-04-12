/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7327.robot;


public enum RobotMap {
	//PWM Motor Mapping	
	LEFT_MOTOR(0),
	LEFT_MOTOR1(1),
	RIGHT_MOTOR(2),
	RIGHT_MOTOR1(3),
	WHEEL_MOTOR(4),
	ARM_MOTOR(5),
	SpinnerLeft_MOTOR(6),
	SpinnerRight_MOTOR(7),
	//Control Mapping
	XBOX_CONTROLLER(0),
	XBOX_CONTROLLER1(1);
	
	public final int value;
	
	RobotMap(int value){
		this.value = value;
	}
}
