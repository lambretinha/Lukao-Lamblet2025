package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasinferiores;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LinearHorizontal {

    DcMotorEx motor;
    public  LinearHorizontal(HardwareMap hardwareMap){
        motor = hardwareMap.get(DcMotorEx.class, "motorHorizontal");
    }
}
