package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
//import frc.robot.subsystems.CANClimbSubystem;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

public class RightDepotShoot extends SequentialCommandGroup{
   public RightDepotShoot(CANDriveSubsystem driveSubsystem, CANFuelSubsystem fuelSubsystem, Intake spin){
       addCommands(

new AutoDrive(driveSubsystem, 1, 0).withTimeout(1),//Moves foward from start
new AutoDrive(driveSubsystem, 0, 1).withTimeout(1),//Turns right
new AutoDrive(driveSubsystem, 1, 0).withTimeout(1),//Moves foward towards the tower
new AutoDrive(driveSubsystem, 0, 1).withTimeout(1),//Move roatates to align with the tower
new LaunchSequence(fuelSubsystem).withTimeout(5),//Shoots the starting8 balls in the tower
//hi
/*
Starts up intake motor and heads toward the depot. 
At the depot it moves foward and back and roating to 
maximize the amount of balls being brought in. When 
finished it stops the intake motor. I commentted out to be more simpiler for testing.
*/

new Intake(fuelSubsystem),
new AutoDrive(driveSubsystem, -1, 0).withTimeout(1),
// new AutoDrive(driveSubsystem, 1, 0).withTimeout(1),
// new AutoDrive(driveSubsystem, -1, 0).withTimeout( 1),
// new AutoDrive(driveSubsystem, 1, 0).withTimeout(1),
// new AutoDrive(driveSubsystem, 0, -1).withTimeout(1),
// new AutoDrive(driveSubsystem, -1, 0).withTimeout(1),
// new AutoDrive(driveSubsystem, 0, 1).withTimeout(1),
// new AutoDrive(driveSubsystem, 0, 1).withTimeout(1),
// new AutoDrive(driveSubsystem, -1, 0).withTimeout(1),
// new AutoDrive(driveSubsystem, 0, 1).withTimeout(1),
new Intake(fuelSubsystem),

//Goes back to the tower and shoots the balls.
new AutoDrive(driveSubsystem, 1, 0).withTimeout(1),
new LaunchSequence(fuelSubsystem).withTimeout(6)


//I will work on it IF we getting a working climber

//new ToggleClimber(climbSubsystem),
//new AutoDrive(driveSubsystem, 1, 0).withTimeout(BASE_TIME*0.5),
//new RetractSolenoid(climbSubsystem)
       );
   }
}

