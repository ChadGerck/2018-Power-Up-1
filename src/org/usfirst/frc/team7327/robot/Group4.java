import org.usfirst.frc.team7327.robot.Robot;

public class Group4 {
	public static void Project2() {
		// while loops

		int i = 0;
		while (i < 26) {

			Robot.MoveForward();
			i = i + 1;
		}

		 {

			Robot.TurnRight();
			Robot.TurnRight();
			

		}

	}

	public static void Project3() {

		// 1 while loop and if command

		int i = 0;
		while (i < 52) {
			Robot.MoveForward();
			i = i + 1;

			if (i == 25) {
				Robot.TurnRight();
				Robot.TurnRight();
			}

		}

		Robot.TurnRight();
		Robot.TurnRight();

	}

	public static void Project4() {

		// switch
		int station = 2;
		switch(station){
		case 1: 
			while (i < 25){ 
					Robot.MoveForward();
					i = i +1; 
			break; }
		case 2:
			Robot.TurnLeft();
			Robot.TurnLeft();
			Robot.TurnLeft();
			
		}
		
		}
		

	}
}

	public static void Project5() {
		
		//timed if, else if, else 
		if (timer < 15);
		Robot.MoveForward();
		
		
	}
}







