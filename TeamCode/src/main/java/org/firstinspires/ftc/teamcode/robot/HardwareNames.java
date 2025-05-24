package org.firstinspires.ftc.teamcode.robot;

import com.acmerobotics.dashboard.config.Config;

@Config
public final class HardwareNames {
    public static String

            /**************************************************
             *                  Rodas Mortas                   *
             **************************************************/
            par0 = "rightBack",
            par1 = "rightFront",
            perp = "leftFront",
    /**************************************************
     *                  Motores Chassi                *
     **************************************************/
            rightFront =  "rightFront",
            leftFront =   "leftFront",
            rightBack =   "rightBack",
            leftBack =    "leftBack",
    /**************************************************
     *                  Sensores                       *
     **************************************************/
            distanceSensorL      = "sensorporta3",
            distanceSensorR      = "sensorPorta2",
            colorSensor1         = "I2Cporta1",
            colorSensor2         = "I2Cporta2",
            touchSensor          = "sensorToque",

    /**************************************************
     *         Visão Computacional / Cameras          *
     **************************************************/
            limelight            =  "limelight",

    /**************************************************
     *              DcMotors Subsistemas               *
     **************************************************/
            verticalR            = "verticalr",
            verticalL            = "verticall",
            bracoGarraSuperior   = "b",
            SugadorMotorInferior = "porta3e",
    /**************************************************
     *              Servo Subsistemas Pinça           *
     **************************************************/

            horizontalSuperiorServo   = "porta2c",
            horizontalInferiorMotor   = "porta2e",
            horizontalInferiorServo   = "porta5",
            bracoGarraSuperiorServo   = "porta3c",

            bracoGarraInferiorServo   = "porta0",
            rotacaoGarraInferiorServo = "porta2",

            rotacaoGarraSuperiorServo  = "porta1",

            angulacaoGarraInferiorServo = "porta5",

            angulacaoGarraSuperiorServo = "porta1c",

            aberturaGarraInferiorServo  = "porta3",

            aberturaGarraSuperiorServo  = "porta4c",

    /**************************************************
     *            Servo Subsistemas Sugar             *
     **************************************************/

            angulacaoSugarServo = "porta5",
            alcapaoSugarServo = "porta2",


    /**************************************************
     *                   TroughBore                   *
     **************************************************/
            horizontalSuperior    = "braco",
            getHorizontalInferior  = "braco";
}
