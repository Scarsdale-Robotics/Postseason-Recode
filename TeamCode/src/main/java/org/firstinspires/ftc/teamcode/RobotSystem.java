package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
public class RobotSystem {
    public HardwareRobot hardwareRobot;
    public MecanumDrive drive;
    public RobotSystem(HardwareMap hardwareMap, LinearOpMode opMode) {
        this.hardwareRobot = new HardwareRobot(hardwareMap);
        this.drive = new MecanumDrive(hardwareRobot.leftFront, hardwareRobot.rightFront, hardwareRobot.leftBack, hardwareRobot.rightBack);
    }
}