package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasSuperiores;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.robot.HardwareNames;

public class LinearVertical {

    DcMotor motorVertical;
    public static double p = 0.008, i = 0.004, d = 0, f = 0.04;
    PIDController controller = new PIDController(p, i, d);

    public LinearVertical(HardwareMap hardwareMap){
        motorVertical = hardwareMap.get(DcMotorEx.class, HardwareNames.vertical);
        motorVertical.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public double PIDF(int targetPosition){

        int linearpos = motorVertical.getCurrentPosition();
        controller.setPID(p, i,d);
        double pid = controller.calculate(linearpos, targetPosition);
        double ff = Math.cos(Math.toRadians(targetPosition)) * f;

        motorVertical.setPower(pid+ff);

     return pid + ff;

    }

    public Action ElevadorGoTo(int target) {

        return new Action() {
            int currentPosition = motorVertical.getCurrentPosition();
            boolean condicaoParadaChegouNoAlvoPID = currentPosition >= target - 15 && currentPosition <= target + 15;

            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                PIDF(target);
                currentPosition = motorVertical.getCurrentPosition();
                condicaoParadaChegouNoAlvoPID = currentPosition >= target - 15 && currentPosition <= target + 15;
                if(condicaoParadaChegouNoAlvoPID){
                    return false;
                }
                return true;
            }

        };

    }
}
