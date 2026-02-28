package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANClimbSubystem;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

import static frc.robot.Constants.AutoConstants.BASE_TIME;

public class LeftAutoNoClimb extends SequentialCommandGroup{




    public LeftAutoNoClimb(CANDriveSubsystem driveSubsystem, CANFuelSubsystem fuelSubsystem, CANClimbSubystem climbSubsystem){
        addCommands(
            new AutoDrive(driveSubsystem, 0, 0.25).withTimeout( BASE_TIME * 0.5), //Rotates robot for 0.5 seconds
           new AutoDrive(driveSubsystem, 1, 0).withTimeout(BASE_TIME* 2), //moves robot for 2 seconds
           new LaunchSequence(fuelSubsystem).withTimeout(BASE_TIME * 4), //shoots fuel for 4 seconds
           new AutoDrive(driveSubsystem, 0, -0.25).withTimeout(BASE_TIME * 0.5), //rotates robot for 0.5 seconds
           new AutoDrive(driveSubsystem, 1, 0).withTimeout(BASE_TIME * 2) // moves robot back to origin in 2 seconds
        
        );
    }
}
