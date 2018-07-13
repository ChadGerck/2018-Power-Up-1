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

	XboxController Player1 = Robot.oi.Controller0;
	double throttleL = 0.35;
	double throttleK = 0.55;
	DoubleSolenoid.Value Grabbers = DoubleSolenoid.Value.kOff;
	DoubleSolenoid.Value Punchers = DoubleSolenoid.Value.kOff;

	public TankDrive() {
		requires(Robot.drivetrain);
	}

	protected void initialize() { 
	}

	protected void execute() {

		// Robot.drivetrain.setRaw(Robot.oi.getLeftTrigger(Player1)*-throttleL,
		// Robot.oi.getRightTrigger(Player1)*-throttleL,
		// (Robot.oi.getLeftStickY(Player1))*throttleK);

		if (Robot.oi.getRightBumper(Player1) == true) {
			throttleL = Math.abs(throttleL) * -1;
		}
		if (Robot.oi.getLeftBumper(Player1) == true) {
			throttleL = Math.abs(throttleL);
		}

		Robot.drivetrain.setRaw(Robot.oi.getLeftTrigger(Player1) * throttleL,
				Robot.oi.getRightTrigger(Player1) * throttleL, (Robot.oi.getLeftStickY(Player1)) * throttleK);

		if (Robot.oi.getYButton(Player1)) {
			Grabbers = DoubleSolenoid.Value.kForward;
			Robot.drivetrain.setRawGrabber(Grabbers);
		}

		if (Robot.oi.getAButton(Player1)) {
			Grabbers = DoubleSolenoid.Value.kReverse;
			Robot.drivetrain.setRawGrabber(Grabbers);
		}

		if (Robot.oi.getXButton(Player1)) {
			Punchers = DoubleSolenoid.Value.kForward;
			Robot.drivetrain.setPunchers(Punchers);
		}

		if (Robot.oi.getBButton(Player1)) {
			Punchers = DoubleSolenoid.Value.kReverse;
			Robot.drivetrain.setPunchers(Punchers);
		}
	}

	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
