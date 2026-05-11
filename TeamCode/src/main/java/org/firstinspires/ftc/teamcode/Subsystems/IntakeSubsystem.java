package org.firstinspires.ftc.teamcode.Subsystems;

import org.firstinspires.ftc.teamcode.HardwareRobot;

public class IntakeSubsystem {
    public HardwareRobot hardwareRobot;
    public IntakeSubsystem(HardwareRobot hardwareRobot) {
        this.hardwareRobot = hardwareRobot;
    }
    public void setPower(double p) {hardwareRobot.intake.set(p);}
}
