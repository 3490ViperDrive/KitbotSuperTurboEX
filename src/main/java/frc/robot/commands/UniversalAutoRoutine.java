package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANClimbSubystem;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;
import static frc.robot.RobotContainer.*;

public class UniversalAutoRoutine extends SequentialCommandGroup {
    public int cancel = 0;
    public UniversalAutoRoutine(CANDriveSubsystem driveSubsystem, CANFuelSubsystem fuelSubsystem,
            CANClimbSubystem climbSubsystem) {
            addCommands(new DriveToTarget());
        switch (autoHolder1) {
            case "climbEnabled":
            addCommands(new ClimbSequence(climbSubsystem));
            case "shootEnabled":
            addCommands(new LaunchSequence(fuelSubsystem));
            case "none":
            break;
        }
        switch (autoHolder2) {
            case "climbEnabled":
            addCommands(new ClimbSequence(climbSubsystem));
            case "shootEnabled":
            addCommands(new LaunchSequence(fuelSubsystem));
            case "none":
            break;
        }
}
    // This command won't work until PhotonVision is set up for kitbot.
    // Note the Climb command doesnt exist yet and will have to be added
    // The DriveToTarget command isn't populated and therefore wont do anything
}

