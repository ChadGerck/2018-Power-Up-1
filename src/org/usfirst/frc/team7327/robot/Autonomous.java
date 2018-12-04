package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous {

	public static void Auto() {
		
		Robot.MoveForwardFeet(33);
		Robot.TurnLeft();
		Robot.MoveForwardFeet(7);
		Robot.TurnRight();
		Robot.TurnRight();
		Robot.MoveForwardFeet(7);
		Robot.TurnRight();
		Robot.MoveForwardFeet(33);
	}
	public static void MoveAngle(double angle) throws InterruptedException {
	  Robot.drivetrain.setRaw1(.25, .25); 
	  double gyroAngle = Robot.GyroAngle();
	  gyroAngle = Math.toRadians(gyroAngle);
	  
	 Thread.sleep(20); 
	

		 
		 //chades work
		/* private static void TurnTo(double degrees){
				double Phi = GyroAngle(); 
				if(Math.sin(Math.toRadians(degrees - Phi)) < 0) {
					while(!tele && Math.sin(Math.toRadians(degrees-Phi)) < 0) {
						SmartDashboard.putNumber("Gyro: ", GyroAngle());
						drivetrain.setRaw(-.3, .4, 0); 
						try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
						Phi = GyroAngle();
					} 
					while(!tele && Math.sin(Math.toRadians(degrees-Phi)) > 0) {
						SmartDashboard.putNumber("Gyro: ", GyroAngle());
						drivetrain.setRaw(.25, -.25, 0); 
						try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
						Phi = GyroAngle();
					} 
				}else {
					while(!tele && Math.sin(Math.toRadians(degrees-Phi)) >= 0) {
						SmartDashboard.putNumber("Gyro: ", GyroAngle());
						drivetrain.setRaw(.4, -.3, 0); 
						try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
						Phi = GyroAngle();
					}
					while(!tele && Math.sin(Math.toRadians(degrees-Phi)) < 0) {
						SmartDashboard.putNumber("Gyro: ", GyroAngle());
						drivetrain.setRaw(-.25, .25, 0); 
						try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
						Phi = GyroAngle();
					}
				}
	 }
			/*double L = gyroAngle ;
			double A = gyroAngle; 
			while (L == gyroAngle){
				L = L - A;*/
				
			
		}

	
	 /* 
	 * 
	 * /*int i = 0; while (i <= 54) { Robot.MoveForward(); //sorry; if (i == 27
	 * || i == 54) { Robot.TurnRight(); Robot.TurnRight(); } i++;
	 * 
	 * }
	 * 
	 * int i = 0; while (i < 26) { Robot.MoveForward(); i++; }
	 * Robot.TurnRight(); Robot.TurnRight();
	 * 
	 * i = 0; while (i < 26) { Robot.MoveForward(); i++; } Robot.TurnRight();
	 * Robot.TurnRight();
	 * 
	 * // moveForward(27); // Robot.TurnRight(); // Robot.TurnRight(); //
	 * moveForward(27); // Robot.TurnRight(); Robot.TurnRight();
	 */

	public static void moveForward(int distance) {

	}

	public static void turnRight(int distance) {

	}

	public static void turnAround() {
		turnRight(2);
	}
	
	
}
