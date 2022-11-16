package frc.robot.subsystems;



import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticArm extends SubsystemBase {

    
    private final DoubleSolenoid m_solenoid;

    public PneumaticArm (){

        m_solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 0);

     } 

     public void ExtendArm(){

        m_solenoid.set(DoubleSolenoid.Value.kForward);

     }

     public void RetractArm(){

        m_solenoid.set(DoubleSolenoid.Value.kReverse);

     }

    
}
