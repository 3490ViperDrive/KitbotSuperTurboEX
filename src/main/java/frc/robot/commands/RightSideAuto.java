package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANClimbSubystem;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

public class RightSideAuto extends SequentialCommandGroup{




    public RightSideAuto(CANDriveSubsystem driveSubsystem, CANFuelSubsystem fuelSubsystem, CANClimbSubystem climbSubsystem){
        addCommands(
           new AutoDrive(driveSubsystem, 0, -0.25).withTimeout(0.5), //Rotates robot for 0.5 seconds
           new AutoDrive(driveSubsystem, 1, 0).withTimeout(2), //moves robot for 2 seconds
           new LaunchSequence(fuelSubsystem).withTimeout(4), //shoots fuel for 4 seconds
           new AutoDrive(driveSubsystem, 0, -0.75).withTimeout(.5), //rotates robot for 0.5 seconds
           new AutoDrive(driveSubsystem, 1, 0).withTimeout(2), // moves robot for 2 seconds
           new ToggleClimber(climbSubsystem), // lifts climber up
           new AutoDrive(driveSubsystem, 1, 0).withTimeout(1), // moves robot towards tower for 1 second
           new RetractSolenoid(climbSubsystem) // pull robot up onto tower by lowering climber down
        );
    }
}
