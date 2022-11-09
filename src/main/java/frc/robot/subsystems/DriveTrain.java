package frc.robot.subsystems;

import javax.swing.plaf.basic.BasicTabbedPaneUI.TabSelectionHandler;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class DriveTrain extends SubsystemBase{

    VictorSPX m_leftFrontVictor;
    VictorSPX m_leftBackVictor;
    VictorSPX m_rightFrontVictor;
    VictorSPX m_rightBackVictor;  
    
    Gyroscope m_gyroscope;

    public DriveTrain(Gyroscope gyr0scop3){

        m_leftFrontVictor = new VictorSPX(0);
        m_leftBackVictor = new VictorSPX(3);
        m_rightFrontVictor = new VictorSPX(1);
        m_rightBackVictor = new VictorSPX(2);

        m_rightBackVictor.setInverted(true);
        m_rightFrontVictor.setInverted(true);

        m_gyroscope = gyr0scop3;
        
    }


    public void DriveInput(double speed){

        m_leftBackVictor.set(ControlMode.PercentOutput, speed);
        m_leftFrontVictor.set(ControlMode.PercentOutput, speed);
        m_rightFrontVictor.set(ControlMode.PercentOutput, speed);
        m_rightBackVictor.set(ControlMode.PercentOutput, speed);

    }


    public void tankDrive(double leftSpeed, double rightSpeed){

        m_leftBackVictor.set(ControlMode.PercentOutput, leftSpeed);
        m_leftFrontVictor.set(ControlMode.PercentOutput, leftSpeed);
        m_rightFrontVictor.set(ControlMode.PercentOutput, rightSpeed);
        m_rightBackVictor.set(ControlMode.PercentOutput, rightSpeed);
    }


    public void cartesianDrive (double forward, double sideways, double spin){

        //damp drive values
        forward *= .75;
        spin *= .6;
        sideways *= 1;

        //set min values for everything
        double driveThreshold = .15;
        double spinThreshold = .22;

        if (Math.abs(forward) < driveThreshold){
            forward = 0; }
        if (Math.abs(spin) < spinThreshold){
            spin = 0; }
        if (Math.abs(sideways) < driveThreshold){
            sideways = 0; }

        //blend drive, strafe, and turing
        double leftFront = forward - sideways + spin;
        double leftBack = forward + sideways + spin;
        double rightFront = forward + sideways - spin;
        double rightBack = forward - sideways - spin;

        //clamp to not exceed 1
        double maxLeftVal = Math.max(leftBack, leftFront);
        double maxRightVal = Math.max(rightBack, rightFront);
        double maxVal = Math.max(maxRightVal, maxLeftVal);

        if (maxVal >= 1){
            leftFront /= maxVal;
            leftBack/= maxVal;
            rightBack /= maxVal;
            rightFront /= maxVal; }

        //apply
        m_leftFrontVictor.set(ControlMode.PercentOutput, leftFront);
        m_leftBackVictor.set(ControlMode.PercentOutput, leftBack);
        m_rightFrontVictor.set(ControlMode.PercentOutput, rightFront);
        m_rightBackVictor.set(ControlMode.PercentOutput, rightBack);


        //send telemetry
        SmartDashboard.putNumber("forward", forward);
        SmartDashboard.putNumber("sideways", sideways);
        SmartDashboard.putNumber("spin", spin);

        SmartDashboard.putNumber("FL", m_leftFrontVictor.getMotorOutputPercent());
        SmartDashboard.putNumber("BL", m_leftBackVictor.getMotorOutputPercent());
        SmartDashboard.putNumber("FR", m_rightFrontVictor.getMotorOutputPercent());
        SmartDashboard.putNumber("BR", m_rightBackVictor.getMotorOutputPercent());

        SmartDashboard.putNumber("Angle", m_gyroscope.getAngle());
       

    }

}
