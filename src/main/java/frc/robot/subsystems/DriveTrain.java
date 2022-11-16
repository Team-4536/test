package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveInfo;



public class DriveTrain extends SubsystemBase{

    //Victor SPX motor controller instance variables
    private final VictorSPX m_leftFrontVictor;
    private final VictorSPX m_leftBackVictor;
    private final VictorSPX m_rightFrontVictor;
    private final VictorSPX m_rightBackVictor;  

    //gyroscope instance variable
    private final Gyroscope m_gyroscope;

    //encoder instance variables
    private final Encoder m_leftEncoder;
    private final Encoder m_rightEncoder;
    


    //define instance variables and invert motors where necessary
    public DriveTrain(Gyroscope gyr0scop3){

        //motors assigned port values

        m_leftFrontVictor = new VictorSPX(Constants.DriveInfo.LEFT_FRONT_DRIVE_MOTOR_ID);
        m_leftBackVictor = new VictorSPX(Constants.DriveInfo.LEFT_REAR_DRIVE_MOTOR_ID);
        m_rightFrontVictor = new VictorSPX(Constants.DriveInfo.RIGHT_FRONT_DRIVE_MOTOR_ID);
        m_rightBackVictor = new VictorSPX(Constants.DriveInfo.RIGHT_REAR_DRIVE_MOTOR_ID);
    

        m_encoderLF = new Encoder(Constants.DriveInfo.RIGHT_DRIVE_ENCODER_CHANNEL_A,
        Constants.DriveInfo.RIGHT_DRIVE_ENCODER_CHANNEL_B, 
        Constants.DriveInfo.RIGHT_DRIVE_ENCODER_IS_INVERTED, 
        Constants.DriveInfo.DRIVE_MOTOR_ENCODER_ENCODINGTYPE); 

        m_leftFrontVictor.setInverted(false);
        m_leftBackVictor.setInverted(false);
        m_rightBackVictor.setInverted(true);
        m_rightFrontVictor.setInverted(true);

        m_gyroscope = gyr0scop3;

        m_leftEncoder = new Encoder(2, 3, false, EncodingType.k2X);
        m_rightEncoder = new Encoder(0, 1, true, EncodingType.k2X);
        
    }


    //methods to get encoders in other files
    public Encoder getLeftEncoder(){

        return m_leftEncoder;

    }

    public Encoder getRightEncoder(){

        return m_rightEncoder;

    }


    //methods to reset encoders
    public void resetEncoders(){

        m_leftEncoder.reset();
        m_rightEncoder.reset();

    }

    //method to drive moving all wheels in the same direciton
    public void DriveInput(double speed){

        m_leftBackVictor.set(ControlMode.PercentOutput, speed);
        m_leftFrontVictor.set(ControlMode.PercentOutput, speed);
        m_rightFrontVictor.set(ControlMode.PercentOutput, speed);
        m_rightBackVictor.set(ControlMode.PercentOutput, speed);

    }

    //method to drive by giving each set of wheels based on left or right side of robot different speeds
    public void tankDrive(double leftSpeed, double rightSpeed){

        m_leftBackVictor.set(ControlMode.PercentOutput, leftSpeed);
        m_leftFrontVictor.set(ControlMode.PercentOutput, leftSpeed);
        m_rightFrontVictor.set(ControlMode.PercentOutput, rightSpeed);
        m_rightBackVictor.set(ControlMode.PercentOutput, rightSpeed);

    }

    //method to turn robot, turn right when speed is positive
    public void turn(double speed){

        m_leftBackVictor.set(ControlMode.PercentOutput, speed);
        m_leftFrontVictor.set(ControlMode.PercentOutput, speed);
        m_rightFrontVictor.set(ControlMode.PercentOutput, -speed);
        m_rightBackVictor.set(ControlMode.PercentOutput, -speed);

        SmartDashboard.putNumber("FL", m_leftFrontVictor.getMotorOutputPercent());
        SmartDashboard.putNumber("BL", m_leftBackVictor.getMotorOutputPercent());
        SmartDashboard.putNumber("FR", m_rightFrontVictor.getMotorOutputPercent());
        SmartDashboard.putNumber("BR", m_rightBackVictor.getMotorOutputPercent());

    }

    //method to stop motor output
    public void stopDriving(){

        m_leftBackVictor.set(ControlMode.PercentOutput, 0);
        m_leftFrontVictor.set(ControlMode.PercentOutput, 0);
        m_rightFrontVictor.set(ControlMode.PercentOutput, 0);
        m_rightBackVictor.set(ControlMode.PercentOutput, 0);

    }

    //method for driving based on x, y, and z values of a joystick
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

        SmartDashboard.putNumber("Left Encoder Ticks", m_leftEncoder.get());
        SmartDashboard.putNumber("Right Encoder Ticks", m_rightEncoder.get());

        SmartDashboard.putNumber("Angle", m_gyroscope.getAngle());

    }

}
