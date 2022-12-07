package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveInfo;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gyroscope;

public class TurnDegree extends CommandBase{

    //instance subystmes
    private final DriveTrain m_driveTrain;
    private final Gyroscope m_gyroscope;

    //instance double for goal angle
    private final double m_goalAngle;

    //instance PID controller
    private final PIDController m_pidController;
    private final Timer m_funnyTimer;
 
    //instance PID coefficient values
    private final double kP = 0.0083;
    private final double kI = 0.0026;
    private final double kD = 0.0005;


    //gets gyroscope and drivetrain and the angle we want into turndegree
    public TurnDegree(Gyroscope gyroscope, DriveTrain drivetrain, double angle){

        m_gyroscope = gyroscope;
        m_driveTrain = drivetrain;

        m_goalAngle = m_gyroscope.getAngleAbsolute() + angle;

        m_pidController = new PIDController(kP, kI, kD);

        m_funnyTimer = new Timer();

    }


    //resets gyroscope so that initial angle is 0 when command is executed
    @Override
    public void initialize() {
      
        //m_gyroscope.resetGyroscope();

        m_pidController.reset();

        m_funnyTimer.reset();
        m_funnyTimer.start();

    }


    //turn the robot when command is being executed
    @Override
    public void execute() {

        double currentAngle = m_gyroscope.getAngleAbsolute();

        double PIDspeed = m_pidController.calculate(currentAngle - m_goalAngle);
        double turnSpeed = Math.min(PIDspeed, DriveInfo.BASE_DRIVE_VALUE);
   
        m_driveTrain.turn(turnSpeed);

        SmartDashboard.putNumber("PID val", PIDspeed);
        SmartDashboard.putNumber("Turn Motor Output", turnSpeed);

        PIDspeed = 0;
        turnSpeed = 0;

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
        return (m_gyroscope.getAngleAbsolute() >= m_goalAngle) && (m_funnyTimer.get() >= 2.5);

    }
    

    
    
}
