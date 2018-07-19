package org.usfirst.frc.team7327.robot;

public class Encoders {
	// I already created the encoders, Here is how you can call the distance on
	// each encoder.
	// Measured by feet
	static double distanceL = Robot.encoderL.getDistance();
	static double distanceR = Robot.encoderR.getDistance();
	
	
	public static void moveForward(int distance) 
	{
		while (((distanceL+distanceR)/2)<distance)
		{
			Robot.drivetrain.setRaw1(.3, .3);
		}
	}
	public static void moveReverse(int distance)
	{
		while (((distanceL+distanceR)/2)<distance)
		{
			Robot.drivetrain.setRaw1(-.3, -.3);
		}
	}}