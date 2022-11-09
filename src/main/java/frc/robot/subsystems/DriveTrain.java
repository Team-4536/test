package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveInfo;



public class DriveTrain extends SubsystemBase{

    public VictorSPX m_leftFrontVictor;
    public VictorSPX m_leftBackVictor;
    public VictorSPX m_rightFrontVictor;
    public VictorSPX m_rightBackVictor;    

    public Encoder m_encoderLF;



    public DriveTrain(Gyroscope gyrscope){

        //motors assigned port values

        m_leftFrontVictor = new VictorSPX(Constants.DriveInfo.LEFT_FRONT_DRIVE_MOTOR_ID);
        m_leftBackVictor = new VictorSPX(Constants.DriveInfo.LEFT_REAR_DRIVE_MOTOR_ID);
        m_rightFrontVictor = new VictorSPX(Constants.DriveInfo.RIGHT_FRONT_DRIVE_MOTOR_ID);
        m_rightBackVictor = new VictorSPX(Constants.DriveInfo.RIGHT_REAR_DRIVE_MOTOR_ID);
    

        m_encoderLF = new Encoder(Constants.DriveInfo.RIGHT_DRIVE_ENCODER_CHANNEL_A,
        Constants.DriveInfo.RIGHT_DRIVE_ENCODER_CHANNEL_B, 
        Constants.DriveInfo.RIGHT_DRIVE_ENCODER_IS_INVERTED, 
        Constants.DriveInfo.DRIVE_MOTOR_ENCODER_ENCODINGTYPE); 

        m_rightBackVictor.setInverted(true);
        m_rightFrontVictor.setInverted(true);
   
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
       

    }

}
