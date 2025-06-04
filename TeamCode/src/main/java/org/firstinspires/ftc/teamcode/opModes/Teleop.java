package org.firstinspires.ftc.teamcode.opModes;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.robot.HardwareNames;

@TeleOp(name="Teleop mimindo")
@Config
public class Teleop extends OpMode {

    DcMotor leftFront, leftBack, rightFront, rightBack;

    @Override
    public void init() {

        leftBack = hardwareMap.get(DcMotor.class, HardwareNames.leftBack);
        leftFront = hardwareMap.get(DcMotor.class, HardwareNames.leftFront);
        rightBack = hardwareMap.get(DcMotor.class, HardwareNames.rightBack);
        rightFront = hardwareMap.get(DcMotor.class, HardwareNames.rightFront);

        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void loop() {

        if (gamepad1.dpad_up){
            leftBack.setPower(0.7);
            rightBack.setPower(0.7);
            leftFront.setPower(0.7);
            rightFront.setPower(0.7);
        } else {
            leftBack.setPower(0);
            rightBack.setPower(0);
            leftFront.setPower(0);
            rightFront.setPower(0);
        }

        if (gamepad1.dpad_down){
            leftBack.setPower(-0.7);
            rightBack.setPower(-0.7);
            leftFront.setPower(-0.7);
            rightFront.setPower(-0.7);
        } else {
            leftBack.setPower(0);
            rightBack.setPower(0);
            leftFront.setPower(0);
            rightFront.setPower(0);
        }

        if (gamepad1.dpad_left){
            leftBack.setPower(0.7);
            rightBack.setPower(-0.7);
            leftFront.setPower(-0.7);
            rightFront.setPower(0.7);
        } else {
            leftBack.setPower(0);
            rightBack.setPower(0);
            leftFront.setPower(0);
            rightFront.setPower(0);
        }

        if (gamepad1.dpad_right){
            leftBack.setPower(-0.7);
            rightBack.setPower(0.7);
            leftFront.setPower(0.7);
            rightFront.setPower(-0.7);
        } else {
            leftBack.setPower(0);
            rightBack.setPower(0);
            leftFront.setPower(0);
            rightFront.setPower(0);
        }
        double strafe = gamepad1.left_stick_x;

        leftBack.setPower(strafe);
        rightBack.setPower(strafe);
        leftFront.setPower(strafe);
        rightFront.setPower(strafe);

        double sla = gamepad1.left_stick_y;

        leftBack.setPower(-sla);
        rightBack.setPower(-sla);
        leftFront.setPower(-sla);
        rightFront.setPower(-sla);

        leftBack.setPower(sla);
        rightBack.setPower(sla);
        leftFront.setPower(sla);
        rightFront.setPower(sla);

    }


}
