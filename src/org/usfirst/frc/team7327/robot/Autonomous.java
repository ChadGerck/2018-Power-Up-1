package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327.robot.Robot;

public class Autonomous {
	public static void Auto() {
		int i=0;
		
					while(i<52) {
						Robot.MoveForward();
						i++;
						if (i==26|| i==52);
							Robot.TurnRight();
							Robot.TurnRight();
		}
	}
}
	