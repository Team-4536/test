package frc.robot.subsystems;



import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PneumaticInfo;

public class PneumaticArm extends SubsystemBase {

    
    private final DoubleSolenoid m_solenoid;
    private final PneumaticsControlModule m_module;

    public PneumaticArm (){

        m_module = new PneumaticsControlModule(PneumaticInfo.PNEUMATIC_CONTROL_MODULE_ID);
        m_solenoid = m_module.makeDoubleSolenoid(PneumaticInfo.PNEUMATIC_ARM_FORWARD_CHANNEL_ID, PneumaticInfo.PNEUMATIC_ARM_REVERSE_CHANNEL_ID);


     } 

     public void ExtendArm(){

        m_solenoid.set(DoubleSolenoid.Value.kForward);

     }

     public void RetractArm(){

        m_solenoid.set(DoubleSolenoid.Value.kReverse);

     }

     public void TurnOff(){

      m_solenoid.set(DoubleSolenoid.Value.kOff);
      
     }

    
}
