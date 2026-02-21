package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.CANClimbSubsystem;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

public class UniversalAutoRoutine extends SequentialCommandGroup{
//This command won't work until PhotonVision is set up for kitbot.
//Note the Climb command doesnt exist yet and will have to be added
//The DriveToTarget command isn't populated and therefore wont do anything
public int cancel = 0;
public UniversalAutoRoutine(CANDriveSubsystem driveSubsystem, CANFuelSubsystem fuelSubsystem, CANClimbSubsystem climbSubsystem){
if (RobotContainer.climbEnabled == false){
addCommands(new DriveToTarget(), new LaunchSequence(fuelSubsystem), new climb(climbSubsystem));
}
if (RobotContainer.shootEnabled == false){
addCommands(new DriveToTarget(), new LaunchSequence(fuelSubsystem), new climb(climbSubsystem));
}
//Bad working to move if statements to cancel commands in the group if toggled in elastic
addCommands(new DriveToTarget(), new LaunchSequence(fuelSubsystem), new climb(climbSubsystem));
}
}
