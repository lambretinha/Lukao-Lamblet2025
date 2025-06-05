package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasSuperiores;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.SequentialAction;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;


public class SubsistemasSuperiores {

    BracoCopinho angulacaoBracoCopinho;

    RotacaoCopinho rotacaoCopinho;

    LinearVertical linearVertical;

    public SubsistemasSuperiores(HardwareMap hardwareMap){
        angulacaoBracoCopinho = new BracoCopinho(hardwareMap);
        rotacaoCopinho = new RotacaoCopinho(hardwareMap);
        linearVertical = new LinearVertical(hardwareMap);

    }

    public Action goToReadyToOuttake(){
        Action posicionarServos = new Action() {
            ElapsedTime cronometro = new ElapsedTime();
            double tempoDeEspera = 500;

            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                angulacaoBracoCopinho.servoBracoCopinho.setPosition(0.7);
                rotacaoCopinho.servoRotacaoCopinho.setPosition(0.5);
                if (cronometro.time() >= tempoDeEspera){
                    return false;
                }
                return true;
            }
        };
        return new SequentialAction(
                posicionarServos,
                linearVertical.ElevadorGoTo(200)
        );
    }

    public Action goToReadyToTranfer(){
            Action posicionarServos = new Action() {
                ElapsedTime cronometro = new ElapsedTime();
                double tempoDeEspera = 500;

                @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                angulacaoBracoCopinho.servoBracoCopinho.setPosition(0.7);
                rotacaoCopinho.servoRotacaoCopinho.setPosition(0.5);
                linearVertical.ElevadorGoTo(10);
                    if (cronometro.time() >= tempoDeEspera){
                        return false;
                    }
                    return true;
            }
        };
        return new SequentialAction(
                posicionarServos,
                linearVertical.ElevadorGoTo(200)
        );
    }
}