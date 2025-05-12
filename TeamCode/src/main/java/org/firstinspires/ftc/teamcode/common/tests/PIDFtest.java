package org.firstinspires.ftc.teamcode.common.tests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

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

        motorLinear = hardwareMap.get(DcMotorEx.class, "motorLinear");

    }

    @Override
    public void loop(){

        controller.setPID(p, i, d);

        double posLinear = motorLinear.getCurrentPosition();
        double pid = controller.calculate(posLinear, target);
        double ff = Math.cos(Math.toRadians(target / posLinear));

        double power = pid + ff;

        motorLinear.setPower(power);

        telemetry.addData("pos", posLinear);
        telemetry.addData("target", target);
        telemetry.update();
    }
}
