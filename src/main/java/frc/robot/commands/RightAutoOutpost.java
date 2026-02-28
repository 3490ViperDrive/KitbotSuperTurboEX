package frc.robot.commands;

import static frc.robot.Constants.AutoConstants.BASE_TIME;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANClimbSubystem;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

public class RightAutoOutpost extends SequentialCommandGroup{

    public RightAutoOutpost(CANDriveSubsystem driveSubsystem, CANFuelSubsystem fuelSubsystem, CANClimbSubystem climbSubsystem){
        addCommands(
            new AutoDrive(driveSubsystem,0,0.675).withTimeout(BASE_TIME* 1),
            new AutoDrive(driveSubsystem,-1,0).withTimeout(BASE_TIME* 0.8),
            new AutoDrive(driveSubsystem,0,0).withTimeout(BASE_TIME* 3),
            new AutoDrive(driveSubsystem,1,0).withTimeout(BASE_TIME* 0.4),
            new AutoDrive(driveSubsystem,0,0.675).withTimeout(BASE_TIME* 0.5),
            new LaunchSequence(fuelSubsystem).withTimeout(BASE_TIME* 8));
    }
            };

