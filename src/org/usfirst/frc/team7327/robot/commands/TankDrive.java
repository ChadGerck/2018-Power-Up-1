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
				
			Robot.drivetrain.setRaw1(Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1)*throttleL);
			
			if(Robot.oi.getRightTrigger(Player1) == 1) {
				Robot.drivetrain.setRawArm(0.3);
			}
			else{
				Robot.drivetrain.setRawArm(0);
				
			}
			
			if( Robot.oi.getStartButton(Player1)) {
				Robot.TurnLeft();
				Robot.TurnLeft();
				Robot.MoveForward();
		}
	}
	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}

    
}