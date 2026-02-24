package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANClimbSubystem;

public class ClimbSequence extends SequentialCommandGroup{
public ClimbSequence(CANClimbSubystem rootBeer){
addRequirements(rootBeer);
addCommands(new ToggleClimber(rootBeer).withTimeout(0.5), new RetractSolenoid(rootBeer));
}
}
