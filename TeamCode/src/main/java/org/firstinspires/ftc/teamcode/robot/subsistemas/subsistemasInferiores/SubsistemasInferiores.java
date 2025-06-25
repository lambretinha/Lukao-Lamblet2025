package org.firstinspires.ftc.teamcode.robot.subsistemas.subsistemasInferiores;

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
    public static int targetIntake = 800;
    public static int targetTransfer = 100;

    public SubsistemasInferiores(HardwareMap hardwareMap){

        linearHorizontal = new LinearHorizontal(hardwareMap);
        abrirFecharGarra = new Garra(hardwareMap);
        angulacaoBracoGarra = new BracoGarra(hardwareMap);
        angulacaoGarra = new Garra(hardwareMap);

    }

    public Action goToReadyToIntake(){
        Action posicionaServos = new Action() {

            ElapsedTime cronometro = new ElapsedTime();
            double tempoDeEspera = 0;

            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                abrirFecharGarra.servoGarra.setPosition(0.283);
                angulacaoGarra.servoAngularGarra.setPosition(0.429);
                angulacaoBracoGarra.servoBracoGarra.setPosition(0);
                if (cronometro.time() >= tempoDeEspera){
                    return false;
                }
                return true;
            }
        };
        return new SequentialAction(
                posicionaServos,
                linearHorizontal.HorizontalGoTo(targetIntake)
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
                linearHorizontal.HorizontalGoTo(targetTransfer);
                if (cronometro.time() >= tempoDeEspera){
                    return false;
                }
                return true;
            }
        };
        return new SequentialAction(
                posicionaServos,
                linearHorizontal.HorizontalGoTo(targetTransfer)
        );
    }

    public Action goToReadyToIntakeCone2Autonomo(){
        Action posicionaServos = new Action() {

            ElapsedTime cronometro = new ElapsedTime();
            double tempoDeEspera = 500;

            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                abrirFecharGarra.servoGarra.setPosition(0.283);
                angulacaoGarra.servoAngularGarra.setPosition(0.429);
                angulacaoBracoGarra.servoBracoGarra.setPosition(1);
                if (cronometro.time() >= tempoDeEspera){
                    return false;
                }
                return true;
            }
        };return new SequentialAction(
                posicionaServos,
                linearHorizontal.HorizontalGoTo(targetIntake)
        );
    }

    public Action goToReadyToIntakeCone3Autonomo(){
        Action posicionaServos = new Action() {

            ElapsedTime cronometro = new ElapsedTime();
            double tempoDeEspera = 500;

            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                abrirFecharGarra.servoGarra.setPosition(0.283);
                angulacaoGarra.servoAngularGarra.setPosition(0.429);
                angulacaoBracoGarra.servoBracoGarra.setPosition(1);
                if (cronometro.time() >= tempoDeEspera){
                    return false;
                }
                return true;
            }
        };return new SequentialAction(
                posicionaServos,
                linearHorizontal.HorizontalGoTo(targetIntake)
        );
    }


}

