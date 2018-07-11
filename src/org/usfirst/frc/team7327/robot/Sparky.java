package org.usfirst.frc.team7327.robot;

import java.util.Scanner;

public class Sparky {
	public static boolean Offline = false; 
	
	public static void main(String[] args) {
		Offline = true; 
		//Autonomous.Auto();
		
		Scanner in = new Scanner(System.in);
		double a = 0;
		double b = 0;
		double c = 0;
		int sideSolved = 0;
		
		
		System.out.println("What side are you solving for?");
		System.out.println("Press 1 for side A");
		System.out.println("Press 2 for side B");
		System.out.println("Press 3 for side C");
		
		sideSolved = (int) in.nextDouble();
		
		if(sideSolved == 1) 
			{
				System.out.println("Input B: ");
				b = in.nextDouble();
                System.out.print("Input C: ");
                c = in.nextDouble();
                a = Math.sqrt(Math.pow(c,2) - Math.pow(b,2));
                System.out.print("A = ");
                System.out.print(a);
			}
			
		if(sideSolved == 2) 
			{
				System.out.println("Input A: ");
				a = in.nextDouble();
                System.out.print("Input C: ");
                c = in.nextDouble();
                b = Math.sqrt(Math.pow(c,2) - Math.pow(a,2));
                System.out.print("B = ");
                System.out.print(b);
			}
			
		if(sideSolved == 3) 
			{
				System.out.println("Input A: ");
				a = in.nextDouble();
                System.out.print("Input B: ");
                b = in.nextDouble();
                c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
                System.out.print("C = ");
                System.out.print(c);
			}
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
