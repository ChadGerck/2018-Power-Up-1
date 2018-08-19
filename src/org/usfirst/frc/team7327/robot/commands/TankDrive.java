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

public class TankDrive extends Command {
	public TankDrive() {
		requires(Robot.drivetrain); 
	}
	
	/*
	Thread NWthread = new Thread() {
		public void run() {
			System.out.println("Working");
		}
	};
	
	Thread NEthread = new Thread() {
		public void run() {
			System.out.println("Better");
		}
	}; 
	*/

	ExecutorService executorService = Executors.newFixedThreadPool(2);
	public static XboxController Player1 = Robot.oi.Controller0; 
	protected void initialize() {
		/*
		NWthread.start();
		NEthread.start();
		try {NWthread.join();} catch (InterruptedException e) {e.printStackTrace();}
		try {NEthread.join();} catch (InterruptedException e) {e.printStackTrace();}
		*/
		
	}
	static double throttle = .45; 
	//static boolean fix = false; 

	int wheel = -1; 
	boolean fix = false; 
	
	void testA() {
		System.out.println("Working");
	}
	void testB() {
		System.out.println("Better");
	}
	
	private int countA = 0; 
	private int countB = 0; 
	
	int countA(){
        for (int i = 0; i < 1000; i++) {
            countA++;
            try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            System.out.println(countA);
        }
        return countA;
    }

	
    int countB(){
        for (int i = 0; i < 1000; i++) {
            countB++;
            try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            System.out.println(countB);
        }
        return countB;
    }


   
    
	
	protected void execute(){
		SmartDashboard.putNumber("abeNW: ", Robot.NWAngle());
		SmartDashboard.putNumber("abeNE: ", Robot.NEAngle());
		SmartDashboard.putNumber("abeSW: ", Robot.SWAngle());
		SmartDashboard.putNumber("abeSE: ", Robot.SEAngle());
		
		SmartDashboard.putNumber("Gyro: ", Robot.GyroAngle());
		
		
		
		if(Robot.oi.getYButton(Player1)) { wheel = 0; }
		if(Robot.oi.getBButton(Player1)) { wheel = 1; }
		if(Robot.oi.getXButton(Player1)) { wheel = 2; }
		if(Robot.oi.getAButton(Player1)) { wheel = 3; }
		if(Robot.oi.getStartButton(Player1)) { wheel = 4;
			if(throttle == .45) { throttle = .65; }
			else { throttle = .45; }
		}
		if(Robot.oi.getRightBumper(Player1)) { wheel = 6; }
		
		if(Robot.oi.getSlowButton(Player1)) {
			throttle = .25; 
		}
		
		switch(wheel) {
		case 0: Robot.NWTurnTo(225); fix = false; break; 
		case 1: Robot.NETurnTo(315); fix = false; break; 
		case 2: Robot.SWTurnTo(45); fix = false; break; 
		case 3: Robot.SETurnTo(135); fix = false; break; 
		case 4: Robot.drivetrain.setRaw(Robot.oi.getLeftStickX(Player1)*throttle, (Robot.oi.getRightStickY(Player1)+Robot.oi.getRightTrigger(Player1))*throttle, Robot.oi.getLeftStickX(Player1)*throttle, (Robot.oi.getRightStickY(Player1)-Robot.oi.getRightTrigger(Player1))*throttle, Robot.oi.getLeftStickX(Player1)*throttle, (Robot.oi.getRightStickY(Player1)+Robot.oi.getRightTrigger(Player1))*throttle, Robot.oi.getLeftStickX(Player1)*throttle, (Robot.oi.getRightStickY(Player1)-Robot.oi.getRightTrigger(Player1))*throttle);
			fix = true; 
			break; 
		
		case 6:
			    executorService.submit(this::ControllerX);
			Robot.drivetrain.setSpeed(Robot.oi.getRightStickY(Player1)*throttle);
			fix = false; 
			break; 
		
		}
		
		
		
		if(fix) {Robot.CorrectYourself();}
		
	}
	
	public int ControllerY() {
			 
		System.out.println("Y= " + Robot.oi.getRightStickY(Player1));
		try { Thread.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
		 
		return 0; 
	}
	
	public int ControllerX() {
			
	   	System.out.println("X= " + Robot.oi.getLeftStickX(Player1));
	   	try {Thread.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
	    
		return 0; 
	}
	

	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
