package org.usfirst.frc.team7327.robot;

public class Sparky {
	public static boolean Offline = false; 
	
	public static void main(String[] args) {
		Offline = true; }
		//Autonomous.Auto(); 

		
		public static boolean IsPrime(int n) {

		    if (n > 2 && n %2 == 0){
		        return false;
		    }
		    int top = (int)Math.sqrt(n)+1;
		    for (int i=3;i<top;i+=2){
		        if (n%i==0){
		            return false;
		        }
		    }
		    return true;
		
		
		System.out.println("Enter number to get prime number");
	    int n = new Scanner(System.in).nextInt();
	        for (int j=0;j<n;j++){
	            if (IsPrime(j)){
	                System.out.print(j + " ");
	            }
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
