import org.usfirst.frc.team7327.robot.Robot;

public class Group5 {
	public static void Project2() {
		int a = 0;
		while (a <= 25) {
			Robot.MoveForward();
			a++;
		}
		a = 0;
		while (a < 2) {
			Robot.TurnRight();
			a++;
		}
		a = 0;
		while (a <= 25) {
			Robot.MoveForward();
			a++;
		}
		a = 0;
		while (a < 2) {
			Robot.TurnRight();
			a++;
		}
	}

	public static void Project3() {

		int b = 0;
		while (b < 52)
			Robot.MoveForward();
		b++;
		if (b == 26 || b == 52) {
			Robot.TurnRight();
			Robot.TurnRight();

		}

	}

	public static void Project4() {
		int c = 1;
		switch (c) {
		case 1:
			Robot.MoveForward();
			break;

		case 2:
			Robot.TurnRight();
			break;

		}
		c++;
	}

	public static void Project5() {
		
		double timer = Robot.myTimer.get();
		
		if(timer<2) {
			Robot.drivetrain.setRaw1( 0.20, 0.20);
		}
		else if(timer<4) {
			Robot.drivetrain.setRaw1( 0.45, 0.45);
		}
		else if(timer<6){
			Robot.drivetrain.setRaw1( 0.55, 0.55);
		}
		else if(timer<8) {
			Robot.drivetrain.setRaw1( 0.45, 0.45);
		}
		else if(timer<10) {
			Robot.drivetrain.setRaw1( 0.20, 0.20);
		}
		else {
				
		}
	}
}


// Hi guys its me
