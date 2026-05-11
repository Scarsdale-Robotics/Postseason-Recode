package org.firstinspires.ftc.teamcode.Subsystems;

import com.pedropathing.follower.Follower;

import org.firstinspires.ftc.teamcode.HardwareRobot;

public class HoodSubsystem {
    public HardwareRobot hardwareRobot;
    public HoodSubsystem(HardwareRobot hardwareRobot) {
        this.hardwareRobot = hardwareRobot;
    }
    public void setPosition(double pos) {
        hardwareRobot.hoodServo.setPosition(pos);
    }
    public void autoAim(double x, double y, Follower follower) {
        setPosition(hoodAngle(x,y,follower));
    }
    public double hoodAngle(double x, double y, Follower follower) {
        double dist = Math.sqrt(Math.pow(x - follower.getPose().getX(),2) + Math.pow(y - follower.getPose().getY(), 2));
        return (-0.000687 * dist) + 0.207;
    }
}
