package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticArm;

public class RetractGrabber extends CommandBase{

    private final PneumaticArm m_grabber;

    public RetractGrabber(PneumaticArm gr4bber){

        m_grabber = gr4bber;

    }

    @Override
    public void initialize() {}

    //retracts arm when command is run
    @Override
    public void execute() {
        
        m_grabber.RetractArm();

    }

    //turns off grabber when command is run
    @Override
    public void end(boolean interrupted) {
        
        m_grabber.TurnOff();
        
    }
    
    
}
