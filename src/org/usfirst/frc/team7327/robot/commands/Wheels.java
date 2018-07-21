package org.usfirst.frc.team7327.robot.commands;

public class Wheels {
	public String Orientation; 
	public int SeedAt; 
	public double error; 
	
	Wheels(String ori, int seed, double e){
		Orientation = ori; 
		SeedAt = seed; 
		error = e; 
	}
	Wheels(double e){
		error = e; 
	}

}
