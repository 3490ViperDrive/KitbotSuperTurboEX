package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CANClimbSubystem extends SubsystemBase{
    

    private Solenoid climberSolenoid;
    //private Compressor compressor;
    private boolean aaaa = false;

    public CANClimbSubystem(){
        //instantiate object using id
        //climberSolenoid = new Solenoid(8,PneumaticsModuleType.REVPH, 0);
        climberSolenoid = new Solenoid(8,PneumaticsModuleType.REVPH, 0);
        //compressor = new Compressor(8, PneumaticsModuleType.REVPH);
        //compressor.enableDigital();
        //compressor.enableHybrid(50, 120);
        //compressor.enableHybrid(60,110);
        //compressor.enableAnalog(60, 110);

        climberSolenoid.set(false);
    }

    public void toggleSolenoid(){
        //toggle the solenoid 
        climberSolenoid.set(true);
        //aaaa = !aaaa;
    }

    public void retractSolenoid(){
        climberSolenoid.set(false);
    }
}
