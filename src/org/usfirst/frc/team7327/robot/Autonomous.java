package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;


	public class Autonomous 
	{
		
		DoubleSolenoid.Value Puncher = DoubleSolenoid.Value.kOff;
		DoubleSolenoid.Value Hands =  DoubleSolenoid.Value.kOff;
		double throttleX = 0.30;
		
		public void Auto() 
		{
			//While Loops
				//Group0.WhileLoops();
			
			//1 while loop and if command
				//Group0.OneWhile();
			
			//switch
				//Group0.Switch(2);
			
			//Time if and if else
				//Group0.TimedIfElse();
			while(true) 
			{
				
				double timer = Robot.myTimer.get();
				
				
				if (timer < 5)
				{
					Puncher = DoubleSolenoid.Value.kReverse;
					Robot.drivetrain.setPunchers(Puncher);
					Robot.drivetrain.setRaw1(.25, .25);
				} 
				else if (timer < 10)
				{
					Robot.drivetrain.setRaw1(0, 0);
					Robot.drivetrain.setRawSpinner(.3,-.3);
				} 
				else if (timer < 15)
				{
					Robot.drivetrain.setRawSpinner(0,0);
					Hands = DoubleSolenoid.Value.kForward;
					Robot.drivetrain.setRawGrabber(Hands);
				}
				else if (timer < 20)
				{
					Robot.drivetrain.setRawArm(1*throttleX);
				}
				else if (timer < 25)
				{
					Puncher = DoubleSolenoid.Value.kReverse;
					Robot.drivetrain.setPunchers(Puncher);
				}
				else 
				{
					Robot.drivetrain.setRaw1(0, 0);
				}
			}
			
		}
	}
	

	


