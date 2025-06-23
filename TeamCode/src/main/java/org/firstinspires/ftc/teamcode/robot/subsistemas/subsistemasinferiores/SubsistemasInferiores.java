package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasinferiores;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.SequentialAction;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class SubsistemasInferiores {

    LinearHorizontal linearHorizontal;
    Garra abrirFecharGarra;
    BracoGarra angulacaoBracoGarra;
    Garra angulacaoGarra;
    public static int target = 200;

    public SubsistemasInferiores(HardwareMap hardwareMap){

        linearHorizontal = new LinearHorizontal(hardwareMap);
        abrirFecharGarra = new Garra(hardwareMap);
        angulacaoBracoGarra = new BracoGarra(hardwareMap);
        angulacaoGarra = new Garra(hardwareMap);

    }

    public Action goToReadyToIntake(){
        Action posicionaServos = new Action() {

            ElapsedTime cronometro = new ElapsedTime();
            double tempoDeEspera = 500;

            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                abrirFecharGarra.servoGarra.setPosition(0);
                angulacaoGarra.servoAngularGarra.setPosition(0.5);
                angulacaoBracoGarra.servoBracoGarra.setPosition(1);
                if (cronometro.time() >= tempoDeEspera){
                    return false;
                }
                return true;
            }
        };
        return new SequentialAction(
                posicionaServos,
                linearHorizontal.HorizontalGoTo(target)
        );
    }

    public Action goToReadyToTransfer(){
        Action posicionaServos = new Action() {

            ElapsedTime cronometro = new ElapsedTime();
            double tempoDeEspera = 500;

            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                abrirFecharGarra.servoGarra.setPosition(1);
                angulacaoGarra.servoAngularGarra.setPosition(1);
                angulacaoBracoGarra.servoBracoGarra.setPosition(0);
                linearHorizontal.HorizontalGoTo(10);
                if (cronometro.time() >= tempoDeEspera){
                    return false;
                }
                return true;
            }
        };
        return new SequentialAction(
                posicionaServos,
                linearHorizontal.HorizontalGoTo(target)
        );
    }


}

