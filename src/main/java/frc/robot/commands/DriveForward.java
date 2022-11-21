package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveForward extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveTrain m_driveTrain;


    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public DriveForward(DriveTrain subsystem) {
        m_driveTrain = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

       m_driveTrain.driveUniform(0.1f);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_driveTrain.driveUniform(0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {

        Encoder awesomeLeftEncoder = m_driveTrain.getLeftEncoder();
        int leftEncoderValue = awesomeLeftEncoder.get();

        double rotationsGone = leftEncoderValue/360.0;
        double distanceTraveled = 19.0 * rotationsGone;

        return distanceTraveled > 24.0;
    }
}
