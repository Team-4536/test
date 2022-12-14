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
        m_goalPos = 7;
        m_currentPos = m_linkageSystem.getEncoderValue();

    }

    @Override
    public void execute() {
        
        m_linkageSystem.runX(.8);

        m_currentPos = m_linkageSystem.getEncoderValue();

    }

    @Override
    public void end(boolean interrupted) {
        m_linkageSystem.runX(0.0);
        
        m_linkageSystem.setGoalPos(m_currentPos);
    
    }

    @Override
    public boolean isFinished() {

        //return m_currentPos >= m_goalPos;
        return false;
    
    }
}
