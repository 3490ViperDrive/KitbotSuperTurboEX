package frc.robot.commands;

import static frc.robot.Constants.OperatorConstants.*;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANDriveSubsystem;

public class Bruh extends SequentialCommandGroup{

    CANDriveSubsystem dt;
    
    public Bruh(CANDriveSubsystem dt){
        addCommands(
            new FlipDT(dt),
            new AutoDrive(dt, AUTONOMOUS_MOVESPEED, 0).withTimeout(0.25),
            new AutoDrive(dt, 0, 0.675).withTimeout(1));
    }
}
