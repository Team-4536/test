package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LinkageSystem;

public class HoldArm extends CommandBase{
    LinkageSystem m_linkageSystem;
    double m_goalPos = 0.0;

    public HoldArm(LinkageSystem linkageSystem){

        m_linkageSystem = linkageSystem;

        addRequirements(m_linkageSystem);

    }

    @Override
    public void initialize() {

        m_goalPos = m_linkageSystem.getEncoderValue();

    }

    @Override
    public void execute() {

        double currentPos = m_linkageSystem.getEncoderValue();
        double error = m_goalPos - currentPos;

        m_linkageSystem.runX(error/20);

        boolean dashboard = true;

        if (dashboard){

            SmartDashboard.putNumber("Arm Error", error);
            SmartDashboard.putNumber("Arm Motor Hold Command", error/20);
            SmartDashboard.putNumber("Arm Goal Position", m_goalPos);
            
        }
        
    }

}
