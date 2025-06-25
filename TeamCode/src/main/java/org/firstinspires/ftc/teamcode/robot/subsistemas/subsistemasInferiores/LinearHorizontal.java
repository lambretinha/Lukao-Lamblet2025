package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasInferiores;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.robot.HardwareNames;

public class LinearHorizontal {

    DcMotorEx motorHorizontal;
    public static double p = 0.02, i = 0.002, d = 0, f = 0.01;
    PIDController controller = new PIDController(p, i, d);
    public  LinearHorizontal(HardwareMap hardwareMap){
        motorHorizontal = hardwareMap.get(DcMotorEx.class, HardwareNames.horizontal);
    }

    public double PIDF(int targetPosition){
        double kp = p;

        int linearpos = motorHorizontal.getCurrentPosition();
        controller.setPID(kp, i,d);
        double pid = controller.calculate(linearpos, targetPosition);
        double ff = Math.cos(Math.toRadians(targetPosition)) * f;

        motorHorizontal.setPower(pid+ff);

        return pid + ff;
    }

    public Action HorizontalGoTo(int target){

        return new Action() {
            int currentPosition = motorHorizontal.getCurrentPosition();

            boolean condicaoParadaChegouNoAlvoPID = currentPosition >= target - 10 && currentPosition <= target + 10;

            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                PIDF(target);
                currentPosition = motorHorizontal.getCurrentPosition();
                condicaoParadaChegouNoAlvoPID = currentPosition >= target - 10 && currentPosition <= target + 10;
                if(condicaoParadaChegouNoAlvoPID){
                    return false;
                }
                return true;
            }

        };
    }
}
