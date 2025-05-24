package org.firstinspires.ftc.teamcode.opModes;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Config
@Autonomous(name = "CocaColaZero", group = "Autonomous")
public class AutoDaBarcaDoInferno extends LinearOpMode {

    @Override
    public void runOpMode() {
                .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(-30, 28), Math.toRadians(-45))
                .setTangent(Math.toRadians(-90))
                .splineToSplineHeading(new Pose2d(-59, 13, Math.toRadians(180)), Math.toRadians(180))
                .setTangent(Math.toRadians(0))
                .splineToLinearHeading(new Pose2d(-29, 20, Math.toRadians(-130)), Math.toRadians(45))
                .setTangent(Math.toRadians(-90))
                .splineToSplineHeading(new Pose2d(-59, 13, Math.toRadians(180)), Math.toRadians(180))
                .setTangent(Math.toRadians(0))
                .splineToLinearHeading(new Pose2d(-29, 20, Math.toRadians(-130)), Math.toRadians(45))
                .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(-36, 36), Math.toRadians(90))
                .build();
        public Action goToDeposit(){
            return robot.md.actionBuilder(robot.md.pose)
                    .strafeTo(new Vector2d(-6,-22))
                    .splineToConstantHeading(new Vector2d(-6, -26), Math.toRadians(90))
                    .build();

        }
    }
}
