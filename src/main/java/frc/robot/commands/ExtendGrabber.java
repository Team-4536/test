package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticArm;

public class ExtendGrabber extends CommandBase{

    private final PneumaticArm m_grabber;

    public ExtendGrabber(PneumaticArm gr4bber){

        m_grabber = gr4bber;

    }

    @Override
    public void initialize() {}


    //extend pneumatic when command is executed
    @Override
    public void execute() {
        
        m_grabber.ExtendArm();

    }

    // stop pneumatic when command is done
    @Override
    public void end(boolean interrupted) {
        
        m_grabber.TurnOff();
        
    }
    
    
}
