package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
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
    
}
