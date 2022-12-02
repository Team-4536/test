package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LinkageSystem extends SubsystemBase{

    private final CANSparkMax m_linkageMotor;

   // private final RelativeEncoder m_encoder;

    public LinkageSystem(){

        m_linkageMotor = new CANSparkMax(1, MotorType.kBrushed);

        //m_encoder = m_linkageMotor.getEncoder();
        
    }

    public void runX(Double speed){

       m_linkageMotor.set(speed);

    }
    
}
