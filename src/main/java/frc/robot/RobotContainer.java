// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.Subsystems.SwervedriveSubsystem.ModuleIOTalonFX;
import frc.robot.Subsystems.SwervedriveSubsystem.Pidgeon2GyroIO;
import frc.robot.Subsystems.SwervedriveSubsystem.Swervedrive;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  Swervedrive swervedrive; 

  CommandXboxController controller; 

  

  public RobotContainer() {
    swervedrive = new Swervedrive(
    new ModuleIOTalonFX(RobotMap.AE_LEFT_FRONT_ID, RobotMap.LEFT_FRONT_DRIVE, RobotMap.LEFT_FRONT_TURN, Constants.D_KFF, Constants.D_KP, Constants.D_KI, Constants.D_KD, Constants.T_KP, Constants.T_KI, Constants.T_KD, Constants.LF_Z, Constants.D_MPR, Constants.T_RPR),
    new ModuleIOTalonFX(RobotMap.AE_RIGHT_FRONT_ID, RobotMap.RIGHT_FRONT_DRIVE, RobotMap.RIGHT_FRONT_TURN, Constants.D_KFF, Constants.D_KP, Constants.D_KI, Constants.D_KD, Constants.T_KP, Constants.T_KI, Constants.T_KD, Constants.RF_Z, Constants.D_MPR, Constants.T_RPR),
    new ModuleIOTalonFX(RobotMap.AE_LEFT_BACK_ID, RobotMap.LEFT_BACK_DRIVE, RobotMap.LEFT_BACK_TURN, Constants.D_KFF, Constants.D_KP, Constants.D_KI, Constants.D_KD, Constants.T_KP, Constants.T_KI, Constants.T_KD, Constants.LB_Z, Constants.D_MPR, Constants.T_RPR),
    new ModuleIOTalonFX(RobotMap.AE_RIGHT_BACK_ID, RobotMap.RIGHT_BACK_DRIVE, RobotMap.RIGHT_BACK_TURN, Constants.D_KFF, Constants.D_KP, Constants.D_KI, Constants.D_KD, Constants.T_KP, Constants.T_KI, Constants.T_KD, Constants.RB_Z, Constants.D_MPR, Constants.T_RPR), Constants.leftFrontModuleOffset, Constants.rightFrontModuleOffset, Constants.leftBackModuleOffset, Constants.rightBackModuleOffset, new Pidgeon2GyroIO()); 
    controller = new CommandXboxController(0); 
    configureBindings();
  }

  private void configureBindings() {
    this.swervedrive.setDefaultCommand(this.swervedrive.SwervedriveArcadeCommand(() -> this.controller.getLeftX(), () -> this.controller.getLeftY(), () -> this.controller.getRightY()));


  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
