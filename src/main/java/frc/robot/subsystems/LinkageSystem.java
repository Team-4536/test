package frc.robot.subsystems;

import javax.swing.text.StyleContext.SmallAttributeSet;

import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LinkageInfo;

public class LinkageSystem extends SubsystemBase{

    private final CANSparkMax m_linkageMotor;

    private final RelativeEncoder m_encoder;

    public double m_goalPos;

    public LinkageSystem(){

        m_linkageMotor = new CANSparkMax(LinkageInfo.LINKAGE_MOTOR_ID, MotorType.kBrushed);

        m_encoder = m_linkageMotor.getEncoder(EncoderType.kQuadrature, 8192);
        m_encoder.setInverted(LinkageInfo.IS_LINKAGE_MOTOR_INVERTED);

        m_goalPos = m_encoder.getPosition();

    }

    public void runX(Double speed){

       m_linkageMotor.set(speed);

       SmartDashboard.putNumber("Lift Encoder Value", m_encoder.getPosition());
       SmartDashboard.putNumber("Spark Motor Output", speed);

    }

    public double getEncoderValue(){

        return m_encoder.getPosition();
        
    }

    public void setGoalPos(double pos){

        m_goalPos = pos;
        
    }
    
}
