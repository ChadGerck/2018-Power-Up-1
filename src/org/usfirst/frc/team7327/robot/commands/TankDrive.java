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
	boolean isGrabbed = false;
	boolean isPunched = false;
	XboxController Player1 = Robot.oi.Controller0; 
	double throttleL = .25;
	double throttleA = .65;
	protected void initialize() {
		Robot.drivetrain.setRawArm(0);
		Robot.drivetrain.setPunchers(0);
		Robot.drivetrain.setRawGrabber(0);
	}
	
	protected void execute(){
		Robot.drivetrain.setRaw((-Robot.oi.getLeftStickY(Player1) - Robot.oi.getRightStickX(Player1))*throttleL, (-Robot.oi.getLeftStickY(Player1) - Robot.oi.getRightStickX(Player1))*throttleL, Robot.oi.getRightStickY(Player1)*throttleA);
		Robot.drivetrain.setRawSpinner(Robot.oi.getLeftStickX(Player1),Robot.oi.getLeftStickX(Player1) );
		if(!isPunched && Robot.oi.getAButton(Player1) == 1){
			Robot.drivetrain.setPunchers(100);
			isPunched = true;
		}
		else if(isPunched && Robot.oi.getAButton(Player1) == 1){
			Robot.drivetrain.setPunchers(0);
			isPunched = false;
		}
		if(!isGrabbed && Robot.oi.getRightBumper(Player1) == 1){
			Robot.drivetrain.setRawGrabber(100);
			isGrabbed = true;
		}
		
		else if(isGrabbed && Robot.oi.getRightBumper(Player1) == 1){
			Robot.drivetrain.setRawGrabber(0);
			isGrabbed = false;
		}		
	}

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
