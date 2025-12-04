// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.SwervedriveSubsystem;

import edu.wpi.first.math.geometry.Rotation2d;

/** Add your docs here. */
public interface ModuleIO {
    public abstract double getSpeed(); 
    public abstract void setSpeed(double speed); 
    public abstract Rotation2d getOrientation(); 
    public abstract void setOrientation(Rotation2d orientation);
    public abstract void setOrientationOffset(double offset); 
}
