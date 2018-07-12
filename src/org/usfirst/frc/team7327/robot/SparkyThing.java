package org.usfirst.frc.team7327.robot;
import org.usfirst.frc.team7327.robot.Robot;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;
public class SparkyThing extends Command {
	XboxController Player1 = Robot.oi.Controller0;
	double throttleL = 0.35;
	double throttleX = 0.55;
	public SparkyThing() {
		requires(Robot.drivetrain); 
	}
	protected void initialize() {
	}
	protected void execute(){
		Robot.drivetrain.setRaw(Robot.oi.getLeftStickY(Player1)*throttleL,Robot.oi.getRightStickX(Player1)*throttleL,(Robot.oi.getRightTrigger(Player1)-Robot.oi.getLeftTrigger(Player1))*throttleX);
	}
	protected boolean isFinished() {
		return false;
	} 
	protected void interrupted() {
		end();
	}	
}