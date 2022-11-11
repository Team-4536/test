package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Gyroscope extends SubsystemBase{

    private final AHRS m_gyroscope;

    public Gyroscope(){

        m_gyroscope = new AHRS();

    }   

    public double getAngle(){

        return m_gyroscope.getAngle();

    }

    public void resetGyroscope(){

        m_gyroscope.reset();

    }
    
    
}
