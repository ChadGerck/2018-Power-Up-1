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
	
	private TalonSRX lilNW; 
	private TalonSRX bigNW; 
	private TalonSRX lilNE;
	private TalonSRX bigNE;
	private TalonSRX lilSW; 
	private TalonSRX bigSW; 
	private TalonSRX lilSE;
	private TalonSRX bigSE;

	
	public DriveTrain() {
		lilNW = new TalonSRX(0);
		bigNW = new TalonSRX(1);
		lilNE = new TalonSRX(2);
		bigNE = new TalonSRX(3);
		lilSW = new TalonSRX(4);
		bigSW = new TalonSRX(5);
		lilSE = new TalonSRX(6);
		bigSE = new TalonSRX(7);
	
	}
	
	public void setRaw(double lNW, double bNW, double lNE, double bNE, double lSW, double bSW, double lSE, double bSE) {
		lilNW.set(ControlMode.PercentOutput, -lNW);
		bigNW.set(ControlMode.PercentOutput, bNW);
		lilNE.set(ControlMode.PercentOutput, -lNE);
		bigNE.set(ControlMode.PercentOutput, -bNE);
		lilSW.set(ControlMode.PercentOutput, -lSW);
		bigSW.set(ControlMode.PercentOutput, bSW);
		lilSE.set(ControlMode.PercentOutput, -lSE);
		bigSE.set(ControlMode.PercentOutput, -bSE);
			
	} 
	public void setSpeed(double speed) {
		bigNW.set(ControlMode.PercentOutput, -speed);
		bigNE.set(ControlMode.PercentOutput, -speed);
		bigSW.set(ControlMode.PercentOutput, speed);
		bigSE.set(ControlMode.PercentOutput, -speed);
			
	} 
	
	public void setlNW(double lNW) {
		lilNW.set(ControlMode.PercentOutput, -lNW);
	}
	public void setlNE(double lNE) {
		lilNE.set(ControlMode.PercentOutput, lNE);
	}
	public void setlSW(double lSW) {
		lilSW.set(ControlMode.PercentOutput, lSW);
	}
	public void setlSE(double lSE) {
		lilSE.set(ControlMode.PercentOutput, lSE);
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());


	}

}
