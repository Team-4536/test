package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.LinkageInfo;
import frc.robot.subsystems.LinkageSystem;

public class LinkageTo extends CommandBase{

    private final LinkageSystem m_linkage;

    private final double m_goalPosition;

    private final PIDController m_pid;
    private final double kP = 0.0;
    private final double kI = 0.0;
    private final double kD = 0.0;

    public LinkageTo(LinkageSystem linkage, double goalPos){

        m_linkage = linkage;

        m_goalPosition = goalPos;

        m_pid = new PIDController(kP, kI, kD);

    }

    @Override
    public void initialize() {
        
        m_pid.reset();

    }

    @Override
    public void execute() {
        
        double currentPosition = m_linkage.getEncoderValue();
        double error = currentPosition - m_goalPosition;

        if (currentPosition < LinkageInfo.LINKAGE_MIDPOINT_POSITION){

            m_linkage.runX(.7);

        }
        else {

            double PIDSpeed = m_pid.calculate(error);
            double LinkageSpeed = Math.min(PIDSpeed, .7);

            m_linkage.runX(LinkageSpeed);

            SmartDashboard.putNumber("PID val linkage", PIDSpeed);


        }

    }

    @Override
    public boolean isFinished() {
        
        return m_linkage.getEncoderValue() >= m_goalPosition;
    }

    @Override
    public void end(boolean interrupted) {
        
        m_linkage.setGoalPos(m_linkage.getEncoderValue());

    }
    
}
