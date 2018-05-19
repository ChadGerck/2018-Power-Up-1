package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		Robot.MoveForward(10);
		Robot.TurnTo(90); 
		Robot.MoveForward(8);
	}
}
