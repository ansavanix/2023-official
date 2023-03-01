package frc.robot;

public class Constants {
    /* General */
    //PDP and Pnuematic Hub CAN IDs
    public static final int PDP_ID = 1;
    public static final int PNUEMATIC_HUB_ID = 2;

    //Pneumatics
    public static final int DOUBLE_SOLENOID_LIFT_FWD = 0;
    public static final int DOUBLE_SOLENOID_LIFT_REV = 1;

    /* Drivetrain */
    //Drive Motor CAN IDs
    public static final int LEFT_FRONT_DRIVE_MOTOR_ID = 3;
    public static final int LEFT_BACK_DRIVE_MOTOR_ID = 4;
    public static final int RIGHT_FRONT_DRIVE_MOTOR_ID = 5;
    public static final int RIGHT_BACK_DRIVE_MOTOR_ID = 6;

    //Invert Drive Motors
    public static final boolean LEFT_DRIVE_INVERTED = true;
    public static final boolean RIGHT_DRIVE_INVERTED = false;


    /* Extender */
    //Extender Motor CAN IDs
    public static final int EXTENDER_LEFT_MOTOR_ID = 7;
    public static final int EXTENDER_RIGHT_MOTOR_ID = 8;

    //Invert Extender Motors
    public static final boolean LEFT_EXTENDER_INVERTED = false;
    public static final boolean RIGHT_EXTENDER_INVERTED = true;

    //Extender Power Percentage
    public static final double EXTENDER_POWER_PERCENTAGE = 0.1; 

    //Extender Setpoints (revolutions)
    public static final double EXTENDER_START_POS = 0.0;
    public static final double EXTENDER_LOW_POS = 12.0;
    public static final double EXTENDER_MID_POS = 24.0;
    public static final double EXTENDER_HIGH_POS = 36.0;

    //Extender PID Values
    public static final double EXTENDER_KP = 0.0;
    public static final double EXTENDER_KI = 0.0;
    public static final double EXTENDER_KD = 0.0;
    public static final double EXTENDER_TOLERANCE = 0.2;


    /* Control Systems */
    //Controller 
    public static final int MAIN_CONTROLLER_PORT_ID = 0;
    public static final int MAIN_RIGHT_VERTICAL_JOYSTICK_AXIS = 5;
    public static final int MAIN_RIGHT_HORIZONTAL_JOYSTICK_AXIS = 4;
    public static final int MAIN_LEFT_VERTICAL_JOYSTICK_AXIS = 1;
    public static final int MAIN_LEFT_HORIZONTAL_JOYSTICK_AXIS = 0;
    public static final int MAIN_A_BUTTON = 1;
    public static final int MAIN_B_BUTTON = 2;
    public static final int MAIN_X_BUTTON = 3;
}
