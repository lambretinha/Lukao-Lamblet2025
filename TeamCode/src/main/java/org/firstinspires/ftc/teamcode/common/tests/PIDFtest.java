package org.firstinspires.ftc.teamcode.common.tests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.robot.HardwareNames;
@Config
@TeleOp
public class PIDFtest extends OpMode {

    private PIDController controller;

    public static double p = 0, i = 0, d = 0;
    public static double f = 0;

    public static int target = 0;

    private DcMotorEx motorLinear;

    @Override
    public void init(){
        controller = new PIDController(p, i, d);
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        motorLinear = hardwareMap.get(DcMotorEx.class, HardwareNames.horizontal);
    }

    @Override
    public void loop(){
        controller.setPID(p, i, d);
        int armPos = motorLinear.getCurrentPosition();
        double pid = controller.calculate(armPos, target);
        double ff = Math.cos(Math.toRadians(target)) * f;

        double power = pid + ff;

        motorLinear.setPower(power);

        if (gamepad1.dpad_up){
            target = target + 30;
        }

        if (gamepad1.dpad_down){
            target = target - 30;
        }


        telemetry.addData("pos", motorLinear.getCurrentPosition());
        telemetry.addData("target", target);
        telemetry.addData("corrente", motorLinear.getCurrent(CurrentUnit.AMPS));
        telemetry.update();
    }
}
