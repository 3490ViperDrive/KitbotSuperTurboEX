package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANClimbSubystem;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

public class LeftSideAuto extends SequentialCommandGroup{




    public LeftSideAuto(CANDriveSubsystem driveSubsystem, CANFuelSubsystem fuelSubsystem, CANClimbSubystem climbSubsystem){
        addCommands(
            new AutoDrive(driveSubsystem, 1, 0.3).withTimeout(1), //Drive forward and turn slightly
            new LaunchSequence(fuelSubsystem).withTimeout(3), //Shoot for 3 seconds
            new AutoDrive(driveSubsystem, -1, -0.3 ) //Go back
        );
    }
}
