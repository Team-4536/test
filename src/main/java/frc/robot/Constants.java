// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
 
public final class Constants {

    public static final class DriveInfo{

    //base drive values
    public static final double BASE_DRIVE_VALUE = .7;

    //physical wheel constant values
    public static final int ENCODER_TICKS_PER_ROTATION = 360;

    public static final double MECANUM_WHEEL_CIRCUMFERENCE_IN_INCHES = 19.0;
    public static final double MECANUM_WHEEL_DIAMETER_IN_INCHES = MECANUM_WHEEL_CIRCUMFERENCE_IN_INCHES/Math.PI;


    //drive input dampening coefficients
    public static final double MOTOR_OUTPUT_Y_COEFFICIENT = .75;
    public static final double MOTOR_OUTPUT_X_COEFFICIENT = 1;
    public static final double MOTOR_OUTPUT_Z_COEFFICIENT = .6;

    
    //drive input deadzone values
    public static final double DRIVE_MOTOR_DEADZONE = .15;
    public static final double SPIN_MOTOR_DEADZONE = .22;


    // motor port value constants
    public static final int LEFT_FRONT_DRIVE_MOTOR_ID = 0;
    public static final int LEFT_REAR_DRIVE_MOTOR_ID = 3;
    public static final int RIGHT_FRONT_DRIVE_MOTOR_ID = 1;
    public static final int RIGHT_REAR_DRIVE_MOTOR_ID = 2;

    public static final boolean LEFT_DRIVE_MOTORS_ARE_INVERTED = false;
    public static final boolean RIGHT_DRIVE_MOTORS_ARE_INVERTED = true;

    //encoder port values
    public static final int LEFT_DRIVE_ENCODER_CHANNEL_A = 2;
    public static final int LEFT_DRIVE_ENCODER_CHANNEL_B = 3;
    public static final int RIGHT_DRIVE_ENCODER_CHANNEL_A = 0;
    public static final int RIGHT_DRIVE_ENCODER_CHANNEL_B = 1;

    public static final boolean LEFT_DRIVE_ENCODER_IS_INVERTED = false;
    public static final boolean RIGHT_DRIVE_ENCODER_IS_INVERTED = true;

    public static final EncodingType DRIVE_MOTOR_ENCODER_ENCODINGTYPE = EncodingType.k2X;

    }

    public static final class PneumaticInfo{

    //solenoid channel ids
    public static final int PNEUMATIC_ARM_FORWARD_CHANNEL_ID = 6;
    public static final int PNEUMATIC_ARM_REVERSE_CHANNEL_ID = 7;

    public static final int PNEUMATIC_CONTROL_MODULE_ID = 4;

    //pneumatics module type
    public static final PneumaticsModuleType PNEUMATIC_MODULE_TYPE = PneumaticsModuleType.CTREPCM;


    }

    public static final class LinkageInfo{

        public static final double LINKAGE_MIDPOINT_POSITION = 4;

        public static final int LINKAGE_MOTOR_ID = 1;

        public static final boolean IS_LINKAGE_MOTOR_INVERTED = true;

        public static final double HIGH_PILLAR_POSITION = 9;
        public static final double LOW_PILLAR_POSITION = 6.35;

    }

    public static final class ControllerInfo{

        public static final int JOYSTICK_PORT_ID = 0;

        public static final int CONTROLLER_PORT_ID = 1;
    


    }
    
}
