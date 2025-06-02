package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasinferiores;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robot.HardwareNames;

public class AngulacaoGarra {

    Servo servoAngularGarra;

    public AngulacaoGarra(HardwareMap hardwareMap){
        servoAngularGarra = hardwareMap.get(Servo.class, HardwareNames.angulacaoGarra);
    }
}
