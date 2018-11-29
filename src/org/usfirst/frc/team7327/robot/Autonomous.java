package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		
		Robot.MoveForwardFeet(5);
		Robot.MoveForward();
		Robot.TurnRight();
		Robot.TurnLeft();
		
	}
}		