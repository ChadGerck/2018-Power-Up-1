package org.usfirst.frc.team7327.robot;
import java.util.Scanner;

public class Sparky {
	public static boolean Offline = false; 
	
	public static void main(String[] args) {
		Offline = true; 
		// Autonomous.Auto();
/*int[] array;
array = new int[10];
array[0] = 1;
array[1] = 2;
array[2] = 3;
array[3] = 4;
array[4] = 5;
array[5] = 6; 
array[6] = 7; 
array[7] = 8;
array[8] = 9;
array[9] = 10;

		for (int i = 0; i < 10;) {
			System.out.println("Value of i: " + array[i]);
			i++;
		}*/
		String[] days = new String[7];
	days[0] = "Monday";
	days[1] = "Tuesday";
	days[2] = "Wednesday";
	days[3] = "Thursday!";
	days[4] = "Friday";
	days[5] = "Saturday";
	days[6] = "Sunday";
		Scanner date = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter Today's Date: ");
		String numDate = date.next();
			if (numDate.contains("7/11/18")) {
				System.out.println("Today is: " + days[2]);
			  }
			else if (numDate.contains("7/13/18")) {
				System.out.println("Today is: " + days[4]);
			}
			else if (numDate.contains("7/14/18")) {
				System.out.println("Today is: " + days[5]);
			}
			else {
				System.out.println("FOLLOW THE FORMAT BUD. . .");
			}
		//once finished
		date.close();
		
		
		
		
		
		
		System.out.println("");
		System.out.println("Done by: ");
		System.out.println("");
		System.out.println("     _/_/_/    _/_/    _/   _/_/_/   _/_/_/_/   _/        ++           ++        ");
		System.out.println("    _/   _/   _/ _/   _/  _/        _/         _/         ++           ++		 ");
		System.out.println("   _/   _/   _/  _/  _/  _/        _/         _/      +++++++++++  +++++++++++   ");
		System.out.println("  _/_/__/   _/   _/ _/   _/_/__/  _/_/_/_/   _/           ++           ++		 ");
 		System.out.println(" _/   _/   _/    _/_/        _/  _/         _/            ++           ++		 ");
		System.out.println("_/   _/   _/      _/    _/_/_/  _/_/_/_/   _/_/_/_/							     ");
		
	}
	public static void MoveForward() {
		System.out.println("Move robot forward 1 space");
		if(!Offline) { Robot.MoveDistance(Robot.GyroAngle(), .3, 1); }
	}
	public static void TurnRight() {
		System.out.println("Turn Right");
		if(!Offline) { Robot.TurnRight(); }
	}
	public static void TurnLeft() {
		System.out.println("Turn Left");
		if(!Offline) { Robot.TurnLeft(); }
	}
}

