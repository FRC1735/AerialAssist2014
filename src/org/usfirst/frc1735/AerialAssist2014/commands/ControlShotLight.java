// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc1735.AerialAssist2014.commands;
//import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1735.AerialAssist2014.Robot;
import org.usfirst.frc1735.AerialAssist2014.RobotMap;
/**
 *
 */
public class  ControlShotLight extends Command {
    // Pointer to DriverStation user message window
    //DriverStationLCD m_DS = DriverStationLCD.getInstance();
    public ControlShotLight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
            
        // Very simple.  If in range, turn light on.  Otherwise, turn it off...
        if (Robot.range.inShotRange())
            Robot.range.shotLightEnable(true);
        else
            Robot.range.shotLightEnable(false);
        
        // This does the actual update to the DriverStation LCD
        // (rather than multiple updates for distance and range that are queued up in the above function calls)
        //m_DS.updateLCD();
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; // This command runs forever.
    }
    // Called once after isFinished returns true
    protected void end() {
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
