package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		switch(Robot.station){
		case 1:
			Robot.MoveForward();
			TurnAround();
			Robot.MoveForward();
			TurnAround();
			break;
		case 2:
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			break;
		case 3:
			TurnAround();
			TurnAround();
			TurnAround();
			TurnAround();
			TurnAround();
			TurnAround();
			break;
		}
	}
	public static void TurnAround() {
		Robot.TurnRight();
		Robot.TurnRight();
	}
}