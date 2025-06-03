package org.firstinspires.ftc.teamcode.opModes;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.robot.Robot;
import org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasinferiores.BracoGarra;
import org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasinferiores.SubsistemasInferiores;
import org.firstinspires.ftc.teamcode.robot.vision.AprilTagDetectorID;

@Config
@Autonomous(name = "CocaColaZero🥤", group = "Autonomous")
public class AutoDaBarcaDoInferno extends LinearOpMode {

    Robot robot;

    AprilTagDetectorID limelight;

    public Action estaciona;

    public Action estacionamento2(){
        return robot.md.actionBuilder(new Pose2d(-36,68, Math.toRadians(180)))
                .splineToConstantHeading(new Vector2d(-36, 36), Math.toRadians(90))
                .build();
    }

    public Action estacionamento1(){
        return robot.md.actionBuilder(new Pose2d(-36,68, Math.toRadians(180)))
                .splineToConstantHeading(new Vector2d(-13, 36), Math.toRadians(90))
                .build();
    }

    public Action estacionamento3(){
        return robot.md.actionBuilder(new Pose2d(-36,68, Math.toRadians(180)))
                .splineToLinearHeading(new Pose2d(-59, 13, Math.toRadians(180)), Math.toRadians(180))
                .build();
    }

    @Override
    public void runOpMode() {



        waitForStart();

        //criar if para estacionamento aqui

        if (limelight.detectAprilTagId() == 6){
            estaciona = estacionamento1();
        }
        if (limelight.detectAprilTagId() == 7){
            estaciona = estacionamento2();
        }
        if (limelight.detectAprilTagId() == 8){
            estaciona = estacionamento3();
        }
        if (limelight.detectAprilTagId() == 24){
            estaciona = estacionamento2();
        }


        Actions.runBlocking(
                estaciona
        );



    }
}
