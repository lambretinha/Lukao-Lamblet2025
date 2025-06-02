package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasinferiores;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class SubsistemasInferiores {

    LinearHorizontal linearHorizontal;
    Garra abrirFecharGarra;

    BracoGarra angulacaoBracoGarra;

    AngulacaoGarra angulacaoGarra;

    public SubsistemasInferiores(HardwareMap hardwareMap){

        linearHorizontal = new LinearHorizontal(hardwareMap);
        abrirFecharGarra = new Garra(hardwareMap);
        angulacaoBracoGarra = new BracoGarra(hardwareMap);
        angulacaoGarra = new AngulacaoGarra(hardwareMap);

    }


}

