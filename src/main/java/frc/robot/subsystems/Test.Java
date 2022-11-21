package frc.robot.subsystems;

public class Test extends SubsystemBase{

    private final Spark m_mechanismMotor;
    
    public Test(){

        m_mechanismMotor = new Spark(0);

    }

xbox

    public void TestSpeed(double speed){

        m_mechanismMotor.set(0.5);
        
    }

}