package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasinferiores;
import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.robot.HardwareNames;

public class Garra {

    Servo servoGarra;
    Servo servoAngularGarra;

    public Garra(HardwareMap hardwareMap){
        servoGarra = hardwareMap.get(Servo.class, HardwareNames.aberturaGarra);
        servoAngularGarra = hardwareMap.get(Servo.class, HardwareNames.angulacaoGarra);
    }
}
