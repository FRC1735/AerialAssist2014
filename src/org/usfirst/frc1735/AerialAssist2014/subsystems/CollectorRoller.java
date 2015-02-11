// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc1735.AerialAssist2014.subsystems;
import org.usfirst.frc1735.AerialAssist2014.RobotMap;
import org.usfirst.frc1735.AerialAssist2014.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class CollectorRoller extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    Relay rollerMotor = RobotMap.collectorRollerRollerMotor;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
                
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new CollectRollerStop());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void engage(double magnitudeDirection) {
        // Make sure the Spike is configured to run in both directions
        rollerMotor.setDirection(Relay.Direction.kBoth);
        // input arg is signed vlue between +1 and -1 for fwd/backward speed/magnitude.
        // This function ASSUMES that forward == outward is positive (unlike a joystick, which returns negative values for forward!)
        // Input of course does not HAVE to be a joystick-- can be a fixed value if for instance it is called by a button press...
        // If gearing inverts the desired motor direction, *THIS* is the place where it should be inverted...
        //rollerMotor.set(-magnitudeDirection);
        //System.out.print("Roller input = ");
        //System.out.println(magnitudeDirection);
        
        if (magnitudeDirection >0)
            rollerMotor.set(Relay.Value.kForward);
        else if (magnitudeDirection <0)
            rollerMotor.set(Relay.Value.kReverse);
        else rollerMotor.set(Relay.Value.kOff);
        
}
    public void stop() {
        engage(0);
    }
}
