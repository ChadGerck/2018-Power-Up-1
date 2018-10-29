package org.usfirst.frc.team7327.robot.subsystems;

import org.usfirst.frc.team7327.robot.RobotMap;
import org.usfirst.frc.team7327.robot.SwerveModule;
//import org.usfirst.frc.team7327.robot.commands.TankDrive;
import org.usfirst.frc.team7327.robot.commands.SwerveDrive;



import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class DriveTrain extends Subsystem {
	
	private SwerveModule moduleNE, moduleNW, moduleSE, moduleSW;
	
	static final double kP = 2.5;
	static final double kI = 0;
	static final double kD = 0;
	
	
	public static Potentiometer abeNW = new AnalogPotentiometer(0, 360, -184.2);
	public static Potentiometer abeNE = new AnalogPotentiometer(1, 360, -73.85);
	public static Potentiometer abeSW = new AnalogPotentiometer(2, 360, -281.3);
	public static Potentiometer abeSE = new AnalogPotentiometer(3, 360, -70.7);
	
	public DriveTrain() {
		moduleNE = new SwerveModule(3, 2, abeNE, kP, kI, kD,true);
		moduleNW = new SwerveModule(1, 0, abeNW, kP, kI, kD,false);
		moduleSE = new SwerveModule(7, 6, abeSE, kP, kI, kD,true);
		moduleSW = new SwerveModule(5, 4, abeSW, kP, kI, kD,false);
	
	}
	
	
	public void setAllSpeed(double speed) {
		moduleNW.setDrive(speed);
		moduleNE.setDrive(speed);
		moduleSW.setDrive(speed);
		moduleSE.setDrive(speed);
			
	} 

	public void setAllDegrees(double deg) {
		moduleNW.setSteeringDeg(deg);
		moduleNE.setSteeringDeg(deg);
		moduleSW.setSteeringDeg(deg);
		moduleSE.setSteeringDeg(deg);
	}
	
	public void setEachDegree(double NE, double NW, double SE, double SW ) {
		moduleNE.setSteeringDeg(NE);
		moduleNW.setSteeringDeg(NW);
		moduleSE.setSteeringDeg(SE);
		moduleSW.setSteeringDeg(SW);
	}
	
	public double getSteeringSetpoint() {
		return moduleNW.getSteeringSetpoint();
	}
	
	public double getSteeringError() {
		return moduleNW.getError();
	}
	
	public double getSteeringPosition() {
		return moduleNW.getSteeringEncoder();
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new SwerveDrive());


	}

}
