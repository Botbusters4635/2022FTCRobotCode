package org.firstinspires.ftc.teamcode.Robots.Vinz;

import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.Mechanisms.Chassis.Tank.TankConfig;
import org.firstinspires.ftc.teamcode.Mechanisms.Spinner.SpinnerConfig;

public class RobotConfig {

    static public TankConfig tankConfig = new TankConfig("frontLeftMotor", "backLeftMotor", "frontRightMotor", "backRightMotor", Motor.GoBILDA.RPM_223);

    static public SpinnerConfig spinnerConfig = new SpinnerConfig("spinnerMotor", Motor.GoBILDA.RPM_223);
    static public SpinnerConfig leftSpinnerConfig = new SpinnerConfig("leftSpinnerMotor", Motor.GoBILDA.RPM_223);

}
