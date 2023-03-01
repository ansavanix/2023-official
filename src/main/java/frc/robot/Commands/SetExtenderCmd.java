package frc.robot.Commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.Subsystems.ExtenderSys;

public class SetExtenderCmd extends CommandBase{
    private ExtenderSys subsystem;
    
    //PID Controller
    private final PIDController pidController;

    public SetExtenderCmd() {
        subsystem = Robot.extenderSubsystem;
        addRequirements(subsystem);

        //Initialize PID Controller
        pidController = new PIDController(Constants.EXTENDER_KP, Constants.EXTENDER_KI, Constants.EXTENDER_KD);
        pidController.setTolerance(Constants.EXTENDER_TOLERANCE);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        double pos = subsystem.getEncoder();
        double run = pidController.calculate(pos, subsystem.getSetPoint());
        subsystem.extend(run);
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
