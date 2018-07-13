package org.usfirst.frc.team7327.robot.commands;

import org.usfirst.frc.team7327.robot.Robot;




import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;

public class TankDrive extends Command {

    
	
	XboxController Player1= Robot.oi.Controller0;
	double throttleL=0.25;
	double throttleR= -.25;
	
	protected void initialize() {
	}
	protected void execute(){
		Robot.drivetrain.setRaw1((Robot.oi.getLeftTrigger(Player1)* throttleR)  + (Robot.oi.getLeftStickX(Player1)* throttleL) + (Robot.oi.getRightTrigger(Player1)* throttleL ) + (Robot.oi.getRightStickX(Player1)* throttleL) , (Robot.oi.getRightStickX(Player1)* throttleL ) + (Robot.oi.getLeftTrigger(Player1)* throttleR) + (Robot.oi.getLeftStickX(Player1)* throttleL) + (Robot.oi.getRightTrigger(Player1)*throttleL)  );
		
		Robot.drivetrain.setRawArm(Robot.oi.getLeftStickY(Player1)*throttleL);
		
	}

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
	
	}
}
