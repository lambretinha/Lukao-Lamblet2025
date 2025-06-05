package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasinferiores;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.robot.HardwareNames;

public class LinearHorizontal {

    DcMotorEx motorHorizontal;
    public static double p, i, d, f;
    public static int targetPosition = 0;
    PIDController controller = new PIDController(p, i, d);
    public  LinearHorizontal(HardwareMap hardwareMap){
        motorHorizontal = hardwareMap.get(DcMotorEx.class, HardwareNames.horizontal);
    }

    public double PIDF(){
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

            boolean condicaoParadaChegouNoAlvoPID = currentPosition >= target - 30 && currentPosition <= target + 30;

            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                PIDF();
                currentPosition = motorHorizontal.getCurrentPosition();
                condicaoParadaChegouNoAlvoPID = currentPosition >= target - 30 && currentPosition <= target + 30;
                if(condicaoParadaChegouNoAlvoPID){
                    return false;
                }
                return true;
            }

        };
    }
}
