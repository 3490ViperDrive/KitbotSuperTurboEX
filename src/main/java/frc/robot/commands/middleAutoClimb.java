package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANClimbSubystem;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;
import static frc.robot.Constants.OperatorConstants.*;
public class middleAutoClimb extends SequentialCommandGroup{
//right, left, middle with/without climb
//drive13.35ft
    public middleAutoClimb(CANDriveSubsystem driveSubsystem, CANFuelSubsystem fuelSubsystem, CANClimbSubystem climbSubsystem){
        //test
        addCommands(new AutoDrive(driveSubsystem, -AUTONOMOUS_MOVESPEED, 0).withTimeout(0.27),
        new AutoDrive(driveSubsystem, -0.1, 0).withTimeout(.5),
        //drive backwards approximately a meter to shoot
        new LaunchSequence(fuelSubsystem).withTimeout(4),
        //shoot loaded fuel into hub
        new AutoDrive(driveSubsystem, -AUTONOMOUS_MOVESPEED, 0).withTimeout(0.27),
        new AutoDrive(driveSubsystem, -0.1, 0).withTimeout(.5),
        //drive backwards near tower
        new AutoDrive(driveSubsystem, 0, AUTONOMOUS_ROTATIONSPEED).withTimeout(0.2),
        new AutoDrive(driveSubsystem, 0, 0.1).withTimeout(.5),
         //turn approximately 90 degrees
        new AutoDrive(driveSubsystem, AUTONOMOUS_MOVESPEED, 0).withTimeout(0.15),
        new AutoDrive(driveSubsystem, 0.1, 0).withTimeout(.5),
        //drive tower width raduis
        new AutoDrive(driveSubsystem, 0, AUTONOMOUS_ROTATIONSPEED).withTimeout(0.5),
        new AutoDrive(driveSubsystem, 0, 0.1).withTimeout(.5),
        //turn 90 degrees?
        new ToggleClimber(climbSubsystem)
        //Climb left tower pertruding bar
        );
    }
}