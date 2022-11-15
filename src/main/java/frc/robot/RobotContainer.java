// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.TurnDegree;
import frc.robot.subsystems.Gyroscope;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class RobotContainer {

  //subsystem instances
  private final Gyroscope m_gyroscope;
  private final DriveTrain m_driveTrain;

  //joysticks and related objects instances
  private final Joystick m_joystick;
  private final JoystickButton m_turnButton;
  private final JoystickButton m_resetEncoderButton;

  //command instances
  private final TurnDegree m_turnDegree;


  //define instance variables and run methods to set button commands and default commands
  public RobotContainer() {

    m_gyroscope = new Gyroscope();
    m_driveTrain = new DriveTrain(m_gyroscope);
    
    m_joystick = new Joystick(0);

    m_turnButton = new JoystickButton(m_joystick, 3);
    m_resetEncoderButton = new JoystickButton(m_joystick, 1);

    m_turnDegree = new TurnDegree(m_gyroscope, m_driveTrain, 90.0);

    configureButtonBindings();
    setDefaultCommands();

  }

  
  //method to give the buttons command outputs
  private void configureButtonBindings() {

    m_turnButton.whenPressed(m_turnDegree);
    m_resetEncoderButton.whenPressed(new RunCommand(()-> m_driveTrain.resetEncoders(), m_driveTrain));

  }


  //method to set default commands on subsystems of the robot
  private void setDefaultCommands(){

    m_driveTrain.setDefaultCommand(new RunCommand(()-> m_driveTrain.cartesianDrive(m_joystick.getY(), m_joystick.getX(), m_joystick.getZ()), m_driveTrain));

  }

  
  //method to set a command to be scheduled during the autonomous period
  public Command getAutonomousCommand() {
    
    return null;

  }

}
