package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Gyroscope extends SubsystemBase{

    private final AHRS m_gyroscope;

    public Gyroscope(){

        m_gyroscope = new AHRS();

    }   

    public double getAngle(){

        if (m_gyroscope.getAngle() > 0){

            return m_gyroscope.getAngle()%360;

        }
        else{
            
            return m_gyroscope.getAngle()%360;

        }

    }

    public void resetGyroscope(){

        m_gyroscope.reset();

    }

    public AHRS getAHRS(){

        return m_gyroscope;
        
    }
    
    
}
