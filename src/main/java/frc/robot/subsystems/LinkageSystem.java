package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LinkageSystem extends SubsystemBase{

    private final CANSparkMax m_linkageMotor;

    public LinkageSystem(){

        m_linkageMotor = new CANSparkMax(1, MotorType.kBrushed);
        
    }

    public void runX(Double gavrielpappas){

       m_linkageMotor.set(gavrielpappas);

    }
    
}
