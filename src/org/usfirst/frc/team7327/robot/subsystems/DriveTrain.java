package org.usfirst.frc.team7327.robot.subsystems;

import org.usfirst.frc.team7327.robot.RobotMap;
import org.usfirst.frc.team7327.robot.commands.TankDrive;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	
	private TalonSRX LeftTalon; 
	private TalonSRX LeftTalon1; 
	private TalonSRX RightTalon;
	private TalonSRX RightTalon1;

	//private Spark LeftMotor;
	//private Spark RightMotor;
	//private Spark LeftMotor1;
	//private Spark RightMotor1;
	private Spark ArmMotor;
	private Spark SpinnerLeft;
	private Spark SpinnerRight;
	private DoubleSolenoid Grabbers;
	private DoubleSolenoid Puncher;
	
	
	public DriveTrain() {
		LeftTalon  = new TalonSRX(0);
		LeftTalon1 = new TalonSRX(1);
		RightTalon = new TalonSRX(2);
		RightTalon1= new TalonSRX(3);
		
		//LeftMotor = new Spark(RobotMap.LEFT_MOTOR.value);
		//RightMotor = new Spark(RobotMap.RIGHT_MOTOR.value);	
		//LeftMotor1 = new Spark(RobotMap.LEFT_MOTOR1.value);
		//RightMotor1 = new Spark(RobotMap.RIGHT_MOTOR1.value);
		ArmMotor = new Spark(RobotMap.ARM_MOTOR.value);
		SpinnerLeft = new Spark(RobotMap.SpinnerLeft_MOTOR.value);
		SpinnerRight = new Spark(RobotMap.SpinnerRight_MOTOR.value);
		Grabbers = new DoubleSolenoid(0,0,7);
		Puncher = new DoubleSolenoid(1,1,6);
	}
	
	public double getLeftTalon() {
		return LeftTalon.getMotorOutputPercent();
	}
	
	/*public void setRaw(double leftvalue, double rightvalue, double armvalue) {
		LeftMotor.set(leftvalue);
		RightMotor.set(-rightvalue);
		LeftMotor1.set(leftvalue);
		RightMotor1.set(-rightvalue);
		ArmMotor.set(armvalue);
			
	} 
	*/
	public void setRaw(double leftvalue, double rightvalue, double armvalue) {
		LeftTalon.set(ControlMode.PercentOutput, leftvalue);
		LeftTalon1.set(ControlMode.PercentOutput, leftvalue);
		RightTalon.set(ControlMode.PercentOutput, -rightvalue);
		RightTalon1.set(ControlMode.PercentOutput, -rightvalue);
		ArmMotor.set(armvalue);
			
	} 
	/*
	public void setRaw1(double leftvalue, double rightvalue) {
		LeftMotor.set(leftvalue);
		RightMotor.set(-rightvalue);
		LeftMotor1.set(leftvalue);
		RightMotor1.set(-rightvalue);
		
	} 
	*/
	public void setRaw1(double leftvalue, double rightvalue) {
		LeftTalon.set(ControlMode.PercentOutput, leftvalue);
		LeftTalon1.set(ControlMode.PercentOutput, leftvalue);
		RightTalon.set(ControlMode.PercentOutput, -rightvalue);
		RightTalon1.set(ControlMode.PercentOutput, -rightvalue);
			
	} 
	
	public void setRawArm(double armvalue) {
		ArmMotor.set(armvalue);
		
	}
	
	public void setRawSpinner(double spinnerleft, double spinnerright) {
		SpinnerLeft.set(spinnerleft);
		SpinnerRight.set(spinnerright);
	}
	
	public void setRawGrabber(DoubleSolenoid.Value grabbervalue) {
		Grabbers.set(grabbervalue);
	}

	public void setPunchers( DoubleSolenoid.Value punchervalue ) {
		Puncher.set(punchervalue);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());


	}

}
