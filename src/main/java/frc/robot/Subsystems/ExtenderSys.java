package frc.robot.Subsystems;

import java.util.Date;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ExtenderSys extends SubsystemBase {
    
    //Extender Motors
    private final CANSparkMax leftMotor;
    private final CANSparkMax rightMotor;

    //Extender Encoders
    public final RelativeEncoder leftEncoder;
    public final RelativeEncoder rightEncoder;

    //curr setpoint
    private int currSetpoint;

    //control var
    private long ctrl;
    private long ctrl2;

    public ExtenderSys() {
        //Initialize Extender motor controllers
        leftMotor = new CANSparkMax(Constants.EXTENDER_LEFT_MOTOR_ID, MotorType.kBrushless);
        rightMotor = new CANSparkMax(Constants.EXTENDER_RIGHT_MOTOR_ID, MotorType.kBrushless);
        
        //Initialize Extender encoders 
        leftEncoder = leftMotor.getEncoder();
        rightEncoder = rightMotor.getEncoder();

        //Verify encoders are zeroed
        resetEncoders();

        //Invert motors
        leftMotor.setInverted(Constants.LEFT_EXTENDER_INVERTED);
        rightMotor.setInverted(Constants.RIGHT_EXTENDER_INVERTED);
        
        //Set motor breaks
        if(Constants.EXTEDNER_MOTOR_BRAKE) {
            leftMotor.setIdleMode(IdleMode.kBrake);
            rightMotor.setIdleMode(IdleMode.kBrake);
        } else {
            leftMotor.setIdleMode(IdleMode.kCoast);
            rightMotor.setIdleMode(IdleMode.kCoast);
        }

        //setpoint
        currSetpoint = 0;

        //set control var
        ctrl = 0L;
        ctrl2 = 0L;
    }

    //Extender power
    public void extend(double speed) {
        leftMotor.set(Constants.EXTENDER_POWER_PERCENTAGE * speed);
        rightMotor.set(Constants.EXTENDER_POWER_PERCENTAGE * speed);
        if(speed > 0 && ctrl == 0L) {
            Date date1 = new Date();
            System.out.println("Positive at: " + date1.getTime());
            ctrl = date1.getTime();
        } else if (speed < 0 && ctrl2 == 0L) {
            Date date2 = new Date(); 
            System.out.println("Negative at: " + date2.getTime());
            ctrl2 = date2.getTime();
        } else if (speed > 0 && ctrl2 != 0L) {
            Date date3 = new Date();
            long timeDif = date3.getTime() - ctrl;
            System.out.println("Difference: " + timeDif);
            ctrl = 0L;
            ctrl2 = 0L;
        }
    }
    public void stop() {
        extend(0);
        //ctrl = 0;
    }

    //Set Extender set point
    public void setSetPoint(int position) {
        currSetpoint = position;
    }

    public void incrementSetPoint() {
        if(currSetpoint < 3) currSetpoint++;
    }

    public void decrementSetPoint() {
        if(currSetpoint > 0) currSetpoint--;
    }

    //get Extender set point
    public double getSetPoint() {
        switch(currSetpoint) {
            case 0: return Constants.EXTENDER_START_POS;
            case 1: return Constants.EXTENDER_LOW_POS;
            case 2: return Constants.EXTENDER_MID_POS;
            case 3: return Constants.EXTENDER_HIGH_POS;
        }
        return Constants.EXTENDER_START_POS;
    }

    //Reset Encoders to 0
    public void resetEncoders() {
        leftEncoder.setPosition(0);
        rightEncoder.setPosition(0);
    }

    public double getEncoder() {
        return leftEncoder.getPosition();
        //return (leftEncoder.getPosition() + rightEncoder.getPosition()) / 2.0;
    }

}
