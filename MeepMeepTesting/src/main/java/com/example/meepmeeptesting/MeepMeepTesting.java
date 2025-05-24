package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.rowlandhall.meepmeep.MeepMeep;
import org.rowlandhall.meepmeep.roadrunner.DefaultBotBuilder;
import org.rowlandhall.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setDimensions(15, 14)
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(-36,68, Math.toRadians(180)))
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
                        .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_KAI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}