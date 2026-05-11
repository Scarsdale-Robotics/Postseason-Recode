package org.firstinspires.ftc.teamcode;

import android.telephony.PhoneNumberFormattingTextWatcher;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.pedropathing.follower.Follower;
import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.Subsystems.CVSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.HoodSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.ShooterSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.TransferSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.TurretSubsystem;

public class RobotSystem {
    public HardwareRobot hardwareRobot;
    public DriveSubsystem drive;
    public CVSubsystem cv;
    public ShooterSubsystem shooter;
    public TurretSubsystem turret;
    public IntakeSubsystem intake;
    public HoodSubsystem hood;
    public TransferSubsystem transfer;
    public RobotSystem(HardwareMap hardwareMap, LinearOpMode opMode) {
        this.hardwareRobot = new HardwareRobot(hardwareMap);
        this.drive = new DriveSubsystem(hardwareRobot.leftFront, hardwareRobot.rightFront, hardwareRobot.leftBack, hardwareRobot.rightBack);
        this.cv = new CVSubsystem(hardwareRobot.webcam, opMode, 3);
        this.turret = new TurretSubsystem(hardwareRobot);
        this.shooter = new ShooterSubsystem(hardwareRobot);
        this.intake = new IntakeSubsystem(hardwareRobot);
        this.hood = new HoodSubsystem(hardwareRobot);
        this.transfer = new TransferSubsystem(hardwareRobot);
    }
    public void autoAim(double x, double y, Follower follower) {
        turret.autoAim(follower, x,y);
        shooter.autoAim(x,y, follower);
        hood.autoAim(x,y, follower);
    }
}