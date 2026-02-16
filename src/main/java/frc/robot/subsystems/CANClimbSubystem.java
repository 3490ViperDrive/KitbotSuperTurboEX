package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CANClimbSubystem extends SubsystemBase{
    

    private Solenoid climberSolenoid;

    public CANClimbSubystem(){
        //instantiate object using id
        climberSolenoid = new Solenoid(PneumaticsModuleType.REVPH, 0);
        climberSolenoid.set(false);
    }

    public void toggleSolenoid(){
        //toggle the solenoid 
        climberSolenoid.set(!climberSolenoid.get());
    }
}
