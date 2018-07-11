package org.usfirst.frc.team7327.robot;

import org.usfirst.frc.team7327;

public class TankDrive extends Command ()
		
		public TankDrive() {
			required(Robot.drivetrain);
		}
		
		XboxController Player1 = Robot.oi.Controller0;
		
		protected void initialize() {
			
		}
		protected void execute ()_ {
	if(Robot.oi.getAButton(Player1)) {
}
	
	if(Robot.oi.getRightTrigger(Player1) == 1) {
		Robot.TurnRight();
	}
}
}

protected boolean isFinished() {
	
	return false;
}

protected void interrupted() {
	end();
}
}
}
