package org.firstinspires.ftc.teamcode.robot;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.common.roadrunner.MecanumDrive;
import org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasSuperiores.BracoCopinho;
import org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasSuperiores.LinearVertical;
import org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasSuperiores.RotacaoCopinho;
import org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasinferiores.BracoGarra;
import org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasinferiores.Garra;
import org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasinferiores.LinearHorizontal;

import java.util.List;

public class Robot {
    public MecanumDrive md;
    public BracoGarra bracoGarra;
    public Garra garra;
    public LinearHorizontal linearHorizontal;
    public RotacaoCopinho rotacaoCopinho;
    public BracoCopinho bracoCopinho;
    public LinearVertical linearVertical;

    public Robot(HardwareMap hardwareMap){
     md = new MecanumDrive(hardwareMap, new Pose2d(-36, 68, Math.toRadians(180)));//ver se ta certo
     bracoGarra = new BracoGarra(hardwareMap);
     garra = new Garra(hardwareMap);
     linearHorizontal = new LinearHorizontal(hardwareMap);
     rotacaoCopinho = new RotacaoCopinho(hardwareMap);
     bracoCopinho = new BracoCopinho(hardwareMap);
     linearVertical = new LinearVertical(hardwareMap);

        List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }
    }
}