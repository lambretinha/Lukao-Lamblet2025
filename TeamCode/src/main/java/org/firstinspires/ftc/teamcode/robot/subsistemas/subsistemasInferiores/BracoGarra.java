package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasInferiores;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robot.HardwareNames;

public class BracoGarra {

    Servo servoBracoGarra;

    public BracoGarra(HardwareMap hardwareMap){
        servoBracoGarra = hardwareMap.get(Servo.class, HardwareNames.angulacaoBracoGarra);
    }

}
