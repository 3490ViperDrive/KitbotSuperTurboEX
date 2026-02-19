package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANClimbSubystem;
import frc.robot.subsystems.CANDriveSubsystem;

public class RetractSolenoid extends Command{
    CANClimbSubystem subsystem;

    public RetractSolenoid(CANClimbSubystem it){
        subsystem = it;
        addRequirements(subsystem);
    }

    public void execute(){
        subsystem.retractSolenoid();
    }
}
