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
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1735.AerialAssist2014.Robot;
import org.usfirst.frc1735.AerialAssist2014.RobotMap;
/**
 *
 */
public class  DriveWithLimits extends Command {
    public DriveWithLimits(double timeLimit, double distanceLimit) {
            this(timeLimit, distanceLimit, 0.45); // default speed is 45%
    }
    
    public DriveWithLimits(double timeLimit, double distanceLimit, double MagnitudeDirection) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        setTimeout(timeLimit);
        
        // This limit is the absolute distance to the wall in feet, NOT a relative distance traveled from starting point!
        m_distanceLimit = distanceLimit;
        m_magnitudeDirection = MagnitudeDirection;
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        m_distanceCounter = 0;
    }
    
    protected void execute() {
        //Drive forwards, but only if we are still too far away from the wall
        // Pre-Southington:
        //Robot.driveTrain.mecanumDriveCartesian(0, m_magnitudeDirection);
        // Post-Southington:
        Robot.driveTrain.tankDrive(-m_magnitudeDirection, m_magnitudeDirection*0.95);
        double currentDistance = Robot.range.getDistance();
        if ((currentDistance <= m_distanceLimit) &&
                (currentDistance > 6)) {
            m_distanceCounter++; // We may be at our distance.  increment counter
        }
        else {
            // we left the zone(or there was a blip previously).  reset counter.
            m_distanceCounter = 0;
        }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // We are done if we hit either limit (time or distance)
        // Note:  distance is absolute from wall, not a relative distance from starting position!
        boolean finished = isTimedOut() || (m_distanceCounter >= 5);
        if (finished) System.out.println("DriveWithLimits command has finished.");
        return finished;
    }
    // Called once after isFinished returns true
    protected void end() {
        Robot.driveTrain.stop();
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
    
    // Variable to hold onto the distance
    double m_distanceLimit;
    
    // Variable to hold the max speed/direction
    double m_magnitudeDirection;
    
    // Counter for additional averaging
    int m_distanceCounter;
}
