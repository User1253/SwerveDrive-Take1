package frc.robot;


import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;


public class Constants {

    public static final double LF_Z = 0.089111328125; 
    public static final double RF_Z = 0.112548828125; 
    public static final double LB_Z = -0.18212890625; 
    public static final double RB_Z = 0.147216796875;
    
    public static final double WR = Units.inchesToMeters(2); 

    public static final double DGR = 5.902777777777778;
    public static final double SGR = 21.428571428571427; 

    public static final double D_MPR = 2 * Math.PI * WR / DGR; 
    public static final double T_RPR = 2 * Math.PI / SGR; 

    public static final Translation2d leftFrontModuleOffset = new Translation2d(11.5, 11.5); 
    public static final Translation2d leftBackModuleOffset = new Translation2d(-11.5, 11.5); 
    public static final Translation2d rightFrontModuleOffset = new Translation2d(11.5, -11.5); 
    public static final Translation2d rightBackModuleOffset = new Translation2d(-11.5, -11.5); 

    public static final double D_KFF = 0.124; 
    public static final double D_KP = 1.2;
    public static final double D_KI = 0.0;
    public static final double D_KD = 0.0;

    public static final double T_KP = 100.0;
    public static final double T_KI = 0.0;
    public static final double T_KD = 0.5;



}
