package org.usfirst.frc.team7327.robot.commands;

import org.usfirst.frc.team7327.robot.Robot;


//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;

public class TankDrive extends Command {

    
	public TankDrive() {
		requires(Robot.drivetrain); 
	}
	XboxController Player1 = Robot.oi.Controller0; 
	double throttleL = .25; 
	
	protected void initialize() {
	}
	protected void execute(){
		
		Robot.drivetrain.setRaw1(Robot.oi.getLeftStickY(Player1)+(Robot.oi.getRightStickX(Player1))*throttleL, Robot.oi.getLeftStickY(Player1)-Robot.oi.getRightStickX(Player1)*throttleL);
		
		Robot.drivetrain.setRawArm(0);
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		
		if (Robot.oi.getAButton(Player1)) {
			double timer = Robot.myTimer.get();
			// Robot.drivetrain.setRaw1(.25, .25);

			if (timer < 1) {
				Robot.drivetrain.setRaw1(.1, .1);
			} else if (timer < 2) {
				Robot.drivetrain.setRaw1(.2, .2);
			} else if (timer < 3) {
				Robot.drivetrain.setRaw1(.3, .3);
			} else if (timer < 4) {
				Robot.drivetrain.setRaw1(.4, .4);
			} else if (timer < 5) {
				Robot.drivetrain.setRaw1(.5, .5);
			}
			if (Robot.oi.getRightStickY(Player1) == 1) {
				Robot.drivetrain.setRaw1(Robot.oi.getRightStickY(Player1)*throttleL, Robot.oi.getRightStickY(Player1)*throttleL);	
				//Robot.MoveForward();
				//i = i + 1;
			}

			if (Robot.oi.getRightStickX(Player1) == 1) {
				//Robot.TurnRight();
				Robot.drivetrain.setRaw1(.25, -.25);
			}
			if (Robot.oi.getLeftStickX(Player1) == 1) {
				//Robot.TurnLeft();
				Robot.drivetrain.setRaw1(-.25, .25);
			}
			if (Robot.oi.getRightStickY(Player1) == 1) {
				Robot.drivetrain.setRaw1(Robot.oi.getRightStickY(Player1)*throttleL, Robot.oi.getRightStickY(Player1)*throttleL);
			}
			if (Robot.oi.getLeftTrigger(Player1) == 1) {
				//Robot.TurnLeft();
				Robot.drivetrain.setRaw1(-.25, .25);
			}
			if (Robot.oi.getRightTrigger(Player1) == 1) {
				//Robot.TurnRight();
				Robot.drivetrain.setRaw1(.25, -.25);
				
			} else {
				Robot.drivetrain.setRaw1(0, 0);
			}
		}
		*/
	}

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
