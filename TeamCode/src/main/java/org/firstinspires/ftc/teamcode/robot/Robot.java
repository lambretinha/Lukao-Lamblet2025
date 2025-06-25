package org.firstinspires.ftc.teamcode.robot;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.common.roadrunner.MecanumDrive;
import org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasSuperiores.SubsistemasSuperiores;
import org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasInferiores.SubsistemasInferiores;

import java.util.List;

public class Robot {
    public MecanumDrive md;
    public SubsistemasSuperiores subsistemasSuperiores;
    public SubsistemasInferiores subsistemasInferiores;

    public Robot(HardwareMap hardwareMap){
     md = new MecanumDrive(hardwareMap, new Pose2d(-36, 68, Math.toRadians(180)));//ver se ta certo

     subsistemasInferiores = new SubsistemasInferiores(hardwareMap);
     subsistemasSuperiores = new SubsistemasSuperiores(hardwareMap);

        List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }
    }
}