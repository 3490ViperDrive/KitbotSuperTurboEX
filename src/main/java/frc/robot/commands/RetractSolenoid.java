package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANClimbSubystem;

public class RetractSolenoid extends Command{

    //This shouldn't have to live in its own Command, but it worked so we'll take it, for now
    CANClimbSubystem mSubsystem;
    public RetractSolenoid(CANClimbSubystem subsystem){
        mSubsystem = subsystem;
        addRequirements(subsystem);
    }

    public void execute(){
        mSubsystem.retractSolenoid();
    }
}
