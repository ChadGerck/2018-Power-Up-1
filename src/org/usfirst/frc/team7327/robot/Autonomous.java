package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
		public static void Project5() {
			
			while(true) {
				double timer = Robot.myTimer.get();
				if (timer < 5) {
					Robot.drivetrain.setRaw1(.20, .20);
				} else if (timer < 10) {
					Robot.drivetrain.setRaw1(.25, .25);
				} else if (timer < 15) {
					Robot.drivetrain.setRaw1(.20, .20);
				} else {
					Robot.drivetrain.setRaw1(0, 0);
					break; 
				}
			}
		}
	}

	

	
