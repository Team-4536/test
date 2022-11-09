package frc.robot.commands;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gyroscope;

public class TurnDegree extends CommandBase{

    DriveTrain m_driveTrain;
    Gyroscope m_gyroscope;
    Double m_goalAngle;
    
    public TurnDegree(Gyroscope gav, DriveTrain gav2, Double angle){

        m_gyroscope = gav;
        m_driveTrain = gav2;
        m_goalAngle = angle;

    }
    //gets gyroscope and drivetrain and the angle we want into turndegree
    @Override
    public void initialize() {
      
        m_gyroscope.resetGyroscope();

    }
    //reset gyroscope
    @Override
    public void execute() {
   
        m_driveTrain.turnRight(0.5);

    }


    //this stops the robot once the goal angle is reached
    @Override
    public boolean isFinished() {
        
        return (m_gyroscope.getAngle() >= m_goalAngle);

    }
    //returns true if the angle is at or above goal angle meaning turn is finished

    
    
}
