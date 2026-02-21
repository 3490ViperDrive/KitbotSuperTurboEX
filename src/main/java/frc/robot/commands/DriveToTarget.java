package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANDriveSubsystem;
import edu.wpi.first.math.geometry.Pose2d;
//import frc.robot.subsystems.CANDriveSubsystem;
public class DriveToTarget extends Command{
    /**
     * Moves the drivetrain to a pre-specified position on the field. 
     */
    public class DriveToSpot extends Command{
        Pose2d targetSpot;
    
        public DriveToSpot(Pose2d whereTo, CANDriveSubsystem driveSubsystem){
        addRequirements(driveSubsystem);
        }
    
        //TODO in init/execute, use a PID loop to move chassis towards "targetSpot";
    
    }
}
