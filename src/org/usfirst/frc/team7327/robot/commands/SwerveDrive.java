package org.usfirst.frc.team7327.robot.commands;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

	Future<Double> futureNW = executorService.submit(this::InitialSpin);  
	Future<Double> futureNE = executorService.submit(this::InitialSpin);  
	Future<Double> futureSW = executorService.submit(this::InitialSpin); 
	Future<Double> futureSE = executorService.submit(this::InitialSpin); 
	static double throttle = .45; 

	int wheel = -1; 
	public static boolean fix = false; 
	boolean futureReset = true; 
	
	
	
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
		if(Robot.oi.getRightBumper(Player1)) { wheel = 6; futureReset = true; }
		if(Robot.oi.getLeftBumper(Player1)) { wheel = 7; futureReset = true; }
		
		if(Robot.oi.getSlowButton(Player1)) {
			throttle = .25; 
		}
		
		switch(wheel) {
		case -1: fix = false; break; 
		case 4: Robot.drivetrain.setRaw(Robot.oi.getLeftStickX(Player1)*throttle, 
				(Robot.oi.getRightStickY(Player1)+(Robot.oi.getRightTrigger(Player1)*throttle)-(Robot.oi.getLeftTrigger(Player1)*throttle))*throttle,
				Robot.oi.getLeftStickX(Player1)*throttle, 
				(Robot.oi.getRightStickY(Player1)-(Robot.oi.getRightTrigger(Player1)*throttle)+(Robot.oi.getLeftTrigger(Player1)*throttle))*throttle, 
				Robot.oi.getLeftStickX(Player1)*throttle, 
				(Robot.oi.getRightStickY(Player1)+(Robot.oi.getRightTrigger(Player1)*throttle)-(Robot.oi.getLeftTrigger(Player1)*throttle))*throttle, 
				Robot.oi.getLeftStickX(Player1)*throttle, 
				(Robot.oi.getRightStickY(Player1)-(Robot.oi.getRightTrigger(Player1)*throttle)+(Robot.oi.getLeftTrigger(Player1)*throttle))*throttle);
			fix = true; 
			break; 
		
		case 6:
			//executorService.submit(this::NWSpin);
			//executorService.submit(this::NESpin);
			//executorService.submit(this::SWSpin);
			//executorService.submit(this::SESpin); 
			
			
			
			//Future futureNW = executorService.submit(this::NWSpin);  //NW to 315
			//Future futureNE = executorService.submit(this::NESpin);  //NE to 225
			//Future futureSW = executorService.submit(this::SWSpin);  //SW to 45
			//Future futureSE = executorService.submit(this::SESpin);  //SE to 135
			if(!futureReset) {
			try {
				if( futureNW.get() <= 325 &&  futureNW.get() >= 305) {} 
				else {
					Robot.NWdegree = 315; 
					futureNW = executorService.submit(this::NWSpin);
					System.out.println("futureNW: "+futureNW.get());
				}

				if(futureNE.get() <= 235 && futureNE.get() >= 215) {}
				else {
					Robot.NEdegree = 225; 
					futureNE = executorService.submit(this::NESpin);
					System.out.println("futureNE: "+futureNE.get());
				}

				if(futureSW.get() <= 55 && futureSW.get() >= 35) {}
				else {
					Robot.SWdegree = 45; 
					futureSW = executorService.submit(this::SWSpin);
					System.out.println("futureSW: "+futureSW.get());
				}

				if(futureSE.get() <= 145 && futureSE.get() >= 125) {}
				else {
					Robot.SEdegree = 135; 
					futureSE = executorService.submit(this::SESpin);
					System.out.println("futureSE: "+futureSE.get());
				}
			} catch (InterruptedException | ExecutionException e) { e.printStackTrace(); }
			}
			if(futureReset) {
				Robot.NWdegree = 315; 
				futureNW = executorService.submit(this::NWSpin);
				Robot.NEdegree = 225; 
				futureNE = executorService.submit(this::NESpin);
				Robot.SWdegree = 45; 
				futureSW = executorService.submit(this::SWSpin);
				Robot.SEdegree = 135; 
				futureSE = executorService.submit(this::SESpin);
				System.out.println("It made it here!!!!!");
				futureReset = false; 
			}
			
			/*
			try {
				System.out.println("futureNW: "+futureNW.get());
				System.out.println("futureNE: "+futureNE.get());
				System.out.println("futureSW: "+futureSW.get());
				System.out.println("futureSE: "+futureSE.get());
			} catch (InterruptedException | ExecutionException e1) { e1.printStackTrace(); }
			*/
			
			Robot.drivetrain.setSpeed(Robot.oi.getRightStickY(Player1)*throttle);
			fix = false; 
			break; 
		case 7: 
			if(!futureReset) {
				try {
					if( futureNW.get() <= 190 &&  futureNW.get() >= 170) {} 
					else {
						Robot.NWdegree = 180; 
						futureNW = executorService.submit(this::NWSpin);
						System.out.println("futureNW: "+futureNW.get());
					}

					if(futureNE.get() <= 190 && futureNE.get() >= 170) {}
					else {
						Robot.NEdegree = 180; 
						futureNE = executorService.submit(this::NESpin);
						System.out.println("futureNE: "+futureNE.get());
					}

					if(futureSW.get() <= 170 && futureSW.get() >= 170) {}
					else {
						Robot.SWdegree = 180; 
						futureSW = executorService.submit(this::SWSpin);
						System.out.println("futureSW: "+futureSW.get());
					}

					if(futureSE.get() <= 190 && futureSE.get() >= 170) {}
					else {
						Robot.SEdegree = 180; 
						futureSE = executorService.submit(this::SESpin);
						System.out.println("futureSE: "+futureSE.get());
					}
				} catch (InterruptedException | ExecutionException e) { e.printStackTrace(); }
				}
				if(futureReset) {
					Robot.NWdegree = 180; 
					futureNW = executorService.submit(this::NWSpin);
					Robot.NEdegree = 180; 
					futureNE = executorService.submit(this::NESpin);
					Robot.SWdegree = 180; 
					futureSW = executorService.submit(this::SWSpin);
					Robot.SEdegree = 180; 
					futureSE = executorService.submit(this::SESpin);
					System.out.println("It made it here!!!!!");
					futureReset = false; 
				}
				fix = false; 
				break; 
			
		
		}
		
		
		if(fix) {Robot.CorrectYourself();}
	}
	/*
	Future future2 = executorService.submit(new Runnable() {
	    public void run() {
	        System.out.println("Asynchronous task");
	    }
	});
	
	Future future3 = executorService.submit(new Runnable() {
	    public void run() {
	        System.out.println("Asynchronous task");
	    }
	});
	*/

	public double NWSpin() {
		double degrees = Robot.NWdegree; 
		double Phi = Robot.NWAngle(); 
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
		
		
		return Phi; 
	}

	public double NESpin(){
		double degrees = Robot.NEdegree; 
		double Phi = Robot.NEAngle(); 
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
		
		return Phi;
		
	}
	

	public double SWSpin(){
		double degrees = Robot.SWdegree; 
		double Phi = Robot.SWAngle();
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
		
		return Phi; 
	}

	public double SESpin(){
		double degrees = Robot.SEdegree; 
		double Phi = Robot.SEAngle(); 
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
		
		
		return Phi; 
	}

	public double InitialSpin() {
		System.out.println("GOT HERE!!");
		return 0; 
	}
	
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}
}
