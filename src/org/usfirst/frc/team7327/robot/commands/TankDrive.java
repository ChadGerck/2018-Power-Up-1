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
	double speed = .25; 
	
	protected void initialize() {
	}
	
	protected void execute(){
		if (Robot.oi.getRightTrigger(Player1) == 1){
			speed = Math.abs(speed);
			//Robot.drivetrain.setRaw1(Robot.oi.getRightTrigger(Player1)*throttleL, Robot.oi.getRightTrigger(Player1)*throttleL);
			
			//sRobot.drivetrain.setRaw1(Robot.oi.getLeftStickX(Player1)*throttleL, 0);
		}
		
		if (Robot.oi.getLeftTrigger(Player1) == 1){
			speed = -Math.abs(speed);
			//Robot.drivetrain.setRaw1(Robot.oi.getLeftTrigger(Player1)*throttleL, Robot.oi.getLeftTrigger(Player1)*throttleL);

			
			//throttleL = Math.abs(throttleL);			
			//Robot.drivetrain.setRaw1(Robot.oi.getLeftStickX(Player1)*throttleL, 0);
		}
			
			Robot.drivetrain.setRaw1(speed + (Robot.oi.getLeftStickX(Player1)*throttleL), speed - (Robot.oi.getLeftStickX(Player1)*throttleL));

			//Robot.drivetrain.setRaw1(Robot.oi.getLeftStickX(Player1)*throttleL, 0);
			
			 /*if(Robot.oi.getLeftStickX(Player1) == 1){
				Robot.drivetrain.setRaw1(Robot.oi.getLeftStickX(Player1), 0);
			}*/
	}

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
