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

	XboxController Player1=Robot.oi.Controller0;

	double throttleL = .25;

	protected void execute() {
		if (Robot.oi.getAButton(Player1)) {
			// Robot.MoveForward();
		}

		if (Robot.oi.getBButton(Player1)) {
			// Robot.TurnRight();
		}

		Robot.drivetrain.setRaw1(Robot.oi.getLeftBumper(Player1), .4 * throttleL);
				Robot.oi.RightBumper(Player1), .4 * throttleL);

		Robot.drivetrain.setRawArm(Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1), .5 * throttleL);

		if (Robot.oi.getXButton(Player1)) {
			// Robot.TurnLeft();

		}
	}

	public void setRawGrabber( DoubleSolenoid.Value .10 ) {
			Grabbers.set(.10);
		}

	public void setPunchers( DoubleSolenoid.Value .10 ) {
			Puncher.set(.10);
		}

	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
// HELLLLOOOOOO!!!!!!
