package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.controller.PIDController;
import com.pedropathing.follower.Follower;

import org.firstinspires.ftc.teamcode.HardwareRobot;

public class ShooterSubsystem {
    public HardwareRobot hardwareRobot;
    public double kP = 0.0005;
    public double kD = 0.00001;
    public double kI = 0.0001;
    public PIDController pid;
    public ShooterSubsystem(HardwareRobot hardwareRobot) {
        this.hardwareRobot = hardwareRobot;
        this.pid = new PIDController(kP, kD, kI);
    }
    public double getVelocity() {
        return -hardwareRobot.shooterOne.getCorrectedVelocity();
    }
    public void setVelocity(double velo) {
        double error = velo - getVelocity();
        double power = pid.calculate(error, 0);
        double clamped = clamp(power);
        setPower(clamped);
    }
    public void setPID(double kP, double kD, double kI) {
        this.kP = kP;
        this.kD = kD;
        this.kI = kI;
    }
    public void setPower(double p) {
        hardwareRobot.shooterOne.set(p);
    }
    public double clamp(double val) {
        return Math.max(-1, Math.min(1, val));
    }
    public void autoAim(double x, double y, Follower follower) {
        setPower(shooterRegression(x,y,follower));
    }
    public double shooterRegression(double x, double y, Follower follower) {
        double dist = Math.sqrt(Math.pow(x - follower.getPose().getX(),2) + Math.pow(y - follower.getPose().getY(),2));
        return (-0.0265 * Math.pow(dist,2)) + (11.5 * dist) + 580;
    }
}