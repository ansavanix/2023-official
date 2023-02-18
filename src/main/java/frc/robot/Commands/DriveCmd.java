package frc.robot.Commands;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.Subsystems.DriveSys;

public class DriveCmd extends CommandBase {
    
    private DriveSys subsystem;
    SendableChooser<Boolean> driveChooser = new SendableChooser<Boolean>(); // Create a chooser to select between tank drive and arcade drive

    public DriveCmd() {
        subsystem = Robot.driveSubsystem;   
        addRequirements(subsystem);

        // Drive Modes //
        driveChooser.setDefaultOption("Tank Drive", true);
        driveChooser.addOption("Arcade Drive", false);
    
        SmartDashboard.putData("Drive Mode", driveChooser);
      }
    
      // Called once when the command is initially scheduled.
      @Override
      public void initialize() {}
    
      // Called every time the scheduler runs while the command is scheduled.
      @Override
      public void execute() {
        if (driveChooser.getSelected()) { // Tank Drive
          Double left_power = Robot.controller.getRawAxis(Constants.MAIN_LEFT_VERTICAL_JOYSTICK_AXIS); // -1 inverts the controller axis
          Double right_power = Robot.controller.getRawAxis(Constants.MAIN_RIGHT_VERTICAL_JOYSTICK_AXIS); // -1 inverts the controller axis
          subsystem.drive(left_power, right_power);
        } else { // Arcade Drive
          Double turning_power = Robot.controller.getRawAxis(Constants.MAIN_RIGHT_HORIZONTAL_JOYSTICK_AXIS);
          Double drive_power = Robot.controller.getRawAxis(Constants.MAIN_LEFT_VERTICAL_JOYSTICK_AXIS);
          subsystem.drive(drive_power - turning_power, drive_power + turning_power);
        }
      }
    
      // Called once the command ends or is interrupted.
      @Override
      public void end(boolean interrupted) {
        subsystem.stop();
      }
    
      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        return false; // Command will never finish (we don't want it to)
      }
}
