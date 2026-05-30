package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.controller.PIDController;
import com.pedropathing.follower.Follower;

import org.firstinspires.ftc.teamcode.HardwareRobot;

public class TurretSubsystem {
    public HardwareRobot hardwareRobot;
    public static double MAX_TICKS = 1000;
    public PIDController pid;
    public static double kP = 0.0001;
    public static double kD = 0.00005;
    public static double kI = 0.001;
    public TurretSubsystem(HardwareRobot hardwareRobot) {
        this.hardwareRobot = hardwareRobot;
        this.pid = new PIDController(kP, kD, kI);
    }
    public double getPhi() {
        double ticks = hardwareRobot.turret.getCurrentPosition() % MAX_TICKS;
        return ticks / 360.0;
    }
    public void setPhi(double phi) {
        double error = getPhi() - phi;
        double power = pid.calculate(error, 0);
        double clamped = clamp(power);
        setPower(clamped);
    }
    public void setPID(double P, double D, double I) {
        kP = P;
        kD = D;
        kI = I;
    }
    public double clamp(double val) {
        return Math.max(-1, Math.min(1, val));
    }
    public void setPower(double p) {hardwareRobot.turret.set(p);}
    public void autoAim(Follower follower, double x, double y) {
        double tR = getPhi();
        double rF = Math.toDegrees(follower.getHeading());
        double gF = Math.toDegrees(Math.atan2(y - follower.getPose().getY(), x - follower.getPose().getX()));
        double tt = rF - gF;
        double angleError = tt - tR;
        double power = pid.calculate(angleError, 0);
        double clamped = clamp(power);
        setPower(clamped);
    }
}
