package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANClimbSubystem;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

public class AutoLeftShootClimb extends SequentialCommandGroup {
    public AutoLeftShootClimb(CANDriveSubsystem driveSubsystem, CANFuelSubsystem fuelSystem, CANClimbSubystem climbSubystem) {
        addCommands(
        new AutoDrive(driveSubsystem, 0, 1).withTimeout(0.75),
        // turns right for .75 secconds
        new AutoDrive(driveSubsystem, 1,0).withTimeout(1),
        // moves forward for 1 seccond
        new AutoDrive(driveSubsystem, 0, -1).withTimeout(0.75),
        // turns right for .75 secconds to face the hub
        new Launch(fuelSystem).withTimeout(10),
        //shoots for 10 secconds
        new AutoDrive(driveSubsystem, 1,0).withTimeout(1),
        //goes towards the ladder for 1 seccond
        new ToggleClimber(climbSubystem));
        //Climb
    }
}
