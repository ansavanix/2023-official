package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ExtenderSys extends SubsystemBase {
    
    //Extender Motors
    private final CANSparkMax leftMotor;
    private final CANSparkMax rightMotor;

    //Extender Speed
    private double extenderPowerPercent;

    public ExtenderSys() {
        //Initialize Extender motor controllers
        leftMotor = new CANSparkMax(Constants.EXTENDER_LEFT_MOTOR_ID, MotorType.kBrushless);
        rightMotor = new CANSparkMax(Constants.EXTENDER_RIGHT_MOTOR_ID, MotorType.kBrushless);
        
        //Invert motors
        leftMotor.setInverted(Constants.LEFT_EXTENDER_INVERTED);
        rightMotor.setInverted(Constants.RIGHT_EXTENDER_INVERTED);

        //Set extender power
        extenderPowerPercent = 0.1;
    }

    //Extender power
    public void extend(int direction) {
        leftMotor.set(extenderPowerPercent * direction);
        rightMotor.set(extenderPowerPercent * direction);
    }
    public void stop() {
        extend(0);
    }

}
