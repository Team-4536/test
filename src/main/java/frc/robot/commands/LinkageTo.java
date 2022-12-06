package frc.robot.commands;

import org.w3c.dom.stylesheets.LinkStyle;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.LinkageInfo;
import frc.robot.subsystems.LinkageSystem;

public class LinkageTo extends CommandBase{

    private final double m_goalPosition;

    private final LinkageSystem m_linkage;

    private final PIDController m_pid;

    private final double P = 0;
    private final double I = 0;
    private final double D = 0;



    public LinkageTo (LinkageSystem linkage, double goalPos){

        m_linkage = linkage;

        m_goalPosition = goalPos;

        m_pid = new PIDController(P, I, D);

    }
    

    @Override
    public void execute() {

        double currentPos = m_linkage.getEncoderValue();
        double error = m_goalPosition - currentPos;

        if(error > 3){
            m_linkage.runX(.8);
        } else if(error > 1.5){
            m_linkage.runX(.6);
        } else if(error > .5){
            m_linkage.runX(.5);
        }
        else{
            m_linkage.runX(0.0);
        }

    }

    @Override
    public boolean isFinished() {
        
        double currentPos = m_linkage.getEncoderValue();
        double error = m_goalPosition - currentPos;

        if (Math.abs(error) < .05){
            return true;
        }
        else return false;

    }

    @Override
    public void end(boolean interrupted) {
        m_linkage.setGoalPos(m_linkage.getEncoderValue());
    }
    
}
