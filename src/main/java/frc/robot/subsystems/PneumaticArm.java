package frc.robot.subsystems;



import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PneumaticInfo;

public class PneumaticArm extends SubsystemBase {

    
    private final DoubleSolenoid m_solenoid;

    public PneumaticArm (){

        m_solenoid = new DoubleSolenoid(PneumaticInfo.PNEUMATIC_MODULE_TYPE, PneumaticInfo.PNEUMATIC_ARM_FORWARD_CHANNEL_ID, 
                                        PneumaticInfo.PNEUMATIC_ARM_REVERSE_CHANNEL_ID);

     } 

     public void ExtendArm(){

        m_solenoid.set(DoubleSolenoid.Value.kForward);

     }

     public void RetractArm(){

        m_solenoid.set(DoubleSolenoid.Value.kReverse);

     }

    
}
