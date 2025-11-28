// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.SwervedriveSubsystem;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.geometry.Rotation2d;



/** Add your docs here. */
public class ModuleIOTalonFX extends ModuleIO{

    TalonFX drive;  
    TalonFX turn; 

    double D_MPR = 0.0; 
    double T_RPR = 0.0; 

      

    double zero = 0.0; 


    public ModuleIOTalonFX(int AE_ID, int drive_ID, int turn_ID, double D_KFF, double D_KP, double D_KI, double D_KD, double T_KP, double T_KI, double T_KD, double zero, double D_MPR, double T_RPR){
        this.zero = zero; 
        this.D_MPR = D_MPR; 
        this.T_RPR = T_RPR; 
        

        this.drive = new TalonFX(drive_ID);
        this.turn = new TalonFX(turn_ID); 

        TalonFXConfiguration driveConfig = new TalonFXConfiguration(); 
        TalonFXConfiguration turnConfig = new TalonFXConfiguration(); 
        driveConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake; 
        turnConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake; 

        driveConfig.Slot0.kV = D_KFF; 
        driveConfig.Slot0.kP = D_KP;
        driveConfig.Slot0.kI = D_KI;  
        driveConfig.Slot0.kD = D_KD; 

        turnConfig.Slot0.kP = T_KP;
        turnConfig.Slot0.kI = T_KI;
        turnConfig.Slot0.kD = T_KD; 

        turnConfig.Feedback.FeedbackRemoteSensorID = AE_ID; 

        StatusCode configDriveStatus = this.drive.getConfigurator().apply(driveConfig);
        StatusCode configTurnStatus = this.drive.getConfigurator().apply(driveConfig);

        while (!configDriveStatus.isOK()) configDriveStatus = this.drive.getConfigurator().apply(driveConfig);
        while (!configTurnStatus.isOK()) configTurnStatus = this.turn.getConfigurator().apply(turnConfig);
    }


    @Override
    public double getSpeed(){
        return this.drive.getVelocity().getValueAsDouble() * D_MPR; 
    }

    @Override
    public void setSpeed(double speed){
        this.drive.setControl(new VelocityVoltage(speed/this.D_MPR)); 
    }

    @Override
    public Rotation2d getOrientation(){
        return Rotation2d.fromRadians((this.turn.getPosition().getValueAsDouble() - this.zero) * this.T_RPR);
    }

    @Override 
    public void setOrientation(Rotation2d orientation){
        this.turn.setControl(new PositionVoltage((orientation.getRadians() + this.zero ) / this.T_RPR));
    }

    @Override
    public void setOrientationOffset(double offset){
        this.zero = offset; 
    }


}
