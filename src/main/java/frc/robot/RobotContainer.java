// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.ControllerInfo;
import frc.robot.commands.DropGrabber;
import frc.robot.commands.ExtendGrabber;
import frc.robot.commands.HoldArm;
import frc.robot.commands.LiftGrabber;
import frc.robot.commands.RetractGrabber;
import frc.robot.commands.TurnDegree;
import frc.robot.subsystems.Gyroscope;
import frc.robot.subsystems.LinkageSystem;
import frc.robot.subsystems.PneumaticArm;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class RobotContainer {

  //subsystem instances
  private final Gyroscope m_gyroscope;
  private final DriveTrain m_driveTrain;
  private final PneumaticArm m_grabber;
  private final LinkageSystem m_linkageSystem;

  //joysticks and related objects instances
  private final Joystick m_joystick;

  private final JoystickButton m_turnButton;
  private final JoystickButton m_resetEncoderButton;

  //grabber buttons
  private final JoystickButton m_grabberExtendButton;
  private final JoystickButton m_grabberRetractButton;
  private final JoystickButton m_grabberLiftButton;
  private final JoystickButton m_grabberDropButton;

  //command instances
  private final TurnDegree m_turnDegree;
  private final ExtendGrabber m_extendGrabber;
  private final RetractGrabber m_retractGrabber;

  private final LiftGrabber m_liftGrabber;
  private final DropGrabber m_dropGrabber;
  private final HoldArm m_holdArm;

  //define instance variables and run methods to set button commands and default commands
  public RobotContainer() {

    m_gyroscope = new Gyroscope();
    m_driveTrain = new DriveTrain(m_gyroscope);
    m_grabber = new PneumaticArm();
    m_linkageSystem = new LinkageSystem();
    
    m_joystick = new Joystick(ControllerInfo.JOYSTICK_PORT_ID);

    m_turnButton = new JoystickButton(m_joystick, 3);
    m_resetEncoderButton = new JoystickButton(m_joystick, 5);
    m_grabberExtendButton = new JoystickButton(m_joystick, 4);
    m_grabberRetractButton = new JoystickButton(m_joystick, 2);
    m_grabberLiftButton = new JoystickButton(m_joystick, 11);
    m_grabberDropButton = new JoystickButton(m_joystick, 12);

    m_turnDegree = new TurnDegree(m_gyroscope, m_driveTrain, 90.0);
    m_extendGrabber = new ExtendGrabber(m_grabber);
    m_retractGrabber = new RetractGrabber(m_grabber);

    m_liftGrabber = new LiftGrabber(m_linkageSystem);
    m_dropGrabber = new DropGrabber(m_linkageSystem);
    m_holdArm = new HoldArm(m_linkageSystem);
    

    configureButtonBindings();
    setDefaultCommands();

  }

  
  //method to give the buttons command outputs
  private void configureButtonBindings() {

    m_turnButton.whenPressed(m_turnDegree);
    m_resetEncoderButton.whenPressed(new RunCommand(()-> m_driveTrain.resetEncoders(), m_driveTrain).withTimeout(.01));

    m_grabberExtendButton.whenHeld(m_extendGrabber);
    m_grabberRetractButton.whenHeld(m_retractGrabber);
    m_grabberLiftButton.whenHeld(m_liftGrabber);
    m_grabberDropButton.whenHeld(m_dropGrabber);

  }


  //method to set default commands on subsystems of the robot
  private void setDefaultCommands(){

    m_driveTrain.setDefaultCommand(new RunCommand(()-> m_driveTrain.cartesianDrive(-m_joystick.getY(), -m_joystick.getX(), m_joystick.getZ()), m_driveTrain));
    m_linkageSystem.setDefaultCommand(m_holdArm);

  }

  
  //method to set a command to be scheduled during the autonomous period
  public Command getAutonomousCommand() {
    
    return null;

  }

}

