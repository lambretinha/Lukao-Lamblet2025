package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasinferiores;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robot.HardwareNames;

public class Garra {

    Servo servoGarra;


    public Garra(HardwareMap hardwareMap){
        servoGarra = hardwareMap.get(Servo.class, HardwareNames.aberturaGarra);
    }


}
