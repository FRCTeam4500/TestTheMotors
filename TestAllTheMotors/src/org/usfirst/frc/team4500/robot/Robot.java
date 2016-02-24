
package org.usfirst.frc.team4500.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser; 
    Compressor c;
    Joystick joy;
    Joystick joy2;
    boolean tank;
    boolean grabber;
    DoubleSolenoid tankPnu;
    DoubleSolenoid grabberPnu;
    RobotDrive drive;
    Victor six;
    Victor zero, one, four, five, seven, eight;
    Talon two, three;
    boolean getter = true;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
        //zero = new Talon(0);
        //one = new Talon(1);
        //two = new Talon(2);
        //three = new Talon(3);
        four = new Victor(4);
        five = new Victor(5);
        six = new Victor(6);
        //seven = new Talon(7);
        //eight = new Talon(8);
        c = new Compressor(0);
        joy = new Joystick(0);
        joy2 = new Joystick(1);
        tank = joy.getTrigger();
        grabber = joy.getRawButton(2);
        tankPnu = new DoubleSolenoid(0,1);
        grabberPnu = new DoubleSolenoid(2,3);
        //drive = new RobotDrive(zero, one);
        
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    	switch(autoSelected) {
    	case customAuto:
        //Put custom auto code here   
            break;
    	case defaultAuto:
    	default:
    	//Put default auto code here
            break;
    	}
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //This is simply an infinitely repeating while loop which sets each motor to 30% speed.
    	//Each motor is named the number of the port that it is in.
    	//The code is all there, it's just commented out.
    	//Someone needs to test each motor, one by one, by simply un-commenting (deleting the //)
    	//each line that's inside of the while loop below one by one, and then deploying that code to the robot
    	//and enabling it.
    	//!!!!!!!NOTE: THE MOTOR THAT ROTATES THE LAZY SUSAN WILL CAUSE THE LAZY SUZAN TO DERAIL AND PULL OUT ALL THE WIRES
    	//IF YOU LET IT KEEP ROTATING TOO LONG. START THE CANNON OUT FACING STRAIGHT FORWARD SO THAT THERE IS AS MUCH TRACK AS 
    	//POSSIBLE ON EITHER SIDE OF THE GEAR ATTACHED TO THE MOTOR.!!!!!!!!!!!
    	//Record which motor each line of code activates, i.e. write down "zero: left tank, one: right tank, etc..."
    	//in a comment on the Trello card.
    	//If a motor doesn't run, write that down too.
    	//Some of the motors may not be hooked up to anything, so it may be difficult to tell if they are running.
    	//Once all nine motors have been tested, it's time to try to get the ones that didn't run working,
    	//it's probably an issue with the wiring.
    	//Make sure the Trello card is up to date at the end of the day.
        tank = joy.getTrigger();
        grabber = joy.getRawButton(2);
        //drive.tankDrive(joy.getY(), joy2.getY());
    	c.start();
    	double speed = .3;
    	//.set(joy.getZ());
    	four.set(joy.getZ());
    	//two.set(joy.getX());
    	if (tank) {
    		//if (getter) {
    			//if (tankPnu.get()== Value.kForward){
    			tankPnu.set(Value.kReverse);
    			//getter = false;
    			}
    			else{
    			tankPnu.set(Value.kForward);
    			//getter = false;
    			}
    			
    		//} else {
    			//getter=true;
    		//}
    		//if (getter) {
    		
        		//getter = false;
    	//} else {
    		
    		//tankPnu.set(Value.kReverse);
    		//getter = true; 
    	//}
    	
    	if (grabber) {
    		grabberPnu.set(Value.kForward);
    	} else {
    		grabberPnu.set(Value.kReverse);
    	}
        	//zero.set(speed);
        	//one.set(-speed);
        	//two.set(speed);
        	//three.set(speed);
        	//four.set(speed);
        	//five.set(speed);
    		//six.set(speed);
    		//seven.set(speed);
    		//eight.set(speed);
       }
    
    
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
