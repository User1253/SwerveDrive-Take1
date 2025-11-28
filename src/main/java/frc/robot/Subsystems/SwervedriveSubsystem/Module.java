package frc.robot.Subsystems.SwervedriveSubsystem;

import edu.wpi.first.math.kinematics.SwerveModuleState;

public class Module {
    ModuleIO io; 

    public Module(ModuleIO io) {
        this.io = io; 
    }

    public void setState(SwerveModuleState state) {
        state.optimize(this.io.getOrientation());
        this.io.setSpeed(state.speedMetersPerSecond);
        this.io.setOrientation(state.angle);
    }

}
