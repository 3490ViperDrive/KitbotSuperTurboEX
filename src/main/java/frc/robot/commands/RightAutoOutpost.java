package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANClimbSubystem;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

public class RightAutoOutpost extends SequentialCommandGroup{

    public RightAutoOutpost(CANDriveSubsystem driveSubsystem, CANFuelSubsystem fuelSubsystem, CANClimbSubystem climbSubsystem){

        addCommands(
            //NOTE 0.1 AutoDrives are for testing until brake mode feature is implemented for drifting. This may or may not be solved by comp?
            new AutoDrive(driveSubsystem, -1, 0).withTimeout(0.8),
            new AutoDrive(driveSubsystem, -0.1, 0).withTimeout(0.5),
            //Drives backwards for outpost for 0.8 seconds
            new AutoDrive(driveSubsystem, 1, 0).withTimeout(0.8),
            new AutoDrive(driveSubsystem, 0.1, 0).withTimeout(0.5),
            //Drives foward for 0.8 seconds - original location -
            new AutoDrive(driveSubsystem, 0, -0.675).withTimeout(0.5),
            new AutoDrive(driveSubsystem, 0, -0.1).withTimeout(0.5),
            //Turns counterclockwise-left for 0.5 second
            new AutoDrive(driveSubsystem, 1, 0).withTimeout(2),
            new AutoDrive(driveSubsystem, 0.1, 0).withTimeout(0.5),
            //Drive foward for 2 seconds towards hub
            new AutoDrive(driveSubsystem, 0, 0.675).withTimeout(0.5),
            new AutoDrive(driveSubsystem, 0, 0.1).withTimeout(0.5),
            //Turn clockwise-right for 0.5 a second
            new AutoDrive(driveSubsystem, -1, 0).withTimeout(0.25),
            new AutoDrive(driveSubsystem, -0.1, 0).withTimeout(0.5),
            //Drives backward for 0.25 seconds so balls dont over shoot?
            new LaunchSequence(fuelSubsystem).withTimeout(5));
            //shoots loaded balls into hub for 5 seconds
    }
    }
