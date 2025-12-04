// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.SwervedriveSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;

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
  public Swervedrive(ModuleIO leftFrontIO, ModuleIO rightFrontIO, ModuleIO leftBackIO, ModuleIO rightBackIO, Translation2d leftFrontModuleOffset,Translation2d rightFrontModuleOffset,Translation2d leftBackModuleOffset,Translation2d rightBackModuleOffset, GyroIO gyro) {
    this.leftFrontModule = new Module(leftFrontIO); 
    this.leftBackModule = new Module(leftBackIO);
    this.RightFrontModule = new Module(rightFrontIO);
    this.RightBackModule = new Module(rightBackIO);
    this.gyro = gyro;
    this.mKinematics = new SwerveDriveKinematics(leftFrontModuleOffset, leftBackModuleOffset, rightFrontModuleOffset, rightBackModuleOffset);
  }


public Command SwervedriveArcadeCommand(DoubleSupplier vx, DoubleSupplier vy, DoubleSupplier omega){
    ChassisSpeeds rRS = new ChassisSpeeds(vx.getAsDouble(), vy.getAsDouble(), omega.getAsDouble());
    ChassisSpeeds fRS = ChassisSpeeds.fromRobotRelativeSpeeds(rRS, this.gyro.getOrientation()); 
    SwerveModuleState[] state = this.mKinematics.toSwerveModuleStates(fRS); 
    return this.run(() -> {this.leftFrontModule.setState(state[0]); this.RightFrontModule.setState(state[1]); this.leftBackModule.setState(state[2]); this.RightBackModule.setState(state[3]);}); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
