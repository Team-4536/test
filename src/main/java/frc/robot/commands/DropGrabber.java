package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.LinkageInfo;
import frc.robot.subsystems.LinkageSystem;

public class DropGrabber extends CommandBase {
    
    //proportional integral derivative
    private final LinkageSystem m_linkageSystem;
    
    private double m_currentPos;

    public DropGrabber(LinkageSystem linkageSystem){

        m_linkageSystem = linkageSystem;

        m_currentPos = m_linkageSystem.getEncoderValue();

    }

    @Override
    public void execute() {

        m_currentPos = m_linkageSystem.getEncoderValue();
        
        if (m_currentPos >= LinkageInfo.LINKAGE_MIDPOINT_POSITION){

            m_linkageSystem.runX(-.25);

        }
        else {

            m_linkageSystem.runX(-.34);

        }


    }

    @Override
    public void end(boolean interrupted) {

        m_linkageSystem.runX(0.0);

        m_linkageSystem.setGoalPos(m_currentPos);
        
    }
}
