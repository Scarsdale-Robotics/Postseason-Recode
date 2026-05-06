package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class HardwareRobot {
    public final Motor leftBack;
    public final Motor leftFront;
    public final Motor rightBack;
    public final Motor rightFront;
    public final GoBildaPinpointDriver pinpoint;
    public final WebcamName webcam;
    public final Motor shooterOne;
    public final Motor shooterTwo;
    public final Motor intake;
    public final Servo intakeServo;
    public final Motor transferMotor;

    public HardwareRobot(HardwareMap hardwareMap) {
        leftFront = new Motor(hardwareMap, "leftFront", Motor.GoBILDA.RPM_312);
        rightFront = new Motor(hardwareMap, "rightFront", Motor.GoBILDA.RPM_312);
        leftBack = new Motor(hardwareMap, "leftBack", Motor.GoBILDA.RPM_312);
        rightBack = new Motor(hardwareMap, "rightBack", Motor.GoBILDA.RPM_312);
        shooterOne = new Motor(hardwareMap, "shooterOne", Motor.GoBILDA.RPM_1620);
        shooterTwo = new Motor(hardwareMap, "shooterTwo", Motor.GoBILDA.RPM_1620);
        intake = new Motor(hardwareMap, "intake", Motor.GoBILDA.RPM_1620);
        transferMotor = new Motor(hardwareMap, "intake", Motor.GoBILDA.RPM_1620);

        leftFront.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        shooterOne.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        shooterTwo.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intake.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        transferMotor.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        leftFront.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBack.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shooterOne.motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shooterTwo.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intake.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        transferMotor.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftFront.setRunMode(Motor.RunMode.RawPower);
        rightFront.setRunMode(Motor.RunMode.RawPower);
        leftBack.setRunMode(Motor.RunMode.RawPower);
        rightBack.setRunMode(Motor.RunMode.RawPower);
        shooterOne.setRunMode(Motor.RunMode.RawPower);
        shooterTwo.setRunMode(Motor.RunMode.RawPower);
        intake.setRunMode(Motor.RunMode.RawPower);
        transferMotor.setRunMode(Motor.RunMode.RawPower);

        leftFront.setInverted(true);
        rightFront.setInverted(true);
        leftBack.setInverted(true);
        rightBack.setInverted(true);
        shooterOne.setInverted(false);
        shooterTwo.setInverted(false);
        intake.setInverted(false);
        transferMotor.setInverted(false);

        leftFront.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intake.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        transferMotor.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftFront.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        intake.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        transferMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        webcam = hardwareMap.get(WebcamName.class,  "Webcam 1");

        intakeServo = hardwareMap.get(Servo.class, "intakeServo");

        pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");
    }
}