package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasSuperiores;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robot.HardwareNames;

public class BracoCopinho {

    Servo servoBracoCopinho;

    public BracoCopinho(HardwareMap hardwareMap){
        servoBracoCopinho = hardwareMap.get(Servo.class, HardwareNames.angulacaoBracoCopinho);
    }
}
