
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANClimbSubystem;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

import static frc.robot.Constants.AutoConstants.BASE_TIME;

public class MiddleAuto extends SequentialCommandGroup{




    public MiddleAuto(CANDriveSubsystem driveSubsystem, CANFuelSubsystem fuelSubsystem, CANClimbSubystem climbSubsystem){
        addCommands(
          new AutoDrive(driveSubsystem, 1, 0).withTimeout(BASE_TIME * 2), // moves robot for 2 seconds
          new LaunchSequence(fuelSubsystem).withTimeout(BASE_TIME * 4), // shoots fuel for 4 seconds
          new AutoDrive(driveSubsystem, 0, 1).withTimeout(BASE_TIME * 0.5),//rotates robot 180 degrees for 0.5 seconds
          new AutoDrive(driveSubsystem, 1, 0).withTimeout(BASE_TIME * 2),//moves robot for 2 seconds towards tower
          new ToggleClimber(climbSubsystem),//lifts climber up
          new AutoDrive(driveSubsystem, 1, 0).withTimeout(BASE_TIME), //moves robot towards tower for 1 second
          new RetractSolenoid(climbSubsystem) // pull robot up onto tower by lowering climber down
        );
    }
}
