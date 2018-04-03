package org.usfirst.frc.team7327.robot.commands;

import org.usfirst.frc.team7327.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {


	public TankDrive() {
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute(){
		//throttle speed from 1 to 0 based on desired speed
		double throttleL = .6;
		double throttleR = .6;
		double throttleW = .4;
		double throttleA = .4; 
		
		Robot.drivetrain.setRaw(Robot.oi.getLeftStickY (Robot.oi.Controller1)* throttleL, Robot.oi.getRightStickY(Robot.oi.Controller1)* throttleR,
								Robot.oi.getRightStickY(Robot.oi.Controller2)* throttleW, Robot.oi.getLeftStickY (Robot.oi.Controller2)* throttleA);
		System.out.println(Robot.oi.getLeftTrigger(Robot.oi.Controller1));
		
				
	}
	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
