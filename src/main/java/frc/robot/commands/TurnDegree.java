package frc.robot.commands;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gyroscope;

public class TurnDegree extends CommandBase{

    DriveTrain m_driveTrain;
    Gyroscope m_gyroscope;
    Double m_goalAngle;

    public TurnDegree(Gyroscope gav, DriveTrain gav2, Double wienrs){

        m_gyroscope = gav;
        m_driveTrain = gav2;
        m_goalAngle = wienrs;

    }

    @Override
    public void initialize() {
      
        m_gyroscope.resetGyroscope();

    }

    @Override
    public void execute() {
   
        

    }


    
    
}
