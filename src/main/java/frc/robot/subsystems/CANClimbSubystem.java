package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CANClimbSubystem extends SubsystemBase{
    

    private Solenoid climberSolenoid;
    //private Compressor compressor;

    public CANClimbSubystem(){
        climberSolenoid = new Solenoid(8,PneumaticsModuleType.REVPH, 0);
        //compressor = new Compressor(8, PneumaticsModuleType.REVPH);
        //compressor.enableDigital();
        //compressor.enableHybrid(50, 110);
        //compressor.enableHybrid(50,110);
        //compressor.enableAnalog(50, 110);
        climberSolenoid.set(false);
    }

    public void toggleSolenoid(){
        climberSolenoid.set(true);
    }

    public void retractSolenoid(){
        climberSolenoid.set(false);
    }
    //This shouldn't have to live in two seperate function calls, but it works
}
