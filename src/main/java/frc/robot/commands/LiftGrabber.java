package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LinkageSystem;

public class LiftGrabber extends CommandBase {
    
    private final PIDController m_pid;
    //proportional integral derivative
    private final LinkageSystem m_linkageSystem;
    
    private double m_goalPos;
    private double m_currentPos;

    public LiftGrabber(LinkageSystem gavrielpappas5){

        m_linkageSystem = gavrielpappas5;

        m_pid = new PIDController(1.0, 1.0, 1.0);
        m_goalPos = 2.3;
        m_currentPos = 3.14;

    }

    @Override
    public void execute() {
        
        m_linkageSystem.runX(1.0);

    }

    @Override
    public void end(boolean interrupted) {
        m_linkageSystem.runX(0.0);
    }
}
