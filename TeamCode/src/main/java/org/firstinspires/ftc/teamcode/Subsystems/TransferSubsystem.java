package org.firstinspires.ftc.teamcode.Subsystems;

import org.firstinspires.ftc.teamcode.HardwareRobot;

public class TransferSubsystem {
    public HardwareRobot hardwareRobot;
    public double MAGBLOCK_DOWN = 0.1;
    public double MAGBLOCK_UP = 0.5;
    public TransferSubsystem(HardwareRobot hardwareRobot) {
        this.hardwareRobot = hardwareRobot;
    }
    public void setPower(double p){hardwareRobot.transferMotor.set(p);}
    public void magBlockUp(){hardwareRobot.magBlock.setPosition(MAGBLOCK_UP);}
    public void magBlockDown(){hardwareRobot.magBlock.setPosition(MAGBLOCK_DOWN);}
    public void shoot() {
        magBlockUp();
        setPower(1);
    }
    public void normal() {
        magBlockDown();
        setPower(0);
    }
}
