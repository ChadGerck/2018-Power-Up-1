package org.usfirst.frc.team7327.robot;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnModule{
    private Notifier TurningPID; 
    private double error, sumError, diffError, lastError;
    private double PIDOutput;
    private double gyroTo; 
    private boolean on; 
    
    public TurnModule(double kP, double kI, double kD) {
    	sumError = 0; 
    	lastError = getError(); 
    	error = lastError; 
    	TurningPID = new Notifier(() ->  {
    		SmartDashboard.putNumber("gyroTo: ", gyroTo);
    		SmartDashboard.putNumber("GyroAngle: ", Robot.GyroAngle());
    		error = getError(); 
    		diffError = lastError - getError(); 
    		sumError += getError(); 
    		PIDOutput = kP * getError() + kI * sumError + kD * diffError; 
    		if(on) Robot.drivetrain.setAllSpeed(PIDOutput);
            lastError = error;
    	}); 
    	TurningPID.startPeriodic(0.01);
    	
    }

    public double getError(){
    	double gyroFinal = gyroTo - Robot.GyroAngle(); 
    	if(gyroFinal <= 0 ) gyroFinal += 360; 
        return Math.sin(Math.toRadians(gyroFinal));
    }
    
    public void setYaw(double degree){ gyroTo = degree; }
    
    public boolean setOn(boolean flipOn) { 
    	on = flipOn; 
    	return on; 
    }

}