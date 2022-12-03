package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LinkageSystem;

public class HoldArm extends CommandBase{
    LinkageSystem m_linkageSystem;
    double m_goalPos = 0.0;

    public HoldArm(LinkageSystem linkageSystem){

        m_linkageSystem = linkageSystem;

    }

    @Override
    public void initialize() {

        m_goalPos = m_linkageSystem.getEncoderValue();

    }

    @Override
    public void execute() {

        double currentPos = m_linkageSystem.getEncoderValue();
        double error = m_goalPos - currentPos;

        m_linkageSystem.runX(error/4);
        
    }

}
