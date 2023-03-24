package frc.robot.Subsystems;
//We need to get the library from the vendor.
//See: https://docs.wpilib.org/en/stable/docs/software/vscode-overview/3rd-party-libraries.html#rd-party-libraries.
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClawSys extends SubsystemBase {
    private double CLAW_MOTOR_SPEED = 0.05; // -1.0 <= SPEED <= 1.0
    private WPI_VictorSPX clawMotor;
    
    public ClawSys() {
        clawMotor = new WPI_VictorSPX(Constants.CLAW_MOTOR_ID);
    }
    
    public void closeClaw() {
        clawMotor.set(CLAW_MOTOR_SPEED);
    }
    
    public void openClaw() {
        clawMotor.set(-CLAW_MOTOR_SPEED);
    }
    
    public void stop() {
        clawMotor.stopMotor();
    }
}
