// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TurnDegree;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Gyroscope;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;




public class RobotContainer {

  private final Gyroscope m_gyroscope;
  private final DriveTrain m_driveTrain;

  private final Joystick m_joystick;
  private final JoystickButton m_turnButton;

  private final TurnDegree m_turnDegree;


  public RobotContainer() {

    m_gyroscope = new Gyroscope();
    m_driveTrain = new DriveTrain(m_gyroscope);
    
    m_joystick = new Joystick(0);

    m_turnButton = new JoystickButton(m_joystick, 3);

    m_turnDegree = new TurnDegree(m_gyroscope, m_driveTrain, 90.0);

    configureButtonBindings();
    setDefaultCommands();

  }

  


  private void configureButtonBindings() {

    m_turnButton.whenPressed(m_turnDegree);

  }


  private void setDefaultCommands(){

    m_driveTrain.setDefaultCommand(new RunCommand(()-> m_driveTrain.cartesianDrive(m_joystick.getY(), m_joystick.getX(), m_joystick.getZ()), m_driveTrain));

  }

  

  public Command getAutonomousCommand() {
    
    return null;

  }
}
