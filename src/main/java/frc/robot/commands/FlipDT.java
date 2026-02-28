package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANDriveSubsystem;

public class FlipDT extends Command{
    CANDriveSubsystem dt;

    public FlipDT(CANDriveSubsystem _dt){
        dt = _dt;
        addRequirements(dt);
    }

    @Override
    public void execute(){
        if(dt.isFlipped == false){
            dt.toggleFlip();
        }
        //dt.toggleFlip();
    }

    public boolean isFinished(){
        return true;
    }
}
