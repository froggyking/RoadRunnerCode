package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
@Autonomous(name = "RedLeftStackAutonomousRRA")
public class LeftStackAutonomousRRA extends LinearOpMode {
    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);


        drive.setPoseEstimate(new Pose2d());

        Trajectory trajec1 = drive.trajectoryBuilder(new Pose2d())
                .strafeRight(20)
                .build();



        waitForStart();

        Pose2d poseEstimate = drive.getPoseEstimate();
        telemetry.addData("finalX", poseEstimate.getX());
        telemetry.addData("finalY", poseEstimate.getY());
        telemetry.addData("finalHeading", poseEstimate.getHeading());
        telemetry.update();

        if(isStopRequested()) return;

        drive.followTrajectory(trajec1);
    }
}
