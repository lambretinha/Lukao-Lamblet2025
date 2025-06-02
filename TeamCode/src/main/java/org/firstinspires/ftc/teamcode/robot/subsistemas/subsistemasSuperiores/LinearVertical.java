package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasSuperiores;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.robot.HardwareNames;

public class LinearVertical {

    DcMotor motorVertical;

    public LinearVertical(HardwareMap hardwareMap){
        motorVertical = hardwareMap.get(DcMotorEx.class, HardwareNames.vertical);
    }
}
