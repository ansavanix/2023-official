package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PneumaticSys extends SubsystemBase {
    private PneumaticHub hub;

    //Double Solenoids
    private DoubleSolenoid liftSolenoid;

    public PneumaticSys() {
        hub = new PneumaticHub(Constants.PNUEMATIC_HUB_ID);

        liftSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, Constants.DOUBLE_SOLENOID_LIFT_FWD, Constants.DOUBLE_SOLENOID_LIFT_REV);
    }

    public void start() {
        hub.enableCompressorDigital();
    }

    public void stop() {
        hub.disableCompressor();
    }

    public void extend(boolean extended) {
        if(extended) {
            liftSolenoid.set(DoubleSolenoid.Value.kForward);
        } else {
            liftSolenoid.set(DoubleSolenoid.Value.kReverse);
        }
    }

    public void toggle() {
        liftSolenoid.toggle();
    }
}
