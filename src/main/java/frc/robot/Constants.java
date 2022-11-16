// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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

    public final static class DriveInfo{

        public final static int ENCODER_TICKS_PER_ROTATION = 360;

        public final static double MECANUM_WHEEL_CIRCUMFERENCE_IN_INCHES = 19.0;
        public final static double MECANUM_WHEEL_DIAMETER_IN_INCHES = MECANUM_WHEEL_CIRCUMFERENCE_IN_INCHES/Math.PI;

    // motor port value constants
    public static final int LEFT_FRONT_DRIVE_MOTOR_ID = 0;
    public static final int LEFT_REAR_DRIVE_MOTOR_ID = 3;
    public static final int RIGHT_FRONT_DRIVE_MOTOR_ID = 1;
    public static final int RIGHT_REAR_DRIVE_MOTOR_ID = 2;
   // public static final MotorType DRIVE_MOTOR_BRUSHED_TYPE = MotorType.kBrushed;

    //public static final boolean LEFT_DRIVE_MOTORS_ARE_INVERTED = true;
    //public static final boolean RIGHT_DRIVE_MOTORS_ARE_INVERTED = false;

    //public static final double DIFFERENTIAL_DRIVE_DEADBAND = 0.4;

    //encoder port values (?)

    public static final int LEFT_DRIVE_ENCODER_CHANNEL_A = 0;
    public static final int LEFT_DRIVE_ENCODER_CHANNEL_B = 1;
    public static final int RIGHT_DRIVE_ENCODER_CHANNEL_A = 2;
    public static final int RIGHT_DRIVE_ENCODER_CHANNEL_B = 3;
    public static final boolean RIGHT_DRIVE_ENCODER_IS_INVERTED = false;
    public static final EncodingType DRIVE_MOTOR_ENCODER_ENCODINGTYPE = null;

    //public static final EncodingType DRIVE_MOTOR_ENCODER_ENCODINGTYPE = EncodingType.k2X;

    //public static final boolean LEFT_DRIVE_ENCODER_IS_INVERTED = false;
    //public static final boolean RIGHT_DRIVE_ENCODER_IS_INVERTED = true;

    //public static final boolean SHOW_DRIVETRAIN_IN_DASHBOARD = true;

   // public static final double SET_MAX_RATE = 0.5;
}
}
