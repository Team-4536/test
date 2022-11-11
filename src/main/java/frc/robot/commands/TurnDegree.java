package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gyroscope;

public class TurnDegree extends CommandBase{

    private final DriveTrain m_driveTrain;
    private final Gyroscope m_gyroscope;

    private final double m_goalAngle;

    private final PIDController m_pidController;

    private final double kP = 0.0;
    private final double kI = 0.0;
    private final double kD = 0.0;

    //gets gyroscope and drivetrain and the angle we want into turndegree
    public TurnDegree(Gyroscope gyroscope, DriveTrain drivetrain, double angle){

        m_gyroscope = gyroscope;
        m_driveTrain = drivetrain;

        m_goalAngle = angle;

        m_pidController = new PIDController(kP, kI, kD);

    }


    //resets gyroscope so that initial angle is 0 when command is executed
    @Override
    public void initialize() {
      
        m_gyroscope.resetGyroscope();

    }


    //turn the robot when command is being executed
    @Override
    public void execute() {
   
        m_driveTrain.turn(0.5);

    }


    //stop the robot when the command is done
    @Override
    public void end(boolean interrupted) {
        
        m_driveTrain.stopDriving();

    }


    //this stops the robot once the return statement is true
    @Override
    public boolean isFinished() {
        
        //stop the robot once the goal angle is achieved
        return (m_gyroscope.getAngle() >= m_goalAngle);

    }
    

    
    
}
