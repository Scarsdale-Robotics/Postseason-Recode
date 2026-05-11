package org.firstinspires.ftc.teamcode.TeleOp;

import com.bylazar.configurables.annotations.Configurable;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotSystem;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Configurable
@TeleOp(name = "TeleopBasic")
public class TeleopBasic extends LinearOpMode {
    public RobotSystem robot;
    public Follower follower;
    public Pose startPose = new Pose(56, 8, 90);
    public static double x = 103;
    public static double y = 50;
    @Override
    public void runOpMode() throws InterruptedException {
        this.robot = new RobotSystem(hardwareMap, this);
        this.follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(startPose);
        waitForStart();
        while (opModeIsActive()) {
            follower.update();
            robot.autoAim(x,y, follower);
            if (gamepad1.right_bumper) robot.intake.setPower(1);
            else if (gamepad1.left_bumper) robot.intake.setPower(-1);
            else robot.intake.setPower(0);
            double strafe = gamepad1.left_stick_x;
            double forward = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            robot.drive.driveRobotCentricReal(strafe * 0.7, forward * 0.7, turn * 0.7);
            if (gamepad1.right_trigger > 0) robot.transfer.shoot();
            else robot.transfer.normal();
            telemetry.update();
        }
    }
}
