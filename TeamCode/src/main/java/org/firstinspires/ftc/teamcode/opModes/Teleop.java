package org.firstinspires.ftc.teamcode.opModes;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.Robot;
import org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasSuperiores.SubsistemasSuperiores;

@TeleOp(name="Teleop mimindo")
@Config
public class Teleop extends OpMode {

    Robot robot;

    SubsistemasSuperiores subsistemasSuperiores;
    double drive, strafe, turn;

    @Override
    public void init() {
        robot = new Robot(hardwareMap);
    }

    @Override
    public void loop() {

        drive = -gamepad1.left_stick_y;
        strafe = -gamepad1.left_stick_x;
        turn = -gamepad1.right_stick_x;

        robot.md.setDrivePowers(new PoseVelocity2d(new Vector2d(drive, strafe), turn));

    }

}
