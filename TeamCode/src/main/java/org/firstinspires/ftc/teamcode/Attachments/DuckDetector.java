package org.firstinspires.ftc.teamcode.Attachments;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

public class DuckDetector {
    private LinearOpMode op;
    private static final String TFOD_MODEL_ASSET = "RubiksCubeModel.tflite";
    private static final String[] LABELS = {
            "Rubiks Cube"
    };
    private static final String VUFORIA_KEY =
            "AS+3miP/////AAABmUADHX1oj0Mrgz+nUhz+Kx4of+OMAHHpc1WO+qVoM6oFVjzjDmTHl+/HKvX4UBJfzOJ1czBlCzfaK9H5/+YYapP0vJq0N+0OnUvQmow/94xqEY+cciWJzxZ+yCm+jwxeaTSjkSwu1tRmkwoEXq06R4l8JHtaOMOpdOsbHHdxg0vql+yny2q4C9yybqz2sxvzbF+9J2B8LcNArikLcNTkXDJKXlbdk4dm74ocRjzl4grUIq89MbB/AnWXLCO54+FQlnazS+Ro4FvUfpxIDzkGydcCgJDLRJaH5Zh1rY6QumUGhPcxDLHNtiLRdZWXhRhPvk732UwHUO/8AjMTpr5cxyVvkyZTmNTNGydNBE3CqGRv";
    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;
    public DuckDetector(LinearOpMode opMode){
        this.op=opMode;
        initVuforia();
        initTfod();
        if (tfod != null) {
            tfod.activate();

            // The TensorFlow software will scale the input images from the camera to a lower resolution.
            // This can result in lower detection accuracy at longer distances (> 55cm or 22").
            // If your target is at distance greater than 50 cm (20") you can adjust the magnification value
            // to artificially zoom in to the center of image.  For best results, the "aspectRatio" argument
            // should be set to the value of the images used to create the TensorFlow Object Detection model
            // (typically 16/9).
            tfod.setZoom(1, 16.0/9.0);

        }



    }

    public int getDuckLocation(){
        int num = 0;
        if (tfod != null) {

            for (int i = 0; i < 5; i++) {
                tfod.getUpdatedRecognitions();
                op.sleep(250);
            }
            // getUpdatedRecognitions() will return null if no new information is available since
            // the last time that call was made.
            List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
            if (updatedRecognitions != null) {
                op.telemetry.addData("# Object Detected", updatedRecognitions.size());
                // step through the list of recognitions and display boundary info.
                int i = 0;
                boolean isDuckDetected=false;
                for (Recognition recognition : updatedRecognitions) {
                    op.telemetry.addData(String.format("label (%d)", i), recognition.getLabel());
                    op.telemetry.addData(String.format("  left,top (%d)", i), "%.03f , %.03f",
                            recognition.getLeft(), recognition.getTop());
                    op.telemetry.addData(String.format("  right,bottom (%d)", i), "%.03f , %.03f",
                            recognition.getRight(), recognition.getBottom());
                    i++;

                    if (recognition.getLabel().equals("Rubiks Cube")) {
                        isDuckDetected = true;
                        op.telemetry.addData("Object Detected", "Duck");
                        op.telemetry.update();
                        if(recognition.getLeft()>=400 && recognition.getLeft()<=700){
                            num=3;
                            op.telemetry.addData("3", null);
                            op.telemetry.update();

                        }
                        else if(recognition.getLeft()>150 && recognition.getLeft()<=300){
                            num=2;
                            op.telemetry.addData("2", null);
                            op.telemetry.update();
                        }
                        else if(recognition.getLeft()>=-100 && recognition.getLeft()<=100){
                            num=1;
                            op.telemetry.addData("1", null);
                            op.telemetry.update();
                        }
                        else{
                            num=0;
                        }
                    } else {
                        isDuckDetected = false;
                    }

                }
                op.telemetry.update();
            }
        }
        return num;
    }
    private void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraName = op.hardwareMap.get(WebcamName.class, "Webcam 1");

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the TensorFlow Object Detection engine.
    }

    /**
     * Initialize the TensorFlow Object Detection engine.
     */
    private void initTfod() {
        int tfodMonitorViewId = op.hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", op.hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minResultConfidence = 0.6f;
        tfodParameters.isModelTensorFlow2 = true;
        tfodParameters.inputSize = 320;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABELS);
    }
}
