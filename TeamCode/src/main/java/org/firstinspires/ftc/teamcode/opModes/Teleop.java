package org.firstinspires.ftc.teamcode.opModes;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.robot.HardwareNames;
import org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasSuperiores.SubsistemasSuperiores;
import org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasinferiores.SubsistemasInferiores;

@TeleOp(name="Teleop mimindo")
@Config
public class Teleop extends OpMode {

    DcMotor leftFront, leftBack, rightFront, rightBack;
    double drive, strafe, turn;

    SubsistemasInferiores subsistemasInferiores;
    SubsistemasSuperiores subsistemasSuperiores;

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

        drive = -gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        turn = gamepad1.right_stick_x;

        leftFront.setPower(drive + strafe + turn);
        rightFront.setPower(drive - strafe - turn);
        leftBack.setPower(drive - strafe + turn);
        rightBack.setPower(drive + strafe - turn);

        //testar

        //subsistemasInferiores.goToReadyToIntake(); //wow, funciona
        //subsistemasSuperiores.goToReadyToOuttake(); //wow, funciona tbm

    }

}
