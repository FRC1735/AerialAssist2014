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
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous1BallByDistance extends CommandGroup {
    
    public  Autonomous1BallByDistance() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        
        // Plan:  Drive until we are X feed away from the wall, deploy Collector, and shoot the ball.
        
        // Reset the gyro so that we have the most accurate driving direction
        addSequential(new ResetGyro());
        // Leaving a time limit in place even for the distance limit in case the range finder malfunctions and we would otherwise just keep going...
        // 1.75 sec gets us 9 feet from back wall; 2.5 should be right at the hairy limit of hitting the wall.
        addSequential(new DriveWithLimits(2.5,9.5)); // args are time and distance-from-wall, whichever comes first.
        // Collector is sequential because we need it to hold the ball while moving
        // This fully deploys the collector to a max limit (the hard stop limit switch, unless we eventually add a string pot to the deploy arm.
        // Also note that we could instead use CollectDeployPastInterlock, if we had a stringpot and enabled this "just get barely out of the way" feature.
        addSequential(new CollectDeployExtend());
        addSequential(new ShootExtend()); // We are out of the way via the previous command.
        addSequential(new ShootRetract());// also retract the shooter when done.

    }
}
