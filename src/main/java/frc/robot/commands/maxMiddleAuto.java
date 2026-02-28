package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANClimbSubystem;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;
import static frc.robot.Constants.OperatorConstants.*;
public class maxMiddleAuto extends SequentialCommandGroup{
//right, left, middle with/without climb
//drive13.35ft
    public maxMiddleAuto(CANDriveSubsystem driveSubsystem, CANFuelSubsystem fuelSubsystem, CANClimbSubystem climbSubsystem){
        //test
        addCommands(new AutoDrive(driveSubsystem, -AUTONOMOUS_MOVESPEED, 0).withTimeout(0.27),
        //drive backwards to shoot
            //new AutoDrive(driveSubsystem, 0, 0).withTimeout(10),
            new LaunchSequence(fuelSubsystem).withTimeout(8),
        //shoot 8 loaded balls for 8 seconds
            new AutoDrive(driveSubsystem, -AUTONOMOUS_MOVESPEED, 0).withTimeout(0.27),
            new AutoDrive(driveSubsystem, 0, 0).withTimeout(1),
        //drive backwards for 2 seconds
         new AutoDrive(driveSubsystem, 0, AUTONOMOUS_ROTATIONSPEED).withTimeout(0.5),
         new AutoDrive(driveSubsystem, 0, 0).withTimeout(1),

         //turn 90 degrees?
        new AutoDrive(driveSubsystem, AUTONOMOUS_MOVESPEED, 0).withTimeout(0.15),
        new AutoDrive(driveSubsystem, 0, 0).withTimeout(1),

        //drive tower width raduis
        new AutoDrive(driveSubsystem, 0, AUTONOMOUS_ROTATIONSPEED).withTimeout(0.5),
        new AutoDrive(driveSubsystem, 0, 0).withTimeout(1),
        //turn 90 degrees?
        new ToggleClimber(climbSubsystem)
        //Climb left tower pertruding bar
        );
    }
}