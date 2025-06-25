package org.firstinspires.ftc.teamcode.opModes;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.robot.Robot;
import org.firstinspires.ftc.teamcode.robot.vision.AprilTagDetectorID;

@Config
@Autonomous(name = "CocaColaZero🥤", group = "Autonomous")
public class AutoDaBarcaDoInferno extends LinearOpMode {

    Robot robot;
    AprilTagDetectorID limelight;
    public Action estaciona;

    /**************************************************
     *             Ations de Movimentação             *
     **************************************************/

    public Action estacionamento1(){
        return robot.md.actionBuilder(new Pose2d(-36,68, Math.toRadians(180)))
                .setTangent(Math.toRadians(-90))
                .splineToLinearHeading(new Pose2d(-32, 34, Math.toRadians(180)), Math.toRadians(90))
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-12, 37), Math.toRadians(90))
                .build();
    }

    public Action estacionamento2(){
        return robot.md.actionBuilder(new Pose2d(-36,68, Math.toRadians(180)))
                .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(-36, 36), Math.toRadians(90))
                .build();
    }

    public Action estacionamento3(){
        return robot.md.actionBuilder(new Pose2d(-36,68, Math.toRadians(180)))
                .setTangent(Math.toRadians(-90))
                .splineToLinearHeading(new Pose2d(-59, 13, Math.toRadians(180)), Math.toRadians(180))
                .build();
    }

    public Action cone1(){
        return robot.md.actionBuilder(new Pose2d(-36,68, Math.toRadians(180)))
                .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(-30, 28), Math.toRadians(-45))
                .build();
    }

    public Action pegarCone2(){
        return robot.md.actionBuilder(new Pose2d(-36,68, Math.toRadians(180)))
                .setTangent(Math.toRadians(-90))
                .splineToSplineHeading(new Pose2d(-59, 13, Math.toRadians(180)), Math.toRadians(180))
                .build();
    }

    public Action cone2(){
        return robot.md.actionBuilder(new Pose2d(-36,68, Math.toRadians(180)))
                .build();
    }

    public Action pegarCone3(){
        return robot.md.actionBuilder(new Pose2d(-36,68, Math.toRadians(180)))
                .build();
    }

    public Action cone3(){
        return robot.md.actionBuilder(new Pose2d(-36,68, Math.toRadians(180)))
                .build();
    }

    /**************************************************
     *             Ations dos Subsistemas             *
     **************************************************/

    public Action outtakeCone1(){
        return  robot.subsistemasSuperiores.goToReadyToOuttake();
    }

    public Action intakeCone2(){
        return new SequentialAction(
                robot.subsistemasInferiores.goToReadyToIntakeCone2Autonomo(),
                robot.subsistemasSuperiores.goToReadyToTranfer(),
                robot.subsistemasInferiores.goToReadyToTransfer()
        );
    }

    public Action outtakeCone2(){
        return robot.subsistemasSuperiores.goToReadyToOuttake();
    }

    public Action intakeCone3(){
        return new SequentialAction(
                robot.subsistemasInferiores.goToReadyToIntakeCone3Autonomo(),
                robot.subsistemasSuperiores.goToReadyToTranfer(),
                robot.subsistemasInferiores.goToReadyToTransfer()
        );
    }

    public Action outtakeCone3(){
        return robot.subsistemasSuperiores.goToReadyToOuttake();
    }

    /**************************************************
     *                 Ations de Teste                *
     **************************************************/

    public Action testezinho(){
        return robot.subsistemasSuperiores.goToReadyToOuttake();
    }

    @Override
    public void runOpMode() {

        robot = new Robot(hardwareMap);
        Pose2d initialPose = new Pose2d(-36, 68, Math.toRadians(180));

        waitForStart();

        robot.md.localizer.setPose(initialPose);

        /*if (limelight.detectAprilTagId() == 6){
            estaciona = estacionamento1();
        }
        if (limelight.detectAprilTagId() == 7){
            estaciona = estacionamento2();
        }
        if (limelight.detectAprilTagId() == 8){
            estaciona = estacionamento3();
        }
        if (limelight.detectAprilTagId() == 404){
            estaciona = estacionamento2();
        }*/

        Actions.runBlocking(
            new SequentialAction(
                    /*cone1(),
                    outtakeCone1(),
                    pegarCone2(),
                    intakeCone2(),
                    cone2(),
                    outtakeCone2(),
                    pegarCone3(),
                    intakeCone3(),
                    cone3(),
                    outtakeCone3()*/
                    testezinho()

            )
        );
        

    }
}