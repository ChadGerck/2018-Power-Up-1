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
	boolean flag = false; 
	int Dpaddown = 180;
	int Dpadup = 0;
	int Dpadleft = 360;
	int Dpadright = 90;

	protected void execute(){
		
		
		double throttle=.25;
		double armvalue=.55;
		
		XboxController Player1 = Robot.oi.Controller0;
		
		//Robot.drivetrain.setRaw1(Robot.oi.getRightStickY(Player1)*throttle,Robot.oi.getLeftStickX(Player1)*throttle);
		//Robot.drivetrain.setRaw1(-Robot.oi.getLeftStickX(Player1)*throttle,-Robot.oi.getRightStickY(Player1)*throttle);
		
		
		
		if(Robot.oi.getAButton(Player1)){
			if(flag){
				flag = false;
			}
			else{ 
				flag = true; 
			}
		}
		if(flag){
			Robot.drivetrain.setRawArm((Robot.oi.getLeftStickX(Player1)-Robot.oi.getRightStickY(Player1))*armvalue);
			Robot.drivetrain.setRaw1(0,0);
			
		}
		else{
			Robot.drivetrain.setRawArm(0);
			Robot.drivetrain.setRaw1(-Robot.oi.getLeftStickX(Player1)*throttle,-Robot.oi.getRightStickY(Player1)*throttle);
			
		}
		if((Robot.oi.Dpad(Player1) >= 0 && Robot.oi.Dpad(Player1)<= 45)||(Robot.oi.Dpad(Player1) <= 360 && Robot.oi.Dpad(Player1) >= 315)){
			Robot.drivetrain.setRawSpinner(.3, .3);
		}
		else if(Robot.oi.Dpad(Player1) > 45 && Robot.oi.Dpad(Player1) <= 135){
			Robot.drivetrain.setRawSpinner(.3, -.3);
		}
		else if(Robot.oi.Dpad(Player1) > 135 && Robot.oi.Dpad(Player1) <=225){
			Robot.drivetrain.setRawSpinner(-.3, -.3);
		}
		else if(Robot.oi.Dpad(Player1) > 225 && Robot.oi.Dpad(Player1) <= 360){
			Robot.drivetrain.setRawSpinner(.2, .2);
		}
			
			
			
			
		}
		
		
		


	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
