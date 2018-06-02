package org.usfirst.frc.team7327.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class UltrasonicSensor {
	AnalogInput AI;

	public UltrasonicSensor(int port) {
		AI = new AnalogInput(port); 
	}

	public double GetRangeMM() {
		double output = 0;
		output = AI.getVoltage();
		output = output/1024*1000; 
		//output = output / 0.977;
		return output;
	}

	public double GetRangeInches() {
		double output = GetRangeMM();
		output = output * 25.4;
		return output;
	}

	public double GetVoltage() {
		return AI.getVoltage();
	}
}
