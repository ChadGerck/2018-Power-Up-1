package org.usfirst.frc.team7327.robot.commands;

import org.usfirst.frc.team7327.robot.Robot;


//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;

public class TankDrive extends Command 
{

    
	public TankDrive() 
	{
		requires(Robot.drivetrain); 
	}
	
	XboxController Player1 = Robot.oi.Controller0; 
	double throttleL = .65; 
	double throttleA = .8;
	DoubleSolenoid.Value grabber = DoubleSolenoid.Value.kOff; 
	DoubleSolenoid.Value punchers = DoubleSolenoid.Value.kOff;
	
	protected void initialize() {}
	
	protected void execute(){
		
		/*Robot.drivetrain.setRawGrabber(grabber);
		 * 
		 */
		
<<<<<<< HEAD
		//This is for the grabber
=======
		//Wheels
		Robot.drivetrain.setRaw1((Robot.oi.getLeftStickY(Player1)+Robot.oi.getRightStickX(Player1))*throttleL, (Robot.oi.getLeftStickY(Player1)-Robot.oi.getRightStickX(Player1))*throttleL);
		
		//Arm
		Robot.drivetrain.setRawArm(Robot.oi.getRightStickY(Player1)* throttleA);
		
		//Grabbers
>>>>>>> 96559353e53bd8c4cf605bc34d6e4afe85c669f5
		if (Robot.oi.getLeftBumper(Player1))
		{
			Robot.drivetrain.setRawGrabber(DoubleSolenoid.Value.kForward);
		}
		else if (Robot.oi.getRightBumper(Player1))
		{
			Robot.drivetrain.setRawGrabber(DoubleSolenoid.Value.kReverse);
		}
		else 
		{
			Robot.drivetrain.setRawGrabber(DoubleSolenoid.Value.kOff);
		}
		
<<<<<<< HEAD
		//This is for the wheels
		Robot.drivetrain.setRaw1((Robot.oi.getLeftStickY(Player1)+Robot.oi.getRightStickX(Player1))*throttleL, (Robot.oi.getLeftStickY(Player1)-Robot.oi.getRightStickX(Player1))*throttleL);
		
		//This is for the Arm
		Robot.drivetrain.setRawArm(Robot.oi.getRightStickY(Player1)* throttleA);
		
		//This is for the Spinners
		
		if( (Robot.oi.Dpad(Player1)>=0 && Robot.oi.Dpad(Player1)<=45) || (Robot.oi.Dpad(Player1)<=315 && Robot.oi.Dpad(Player1)>=360) ) 
		{
			Robot.drivetrain.setRawSpinner(-0.4, 0.4);
=======
		//Punchers
		if(Robot.oi.getAButton(Player1))
		{
			punchers = DoubleSolenoid.Value.kForward;
			Robot.drivetrain.setPunchers(punchers);
		
		}
		
		if (Robot.oi.getBButton(Player1)) 
		{
			punchers = DoubleSolenoid.Value.kReverse;
			Robot.drivetrain.setPunchers(punchers);
		}
		
		
		//Spinners
		if((Robot.oi.Dpad(Player1)>=0 && Robot.oi.Dpad(Player1)<=45)
		 || (Robot.oi.Dpad(Player1)<=315 && Robot.oi.Dpad(Player1)>=360)) {
			Robot.drivetrain.setRawSpinner(-0.4,0.4);
>>>>>>> 96559353e53bd8c4cf605bc34d6e4afe85c669f5
		}
		else if (Robot.oi.Dpad(Player1)>=46 && Robot.oi.Dpad(Player1)<=135){
			Robot.drivetrain.setRawSpinner(0.4,0.4);
		}
		else if (Robot.oi.Dpad(Player1)>=136 && Robot.oi.Dpad(Player1)<=225) {
			Robot.drivetrain.setRawSpinner(0.4,-0.4);
		}
		else if(Robot.oi.Dpad(Player1)>=226 && Robot.oi.Dpad(Player1)<=314) {
			Robot.drivetrain.setRawSpinner(-0.4,-0.4);
		}
		else 
		{
			Robot.drivetrain.setRawSpinner(0,0);
		}
	
	}

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
