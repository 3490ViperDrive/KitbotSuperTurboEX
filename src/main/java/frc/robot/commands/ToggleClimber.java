package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANClimbSubystem;

public class ToggleClimber extends Command{
    
    public CANClimbSubystem climberSubsystem;

    public ToggleClimber(CANClimbSubystem climber){
        climberSubsystem = climber;
        addRequirements(climberSubsystem);
    }

    @Override
    public void execute(){
        climberSubsystem.toggleSolenoid();
    }
}
