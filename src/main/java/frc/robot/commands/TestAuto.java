package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANClimbSubystem;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

public class TestAuto extends SequentialCommandGroup{




    public TestAuto(CANDriveSubsystem driveSubsystem, CANFuelSubsystem fuelSubsystem, CANClimbSubystem climbSubsystem){
        addCommands(
            new AutoDrive(driveSubsystem, 1, 0).withTimeout(1),
            new AutoDrive(driveSubsystem, 0, 1).withTimeout(1),
            new LaunchSequence(fuelSubsystem).withTimeout(5)
        );
    }
}
