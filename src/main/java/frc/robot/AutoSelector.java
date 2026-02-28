package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoSelector {

    private static final String Default = "Default";
    private static final String AutoOne = "AutoOne";
    private static final String AutoTwo = "AutoTwo";
    private static final String AutoThree = "AutoThree";
    private static final String AutoFour = "AutoFour";
    private String m_autoselect;
    private final SendableChooser<String> m_chooser = new SendableChooser<String>();

public AutoSelector() {
    m_chooser.setDefaultOption("Test", Default);
    m_chooser.addOption("AutoOne", AutoOne);
    m_chooser.addOption("AutoTwo", AutoTwo);
    m_chooser.addOption("AutoThree", AutoThree);
    m_chooser.addOption("AutoFour", AutoFour);
    SmartDashboard.putData("Auto Choices", m_chooser);
}


public void autonomousInit() {
    m_autoselect = m_chooser.getSelected();
    System.out.println("Auto Selected: " + m_autoselect);
}


public void autonomousPeriodic(){
    switch (m_autoselect) {
        case AutoOne:
        //place Custom auto 1 here
        break;
        case AutoTwo:
        //place Custom auto 2 here
        break;
        case AutoThree:
        //place Custom auto 3 here
        break;
        case AutoFour:
        //place Costum auto 4 here
        break;
        case Default:
        Default:
        // Place custom default here. Not sure what to place here either so thats a later problem
        break;
    }
}
}