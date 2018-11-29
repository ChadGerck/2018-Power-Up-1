package org.usfirst.frc.team7327.robot;

public class Sparky {
	public static boolean Offline = false; 
	
	public static void main(String[] args) throws InterruptedException {
		Offline = true; 
		//Autonomous.Auto(); 
		
		int i = 0;
		while(i <= 4) {
			System.out.println("Hello Chad!");
			++i;
		}
		
	}
	