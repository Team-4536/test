package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticArm;

public class ExtendGrabber extends CommandBase{

    private final PneumaticArm m_grabber;
    private boolean m_switch;

    public ExtendGrabber(PneumaticArm gr4bber){

        m_grabber = gr4bber;

        m_switch = true;

    }

    @Override
    public void initialize() {}


    //extend pneumatic when command is executed
    @Override
    public void execute() {
        
        if (m_switch) {

            m_grabber.ExtendArm();

        }
        else {

            m_grabber.RetractArm();

        }

    }

    // stop pneumatic when command is done
    @Override
    public void end(boolean interrupted) {
        
        m_grabber.TurnOff();

        m_switch = !m_switch;
        
    }
    
    
}
