package frc.robot.Subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveSys extends SubsystemBase {
    
    //Drivetrain Motors
    private final CANSparkMax leftFrontMotor;
    private final CANSparkMax leftBackMotor;
    private final CANSparkMax rightFrontMotor;
    private final CANSparkMax rightBackMotor;

    private double drivePowerPercent;

    public DriveSys() {
        //initialize the Drivetrain motor controllers
        leftFrontMotor = new CANSparkMax(Constants.LEFT_FRONT_DRIVE_MOTOR_ID, MotorType.kBrushless);
        leftBackMotor = new CANSparkMax(Constants.LEFT_BACK_DRIVE_MOTOR_ID, MotorType.kBrushless);
        rightFrontMotor = new CANSparkMax(Constants.RIGHT_FRONT_DRIVE_MOTOR_ID, MotorType.kBrushless);
        rightBackMotor = new CANSparkMax(Constants.RIGHT_BACK_DRIVE_MOTOR_ID, MotorType.kBrushless);
        
        //Invert motors
        leftFrontMotor.setInverted(Constants.LEFT_DRIVE_INVERTED);
        leftBackMotor.setInverted(Constants.LEFT_DRIVE_INVERTED);
        rightFrontMotor.setInverted(Constants.RIGHT_DRIVE_INVERTED);
        rightBackMotor.setInverted(Constants.RIGHT_DRIVE_INVERTED);
    
        //Set drive power
        drivePowerPercent = 0.6;
    }

    //Drivetrain power
    public void drive(double leftPower, double rightPower) {
        leftFrontMotor.set(leftPower * drivePowerPercent);
        leftBackMotor.set(leftPower * drivePowerPercent);
        rightFrontMotor.set(rightPower * drivePowerPercent);
        rightBackMotor.set(rightPower * drivePowerPercent);
    }
    public void stop() {
        drive(0,0);
    }

}
