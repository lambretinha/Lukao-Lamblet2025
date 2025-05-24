package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasinferiores;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SubsistemasInferiores {

    LinearHorizontal linearHorizontal;
    public SubsistemasInferiores(HardwareMap hardwareMap){
        linearHorizontal = new LinearHorizontal(hardwareMap);
    }


}

