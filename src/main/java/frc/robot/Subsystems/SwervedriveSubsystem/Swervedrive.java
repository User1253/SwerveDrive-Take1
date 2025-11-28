// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.SwervedriveSubsystem;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Swervedrive extends SubsystemBase {

  SwerveDriveKinematics mKinematics; 

  Module leftFrontModule;
  Module leftBackModule;
  Module RightFrontModule;
  Module RightBackModule;


  GyroIO gyro; 



  /** Creates a new Drivetrain. */
  public Swervedrive(ModuleIO leftFrontIO, ModuleIO rightFrontIO, ModuleIO leftBackIO, ModuleIO rightBackIO, Translation2d leftFrontModuleOffset,Translation2d rightFrontModuleOffset,Translation2d leftBackModuleOffset,Translation2d rightBackModuleOffset) {
    this.leftFrontModule = new Module(leftFrontIO); 
    this.leftBackModule = new Module(leftBackIO);
    this.RightFrontModule = new Module(rightFrontIO);
    this.RightBackModule = new Module(rightBackIO);
    this.gyro = gyro;
    this.mKinematics = new SwerveDriveKinematics(leftFrontModuleOffset, leftBackModuleOffset, rightFrontModuleOffset, rightBackModuleOffset);
  }


public Command SwervedriveArcadeCommand(LinearVelocity vx, LinearVelocity vy, LinearVelocity omega){
    ChassisSpeeds rRS = new ChassisSpeeds(vx.get(), vy.get(), omega.get());
    ChassisSpeeds fRS = new ChassisSpeeds(); 
    SwerveModuleState[] state = this.mKinematics.toSwerveModuleStates(fRS); 
    return this.leftFrontModule.setState(state);
    this.leftBackModule.setState(state); 
    this.RightFrontModule.setState(state);
    this.RightBackModule.setState(state);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
