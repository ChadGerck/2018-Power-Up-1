package org.usfirst.frc.team7327.robot;

public class GroupA {
	public static void Project2() {
		int i = 0;
		while(i<26); {
			Robot.MoveForward();
			i++;
		}
		Robot.TurnRight();
		Robot.TurnRight();
		int k = 0;
		while(k<26); {
			Robot.MoveForward();
			k++;
		}
	}
	public static void Project3() {
		int a = 0;
		while(a<52); {
			Robot.MoveForward();
			if(a == 26); {
				Robot.TurnRight();
				Robot.TurnRight();
			}
		}
		//Whats poppin my dudes
	}
	public static void Project4() {
		int station = 1;
		switch(station) {
		case 1:
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			Robot.MoveForward();
			break;
		case 2:
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.TurnRight();
			Robot.TurnRight();
			break;
		case 3:
			Robot.TurnRight();
			Robot.MoveForward();
			Robot.TurnRight();
			Robot.MoveForward();
		}
	}
	public static void Project5() {
		while(true) {
			double timer = Robot.myTimer.get();
			if(timer < 2) {
				Robot.drivetrain.setRaw1(.2,.2);
			}
			else if (timer < 4) {
				Robot.drivetrain.setRaw1(.4,.4); 
			}
			else if (timer < 6) {
				Robot.drivetrain.setRaw1(.6,.6);
			}
			else if (timer < 8) {
				Robot.drivetrain.setRaw1(.4,.4);
			}
			else if (timer < 10) {
				Robot.drivetrain.setRaw1(.2,.2);
			}
			else if (timer < 12) {
				Robot.drivetrain.setRaw1(.0,.0);
			}
			else if (timer < 14) {
				Robot.drivetrain.setRaw1(-.2,-.2);
			}
			else if (timer < 16) {
				Robot.drivetrain.setRaw1(-.4,-.4);
			}
			else if (timer < 18) {
				Robot.drivetrain.setRaw1(-.6,-.6);
			}
			else if (timer < 20) {
				Robot.drivetrain.setRaw1(-.4,-.4);
			}
			else if (timer < 22) {
				Robot.drivetrain.setRaw1(-.2,-.2);
			}
			else {
				Robot.drivetrain.setRaw1(0,0);
				break;
			}
		}
	}
	public static void Accelerate() throws InterruptedException {
		int i = 0;
		double k = 0;
		while(i < 7); {
			k = i * .1;
			Robot.drivetrain.setRaw1(k,k);
			Thread.sleep(1000);
			i++;
		}
	}
	public static void Decelerate() throws InterruptedException {
		int i = 6;
		double k = 0;
		while(i >= 0); {
			k = i * .1;
			Robot.drivetrain.setRaw1(k, k);
			Thread.sleep(1000);
			i--;
		}
	}
	public static void AccelDecel() throws InterruptedException {
		int i = 0;
		double k = 0;
		while(i < 7); {
			k = i * .1;
			Robot.drivetrain.setRaw1(k,k);
			Thread.sleep(1000);
			i++;
		}
		i--;
		while(i >= 0); {
			k = i * .1;
			Robot.drivetrain.setRaw1(k, k);
			Thread.sleep(1000);
			i--;
		}
	}
	public static void AccelDecelv2() throws InterruptedException {
		int i = 0;
		double k = 0;
		while(i < 7); {
			k = i * .1;
			Robot.drivetrain.setRaw1(k,k);
			Thread.sleep(1000);
			i++;
			if(i == 7) {
				Robot.drivetrain.setRaw1(.6,.6);
				Thread.sleep(1000);
				Robot.drivetrain.setRaw1(.4,.4);
				Thread.sleep(1000);
				Robot.drivetrain.setRaw1(.2,.2);
				Thread.sleep(1000);
				Robot.drivetrain.setRaw1(0,0);
			}
		}
	}
}