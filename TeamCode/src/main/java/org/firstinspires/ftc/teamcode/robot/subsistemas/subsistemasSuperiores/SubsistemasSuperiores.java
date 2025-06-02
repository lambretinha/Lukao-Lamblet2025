package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasSuperiores;

import com.qualcomm.robotcore.hardware.HardwareMap;


public class SubsistemasSuperiores {

    BracoCopinho angulacaoBracoCopinho;

    RotacaoCopinho rotacaoCopinho;

    LinearVertical linearVertical;

    public SubsistemasSuperiores(HardwareMap hardwareMap){
        angulacaoBracoCopinho = new BracoCopinho(hardwareMap);
        rotacaoCopinho = new RotacaoCopinho(hardwareMap);
        linearVertical = new LinearVertical(hardwareMap);

    }
}