package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.Subsystems.PneumaticSys;

public class PneumaticCmd extends CommandBase {
    private PneumaticSys subsystem;

    public PneumaticCmd() {
        subsystem = Robot.pneumaticSubsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        subsystem.start();
        subsystem.extend(true);
    }

    @Override
    public void execute() {
        if(Robot.controller.getRawButtonPressed(Constants.MAIN_X_BUTTON)) {
            subsystem.toggle();
        }
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
