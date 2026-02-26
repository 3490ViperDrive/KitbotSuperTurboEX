package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANClimbSubystem;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

import static frc.robot.Constants.AutoConstants.BASE_TIME;;

public class TestAuto extends SequentialCommandGroup{


public TestAuto(CANDriveSubsystem driveSubsystem, CANFuelSubsystem fuelSubsystem, CANClimbSubystem climbSubsystem){
    addCommands(
       new AutoDrive(driveSubsystem, 1, 0).withTimeout(BASE_TIME), //Moves robot for 1 second
       new AutoDrive(driveSubsystem, 0, 0.5).withTimeout(BASE_TIME), //Rotates for 1 second
       new LaunchSequence(fuelSubsystem).withTimeout(BASE_TIME * 5) //Shoots fuel for 5 seconds
    );
    }
}