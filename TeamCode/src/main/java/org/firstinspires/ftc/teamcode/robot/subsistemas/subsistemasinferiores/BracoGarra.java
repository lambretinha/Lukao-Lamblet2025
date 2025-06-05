package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasinferiores;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robot.HardwareNames;

public class BracoGarra {

    Servo servoBracoGarra;


    /**
    * Essa Função Cria um novo Braço da Garra
    * @param hardwareMap eu preciso do hardwaremap que vc tem no OpMode mesmo, pra criar os hardwares necessários.
     * @see HardwareMap da uma olhada aqui é a classe do hardwaremap que vc precisa passar
    * */
    public BracoGarra(HardwareMap hardwareMap){
        servoBracoGarra = hardwareMap.get(Servo.class, HardwareNames.angulacaoBracoGarra);
    }

}
