package org.usfirst.frc.team7327.robot.commands;

import java.awt.List;
import java.util.Collection;
import java.util.LinkedList;

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

	LinkedList<Wheels> list = new LinkedList<Wheels>(); 
	Wheels test = new Wheels("test",-1,0);
	protected void initialize() {
		Wheels NW = new Wheels("NW", 0, Robot.encoderNW.getDistance()); 
		Wheels NE = new Wheels("NE", 1, Robot.encoderNE.getDistance()); 
		Wheels SW = new Wheels("SW", 2, Robot.encoderSW.getDistance()); 
		Wheels SE = new Wheels("SE", 3, Robot.encoderSE.getDistance()); 
		list.add(NW); 
		list.add(NE); 
		list.add(SW); 
		list.add(SE); 
		
	}
	static double distanceNW = Robot.encoderNW.getDistance();
	static double distanceNE = Robot.encoderNE.getDistance();
	static double distanceSW = Robot.encoderSW.getDistance();
	static double distanceSE = Robot.encoderSE.getDistance();
	static double[] distanceArray = new double[] {distanceNW, distanceNE, distanceSW, distanceSE}; 
	static double errorNW = 0; 
	static double errorNE = 0; 
	static double errorSW = 0; 
	static double errorSE = 0; 
	static double averageDistance = 0; 
	static double throttle = .65; 
	double[] errorArray = new double[] {errorNW, errorNE, errorSW, errorSE};
	
	
	

	int wheel = -1; 
	protected void execute(){
		test = list.getFirst();
		
		//System.out.println(test.Orientation); 
		
		
		distanceNW = Robot.encoderNW.getDistance();
		distanceNE = Robot.encoderNE.getDistance();
		distanceSW = Robot.encoderSW.getDistance();
		distanceSE = Robot.encoderSE.getDistance();
		distanceArray[0] = Robot.encoderNW.getDistance();
		distanceArray[1] = Robot.encoderNE.getDistance();
		distanceArray[2] = Robot.encoderSW.getDistance();
		distanceArray[3] = Robot.encoderSE.getDistance();
		

		SmartDashboard.putNumber("DistanceNW: ", distanceNW);
		SmartDashboard.putNumber("DistanceNE: ", distanceNE);
		SmartDashboard.putNumber("DistanceSW: ", distanceSW);
		SmartDashboard.putNumber("DistanceSE: ", distanceSE);
		
		if(Robot.oi.getYButton(Player1)) { wheel = 0; }
		if(Robot.oi.getBButton(Player1)) { wheel = 1; }
		if(Robot.oi.getXButton(Player1)) { wheel = 2; }
		if(Robot.oi.getAButton(Player1)) { wheel = 3; }
		if(Robot.oi.getStartButton(Player1)) { wheel = 4; }
		
		switch(wheel) {
		case -1: break; 
		case 0: Robot.drivetrain.setRaw(Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1), 0, 0, 0, 0, 0, 0); break; 
		case 1: Robot.drivetrain.setRaw(0, 0, Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1), 0, 0, 0, 0); break; 
		case 2: Robot.drivetrain.setRaw(0, 0, 0, 0, Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1), 0, 0); break; 
		case 3: Robot.drivetrain.setRaw(0, 0, 0, 0, 0, 0, Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1)); break; 
		case 4: Robot.drivetrain.setRaw(Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1)*throttle, Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1)*throttle, Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1)*throttle, Robot.oi.getLeftStickX(Player1), Robot.oi.getRightStickY(Player1)*throttle);
			break; 
		}
		
		
		
		
		averageDistance = (distanceNW+distanceNE+distanceSW+distanceSE)/4;

		if(Robot.oi.getLeftStickX(Player1) == 0 ) {
			errorNW = averageDistance - distanceNW;
			errorNE = averageDistance - distanceNE;
			errorSW = averageDistance - distanceSW;
			errorSE = averageDistance - distanceSE;
			
			/*
			if(list.get(0).Orientation.compareTo("NW")==0) {
				
			}
			*/
			
			if(Math.abs(errorNW) > Math.abs(errorNE)) {
				if(Math.abs(errorNW)>Math.abs(errorSW)) {
					if(Math.abs(errorNW)>Math.abs(errorSE)) {
						if(errorNW > 0) {Robot.drivetrain.setlNW(.15);} else {Robot.drivetrain.setlNW(-.15);}
						System.out.println();
					}
					else {
						if(errorSE > 0) {Robot.drivetrain.setlSE(-.15);} else {Robot.drivetrain.setlSE(.15);}
					}
				}
				else {
					if(Math.abs(errorSW)>Math.abs(errorSE)) {
						if(errorSW > 0 ) {Robot.drivetrain.setlSW(-.15);} else {Robot.drivetrain.setlSW(.15);}
					}
					else {
						if(errorSE > 0) {Robot.drivetrain.setlSE(-.15);} else {Robot.drivetrain.setlSE(.15);}
					}
				}
			}
			else {
				if(Math.abs(errorNE)>Math.abs(errorSW)) {
					if(Math.abs(errorNE)>Math.abs(errorSE)) {
						if(errorNE > 0) {Robot.drivetrain.setlNE(-.15);} else {Robot.drivetrain.setlNE(.15);}
					}
					else {
						if(errorSE > 0) {Robot.drivetrain.setlSE(-.15);} else {Robot.drivetrain.setlSE(.15);}
					}
				}
				else {
					if(Math.abs(errorSW)>Math.abs(errorSE)) {
						if(errorSW > 0 ) {Robot.drivetrain.setlSW(-.15);} else {Robot.drivetrain.setlSW(.15);}
					}
					else {
						if(errorSE > 0) {Robot.drivetrain.setlSE(-.15);} else {Robot.drivetrain.setlSE(.15);}
					}
				}
			}
		}
		/*
		if(Robot.oi.getLeftStickX(Player1) == 0) {
			if(list.get(0). > )
		}
		*/
		
		
		
		
		
		/*
		if(Robot.oi.getLeftStickX(Player1) == 0 ) {
			if(distanceNW < averageDistance) {
				Robot.drivetrain.setlNW(.15);
			}
			else if(distanceNW > averageDistance) {
				Robot.drivetrain.setlNW(-.15);
			}
			if(distanceNE < averageDistance) {
				Robot.drivetrain.setlNE(-.15);
			}
			else if(distanceNE > averageDistance) {
				Robot.drivetrain.setlNE(.15);
			}
			if(distanceSW < averageDistance) {
				Robot.drivetrain.setlSW(-.15);
			}
			else if(distanceSW > averageDistance) {
				Robot.drivetrain.setlSW(.15);
			}
			if(distanceSE < averageDistance) {
				Robot.drivetrain.setlSE(-.15);
			}
			else if(distanceSE > averageDistance) {..
			
			
				Robot.drivetrain.setlSE(.15);
			}
			
			
		}
		*/
				
		
		
		
	}

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
