package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.Subsystems.ExtenderSys;

public class ExtenderCmd extends CommandBase {
    
    private ExtenderSys subsystem;

    public ExtenderCmd() {
        subsystem = Robot.extenderSubsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        if(Robot.controller.getRawButton(Constants.MAIN_A_BUTTON)) {
            subsystem.extend(1);
        } else if(Robot.controller.getRawButton(Constants.MAIN_B_BUTTON)) {
            subsystem.extend(-1);
        } else {
            subsystem.stop();
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
