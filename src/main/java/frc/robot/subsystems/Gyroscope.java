package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Gyroscope extends SubsystemBase{

    AHRS m_gyroscope;

    public Gyroscope(){

        m_gyroscope = new AHRS();

    }   

    public double GetAngle(){

        return m_gyroscope.getAngle();

    }
    
    
}
