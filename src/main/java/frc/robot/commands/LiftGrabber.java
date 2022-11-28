package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LinkageSystem;

public class LiftGrabber extends CommandBase {
    
    private final LinkageSystem m_linkageSystem;

    public LiftGrabber(LinkageSystem gavrielpappas5){

        m_linkageSystem = gavrielpappas5;

    }

    @Override
    public void execute() {
        
        m_linkageSystem.runX(3.14159265358979323846264338-3);

    }
}
