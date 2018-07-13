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
	protected void initialize() {
	}
	protected void execute(){
		
		boolean flag = false; 
		
		double throttle=.25;
		double armvalue=.55;
		
		XboxController Player1 = Robot.oi.Controller0;
		
		//Robot.drivetrain.setRaw1(Robot.oi.getRightStickY(Player1)*throttle,Robot.oi.getLeftStickX(Player1)*throttle);
		Robot.drivetrain.setRaw1(-Robot.oi.getLeftStickX(Player1)*throttle,-Robot.oi.getRightStickY(Player1)*throttle);
		
		
		
		if(Robot.oi.getAButton(Player1)){
			if(flag){
				flag = false;
			}
			else{ 
				flag = true; 
			}
		}
		if(flag){
			Robot.drivetrain.setRawArm((Robot.oi.getLeftTrigger(Player1)-Robot.oi.getRightTrigger(Player1))*armvalue);
		}
		else{
			Robot.drivetrain.setRawArm(0);
		}
		
		
	}

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
