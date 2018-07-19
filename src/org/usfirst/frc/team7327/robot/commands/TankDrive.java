package org.usfirst.frc.team7327.robot.commands;

import org.usfirst.frc.team7327.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;

//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;



public class TankDrive extends Command 
{
	DoubleSolenoid.Value Claws = DoubleSolenoid.Value.kOff;
	DoubleSolenoid.Value Push = DoubleSolenoid.Value.kOff;
	DigitalInput limitswitch = new DigitalInput(1);

	public TankDrive() 
	{
		requires(Robot.drivetrain);
	}

	protected void initialize() 
	{
		
	}

	boolean flag = false;
	int Dpaddown = 180;
	int Dpadup = 0;
	int Dpadleft = 360;
	int Dpadright = 90;

	protected void execute() 
	{

		System.out.println(limitswitch.get());

		double throttle = .25;
		double armvalue = .55;

		XboxController Player1 = Robot.oi.Controller0;
		

		// Robot.drivetrain.setRaw1(Robot.oi.getRightStickY(Player1)*throttle,Robot.oi.getLeftStickX(Player1)*throttle);
		// Robot.drivetrain.setRaw1(-Robot.oi.getLeftStickX(Player1)*throttle,-Robot.oi.getRightStickY(Player1)*throttle);

		
		//This is to switch modes
		if (Robot.oi.getAButton(Player1)) 
		{
			if (flag) 
			{
				flag = false;
			}
			else 
			{
				flag = true;
			}
		}
		
		//This is for the arm
		if (flag) 
		{
			Robot.drivetrain.setRawArm((Robot.oi.getLeftStickX(Player1) - Robot.oi.getRightStickY(Player1)) * armvalue);
			Robot.drivetrain.setRaw1(0, 0);

		} 
		else //This is for the wheels
		{
			Robot.drivetrain.setRawArm(0);
			Robot.drivetrain.setRaw1(-Robot.oi.getLeftStickX(Player1) * throttle,
					-Robot.oi.getRightStickY(Player1) * throttle);

		}
		
		//This is for the Spinners
		if ((Robot.oi.Dpad(Player1) >= 0 && Robot.oi.Dpad(Player1) <= 45) || (Robot.oi.Dpad(Player1) <= 315 && Robot.oi.Dpad(Player1) >= 360)) 
		{
			Robot.drivetrain.setRawSpinner(-.3, .3);
		} 
		else if (Robot.oi.Dpad(Player1) > 45 && Robot.oi.Dpad(Player1) <= 135) 
		{
			Robot.drivetrain.setRawSpinner(.3, -.3);
		} 
		else if (Robot.oi.Dpad(Player1) > 135 && Robot.oi.Dpad(Player1) <= 225) 
		{
			Robot.drivetrain.setRawSpinner(.3, -.3);
		} 
		else if (Robot.oi.Dpad(Player1) > 225 && Robot.oi.Dpad(Player1) <= 0) 
		{
			Robot.drivetrain.setRawSpinner(.3, .3);
		} 
		else 
		{
			Robot.drivetrain.setRawSpinner(0, 0);	
		}
		
		//This is for the Claw

		if(Robot.oi.getLeftBumper(Player1))
		{ 
			
			Claws = DoubleSolenoid.Value.kReverse;
			Robot.drivetrain.setRawGrabber(Claws);
			
		}
			
		if(Robot.oi.getRightBumper(Player1))
		{
			Claws = DoubleSolenoid.Value.kForward;
			Robot.drivetrain.setRawGrabber(Claws);

		}
		
		
		//This is for Push
		if(Robot.oi.getBButton(Player1))
		{ 
			
			Push = DoubleSolenoid.Value.kReverse;
			Robot.drivetrain.setPunchers(Push);
			
		}
			
		if(Robot.oi.getXButton(Player1))
		{
			Push = DoubleSolenoid.Value.kForward;
			Robot.drivetrain.setPunchers(Push);

		}
		
				
				
		
		
	}

	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
	
	
}
