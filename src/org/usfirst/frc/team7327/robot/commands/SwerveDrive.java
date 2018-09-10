package org.usfirst.frc.team7327.robot.commands;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.usfirst.frc.team7327.robot.Robot;


//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;

public class SwerveDrive extends Command {
	public SwerveDrive() {
		requires(Robot.drivetrain); 
	}

	ExecutorService executorService = Executors.newFixedThreadPool(4);
	public static XboxController Player1 = Robot.oi.Controller0; 
	protected void initialize() {
		
	}
	static double throttle = .45; 

	int wheel = -1; 
	static boolean fix = true; 
	
	
	protected void execute(){
		SmartDashboard.putNumber("abeNW: ", Robot.NWAngle());
		SmartDashboard.putNumber("abeNE: ", Robot.NEAngle());
		SmartDashboard.putNumber("abeSW: ", Robot.SWAngle());
		SmartDashboard.putNumber("abeSE: ", Robot.SEAngle());
		
		SmartDashboard.putNumber("Gyro: ", Robot.GyroAngle());
		
		
		if(Robot.oi.getStartButton(Player1)) { wheel = 4;
			if(throttle == .45) { throttle = .65; }
			else { throttle = .45; }
		}
		if(Robot.oi.getRightBumper(Player1)) { wheel = 6; }
		
		if(Robot.oi.getSlowButton(Player1)) {
			throttle = .25; 
		}
		
		switch(wheel) {
		case -1: fix = true; break; 
		case 4: Robot.drivetrain.setRaw(Robot.oi.getLeftStickX(Player1)*throttle, (Robot.oi.getRightStickY(Player1)+Robot.oi.getRightTrigger(Player1))*throttle, Robot.oi.getLeftStickX(Player1)*throttle, (Robot.oi.getRightStickY(Player1)-Robot.oi.getRightTrigger(Player1))*throttle, Robot.oi.getLeftStickX(Player1)*throttle, (Robot.oi.getRightStickY(Player1)+Robot.oi.getRightTrigger(Player1))*throttle, Robot.oi.getLeftStickX(Player1)*throttle, (Robot.oi.getRightStickY(Player1)-Robot.oi.getRightTrigger(Player1))*throttle);
			fix = true; 
			break; 
		
		case 6:
			executorService.submit(this::NWSpin);
			executorService.submit(this::NESpin);
			executorService.submit(this::SWSpin);
			executorService.submit(this::SESpin); 
			    
			Robot.drivetrain.setSpeed(Robot.oi.getRightStickY(Player1)*throttle);
			fix = false; 
			break; 
		
		}
		
		
		if(fix) {Robot.CorrectYourself();}
		
	}

	public int NWSpin() {
		double degrees = 315; 
		double Phi = Robot.NWAngle(); 
		if(!fix) {
		if(Math.sin(Math.toRadians(degrees - Phi)) < 0) {
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeNW: ", Robot.NWAngle());
				Robot.drivetrain.setlNW(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.NWAngle();
			} 
			while(Math.sin(Math.toRadians(degrees-Phi)) > 0) {
				SmartDashboard.putNumber("abeNW: ", Robot.NWAngle());
				Robot.drivetrain.setlNW(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.NWAngle();
			} 
			Robot.drivetrain.setlNW(0);
		}else {
			while(Math.sin(Math.toRadians(degrees-Phi)) >= 0) {
				SmartDashboard.putNumber("abeNW: ", Robot.NWAngle());
				Robot.drivetrain.setlNW(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.NWAngle(); 
			}
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeNW: ", Robot.NWAngle());
				Robot.drivetrain.setlNW(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.NWAngle(); 
			}
			Robot.drivetrain.setlNW(0);
		}
		}
		
		return 0; 
	}

	public int NESpin(){
		double degrees = 225; 
		double Phi = Robot.NEAngle(); 
		if(!fix) {
		if(Math.sin(Math.toRadians(degrees - Phi)) < 0) {
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeNE: ", Robot.NEAngle());
				Robot.drivetrain.setlNE(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.NEAngle();
			} 
			while(Math.sin(Math.toRadians(degrees-Phi)) > 0) {
				SmartDashboard.putNumber("abeNE: ", Robot.NEAngle());
				Robot.drivetrain.setlNE(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.NEAngle();
			} 
			Robot.drivetrain.setlNE(0);
		}else {
			while(Math.sin(Math.toRadians(degrees-Phi)) >= 0) {
				SmartDashboard.putNumber("abeNE: ", Robot.NEAngle());
				Robot.drivetrain.setlNE(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.NEAngle(); 
			}
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeNE: ", Robot.NEAngle());
				Robot.drivetrain.setlNE(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.NEAngle(); 
			}
			Robot.drivetrain.setlNE(0);
		}
		}
		return 0;
		
	}
	

	public int SWSpin(){
		int degrees = 45; 
		double Phi = Robot.SWAngle(); 
		if(!fix) {
		if(Math.sin(Math.toRadians(degrees - Phi)) < 0) {
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeSW: ", Robot.SWAngle());
				Robot.drivetrain.setlSW(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.SWAngle();
			} 
			while(Math.sin(Math.toRadians(degrees-Phi)) > 0) {
				SmartDashboard.putNumber("abeSW: ", Robot.SWAngle());
				Robot.drivetrain.setlSW(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.SWAngle();
			} 
			Robot.drivetrain.setlSW(0);
		}else {
			while(Math.sin(Math.toRadians(degrees-Phi)) >= 0) {
				SmartDashboard.putNumber("abeSW: ", Robot.SWAngle());
				Robot.drivetrain.setlSW(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.SWAngle(); 
			}
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeSW: ", Robot.SWAngle());
				Robot.drivetrain.setlSW(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.SWAngle(); 
			}
			Robot.drivetrain.setlSW(0);
		}
		}
		return 0; 
	}

	public int SESpin(){
		int degrees = 135; 
		double Phi = Robot.SEAngle(); 
		if(!fix) { 
		if(Math.sin(Math.toRadians(degrees - Phi)) < 0) {
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeSE: ", Robot.SEAngle());
				Robot.drivetrain.setlSE(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.SEAngle();
			} 
			while(Math.sin(Math.toRadians(degrees-Phi)) > 0) {
				SmartDashboard.putNumber("abeSE: ", Robot.SEAngle());
				Robot.drivetrain.setlSE(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.SEAngle();
			} 
			Robot.drivetrain.setlSE(0);
		}else {
			while(Math.sin(Math.toRadians(degrees-Phi)) >= 0) {
				SmartDashboard.putNumber("abeSE: ", Robot.SEAngle());
				Robot.drivetrain.setlSE(-.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.SEAngle(); 
			}
			while(Math.sin(Math.toRadians(degrees-Phi)) < 0) {
				SmartDashboard.putNumber("abeSE: ", Robot.SEAngle());
				Robot.drivetrain.setlSE(.15);
				try{Thread.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
				Phi = Robot.SEAngle(); 
			}
			Robot.drivetrain.setlSE(0);
		}
		}
		
		return 0; 
	}

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
