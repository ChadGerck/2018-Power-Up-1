package org.usfirst.frc.team7327.robot.commands;

import org.usfirst.frc.team7327.robot.Robot;




import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;

public class TankDrive extends Command {
	public TankDrive(){
	requires(Robot.drivetrain);
	}

    
	
	XboxController Player1= Robot.oi.Controller0;
	double throttleL=0.3;
	double throttleR= -0.3;
	double throttleA = .55; 
	
	protected void initialize() {
		
	}
	
	protected void execute(){
		
		SmartDashboard.putNumber("Range: ", Robot.ultra.GetRangeMM());
		SmartDashboard.putNumber("Angle: ", Robot.GyroAngle());
		
		//This is for the grabber
		//DoubleSolenoid.Value.kForward or DoubleSolenoid.Value.kReverse
		if (Robot.oi.getBButton(Player1))
		{
			Robot.drivetrain.setRawGrabber(DoubleSolenoid.Value.kForward);
		}
		else if (Robot.oi.getXButton(Player1))
		{
			Robot.drivetrain.setRawGrabber(DoubleSolenoid.Value.kReverse);
		}
		else 
		{
			Robot.drivetrain.setRawGrabber(DoubleSolenoid.Value.kOff);
		}
		
		
		
		//This is for the puncher
		//DoubleSolenoid.Value.kForward or DoubleSolenoid.Value.kReverse
		if (Robot.oi.getYButton(Player1))
		{
			Robot.drivetrain.setPunchers(DoubleSolenoid.Value.kForward);
		}
		else if (Robot.oi.getAButton(Player1))
		{
			Robot.drivetrain.setPunchers(DoubleSolenoid.Value.kReverse);
		}
		else 
		{
			Robot.drivetrain.setPunchers(DoubleSolenoid.Value.kOff);
		}
		
		
		
		//This is for the wheels
		Robot.drivetrain.setRaw1((Robot.oi.getLeftTrigger(Player1)* throttleR)  + (Robot.oi.getLeftStickX(Player1)* throttleL) + (Robot.oi.getRightTrigger(Player1)* throttleL )  ,   (Robot.oi.getLeftTrigger(Player1)* throttleR) + (Robot.oi.getLeftStickX(Player1)* throttleR) + (Robot.oi.getRightTrigger(Player1)*throttleL)  );
		
		//This is for the arm
		Robot.drivetrain.setRawArm(Robot.oi.getRightStickY(Player1)*throttleA);	
		
		//This is for the spinners
		if((Robot.oi.Dpad(Player1) >= 0 && (Robot.oi.Dpad(Player1)) <= 45) || (Robot.oi.Dpad(Player1) <= 360 && (Robot.oi.Dpad(Player1)) >= 315))
		{

			Robot.drivetrain.setRawSpinner(-0.6, 0.6);	
		}
		else if (Robot.oi.Dpad(Player1) > 45 && (Robot.oi.Dpad(Player1) <= 135))
		{
			Robot.drivetrain.setRawSpinner(0.6, 0.6);
		}
		else if((Robot.oi.Dpad(Player1) > 135 && (Robot.oi.Dpad(Player1)) <= 225))
		{
			Robot.drivetrain.setRawSpinner(-0.6, 0.6);
		}
		else if(Robot.oi.Dpad(Player1) <= 225 && (Robot.oi.Dpad(Player1)) >= 315)
		{
			Robot.drivetrain.setRawSpinner(-0.6, 0.6);	
		}
		else  
		{
			Robot.drivetrain.setRawSpinner(0, 0);
		}
		
		
		
		System.out.println(Robot.GyroAngle());
		
	}

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
	
	}
}
