// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.OperatorConstants.DRIVE_SCALING;
import static frc.robot.Constants.OperatorConstants.ROTATION_SCALING;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.RobotModeTriggers;
import frc.robot.subsystems.CANDriveSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Drive extends Command {
  /** Creates a new Drive. */
  double fixSign;
  double joyLeftY, joyRightX;

  CANDriveSubsystem driveSubsystem;
  CommandXboxController controller;
  SlewRateLimiter smoothMove = new SlewRateLimiter( 4);
  

  public Drive(CANDriveSubsystem driveSystem, CommandXboxController driverController) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSystem);
    driveSubsystem = driveSystem;
    controller = driverController;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  // The Y axis of the controller is inverted so that pushing the
  // stick away from you (a negative value) drives the robot forwards (a positive
  // value). The X axis is scaled down so the rotation is more easily
  // controllable.
  @Override
  public void execute() {
    driveSubsystem.driveArcade(smoothMove.calculate(squareInput(controller.getLeftY()) * DRIVE_SCALING), squareInput(controller.getRightX()) * ROTATION_SCALING);
  }

  public double filterDrive(double Input){
    double fixSign = 1;
    if(Input < 0){
      fixSign = -1;
    }

    //Squared inputs sent through a slew rate limiter
    //return smoothMove.calculate(Input * Input * fixSign);
    return 0;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSubsystem.driveArcade(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public double squareInput(double input){
    double verboseVal;
    int multiplier = 1;
    if(input < 0){
      //input negative, remember sign
      multiplier = -1;
    }
    verboseVal = input * input;
    return verboseVal * multiplier;
  }
}
