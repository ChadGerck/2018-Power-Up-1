package org.usfirst.frc.team7327.robot.subsystems;

import org.usfirst.frc.team7327.robot.RobotMap;
import org.usfirst.frc.team7327.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	private Spark LeftMotor;
	private Spark RightMotor;
	private Spark LeftMotor1;
	private Spark RightMotor1;
	private Spark ArmMotor;
	private Spark WheelMotor;
	//private DoubleSolenoid Flappers;
	private Spark WinchMotor;
	
	
	
	public DriveTrain() {
		LeftMotor = new Spark(RobotMap.LEFT_MOTOR.value);
		RightMotor = new Spark(RobotMap.RIGHT_MOTOR.value);	
		LeftMotor1 = new Spark(RobotMap.LEFT_MOTOR1.value);
		RightMotor1 = new Spark(RobotMap.RIGHT_MOTOR1.value);	
		WheelMotor = new Spark(RobotMap.WHEEL_MOTOR.value);
		ArmMotor = new Spark(RobotMap.ARM_MOTOR.value);
		//Flappers = new DoubleSolenoid(0,4);
		WinchMotor = new Spark(RobotMap.WINCH_MOTOR.value);
	}
	
	public void setRaw(double rightvalue, double leftvalue, double wheelvalue, double armvalue, double winchvalue) {
		LeftMotor.set(leftvalue);
		RightMotor.set(-rightvalue);
		LeftMotor1.set(leftvalue);
		RightMotor1.set(-rightvalue);
		WheelMotor.set(wheelvalue);
		ArmMotor.set(armvalue);
		//Flappers.set(flapervalue);
		WinchMotor.set(winchvalue);
			
	} 
	
	public void setRaw1(double rightvalue, double leftvalue/*, double wheelvalue, double armvalue, double winchvalue*/) {
		LeftMotor.set(leftvalue);
		RightMotor.set(-rightvalue);
		LeftMotor1.set(leftvalue);
		RightMotor1.set(-rightvalue);
		//WheelMotor.set(wheelvalue);
		//ArmMotor.set(armvalue);
		//Flappers.set(flapervalue);
		//WinchMotor.set(winchvalue);
			
	} 
	public void setRaw2(double wheelvalue, double armvalue) {
		WheelMotor.set(wheelvalue);
		ArmMotor.set(armvalue);
		
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());


	}

}
