package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasinferiores;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.robot.HardwareNames;

public class LinearHorizontal {

    DcMotorEx motorHorizontal;
    public  LinearHorizontal(HardwareMap hardwareMap){
        motorHorizontal = hardwareMap.get(DcMotorEx.class, HardwareNames.horizontal);
    }
}
