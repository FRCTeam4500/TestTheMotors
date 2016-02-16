
package org.usfirst.frc.team4500.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
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
    
    Victor zero, one, four, five, six, seven, eight;
    Jaguar two, three;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
        zero = new Victor(0);
        one = new Victor(1);
        two = new Jaguar(2);
        three = new Jaguar(3);
        four = new Victor(4);
        five = new Victor(5);
        six = new Victor(6);
        seven = new Victor(7);
        eight = new Victor(8);
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
    	
    	double speed = .3;
    	while(true) {
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
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
