package org.firstinspires.ftc.teamcode.robot.vision;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;

import java.util.List;

public class AprilTagDetectorID {

    private Limelight3A limelight;

    public AprilTagDetectorID(Limelight3A limelight) {
        this.limelight = limelight;
        this.limelight.pipelineSwitch(0); // Certifique-se de que está usando um pipeline AprilTag
    }

    public int detectAprilTagId() {
        LLResult result = limelight.getLatestResult();
        int id = 404;
        if (result != null && result.isValid()) {
            List<LLResultTypes.FiducialResult> fiducials = result.getFiducialResults();
            id = fiducials.get(0).getFiducialId();

        }
        return id;
    }
}