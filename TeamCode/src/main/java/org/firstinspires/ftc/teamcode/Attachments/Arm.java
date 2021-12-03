package org.firstinspires.ftc.teamcode.Attachments;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm extends Thread {
    DcMotor armMotor = null;
    DcMotor wristMotor = null;
    private LinearOpMode op;

    private int targetLevel = 0;

    @Override
    public void run() {
//        super.run();

        while (true) {
            armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            wristMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            if (targetLevel == 1) {
                armMotor.setTargetPosition(ticksLevel1);
                armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                armMotor.setPower(0.1);
            } else if (targetLevel == 2) {
                armMotor.setTargetPosition(ticksLevel2);
                armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                armMotor.setPower(0.1);
            } else if (targetLevel == 3) {
                armMotor.setTargetPosition(ticksLevel3);
                armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                armMotor.setPower(0.1);
            }


            while (armMotor.isBusy()) {

                op.telemetry.addData("ArmMotor Position", armMotor.getCurrentPosition());
                op.telemetry.update();
            }

            if (targetLevel == 1) {
                wristMotor.setTargetPosition(-400);
                wristMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                wristMotor.setPower(-0.1);
            } else if (targetLevel == 2 || targetLevel == 3) {
                wristMotor.setTargetPosition(-540);
                wristMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                wristMotor.setPower(-0.1);
            }


            while (wristMotor.isBusy()) {
                op.telemetry.addData("WristMotor Position", wristMotor.getCurrentPosition());
                op.telemetry.update();
            }
            if (targetLevel == 0) {
                wristMotor.setTargetPosition(0);
                wristMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                wristMotor.setPower(0.1);
                while (wristMotor.isBusy()) {
                    op.telemetry.addData("WristMotor Position", wristMotor.getCurrentPosition());
                    op.telemetry.update();
                }

                armMotor.setTargetPosition(0);
                armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                armMotor.setPower(-0.1);
                while (armMotor.isBusy()) {
                    op.telemetry.addData("ArmMotor Position", armMotor.getCurrentPosition());
                    op.telemetry.update();
                }
                armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
                wristMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
                armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                wristMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }
        }
    }

    public Arm(LinearOpMode opMode) {
        this.op = opMode;
        armMotor = op.hardwareMap.dcMotor.get("ArmMotor");
        wristMotor = op.hardwareMap.dcMotor.get("WristMotor");
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        wristMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        wristMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    int ticksLevel1 = 460;
    int ticksLevel2 = 360;
    int ticksLevel3 = 300;

    public void deliverFreight(int level) {
        this.targetLevel = level;
    }

    public void setToStart() {
        this.targetLevel = 0;
    }

    public void deliverFreightAutonomous(int level) {
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        wristMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        if (level == 1) {
            armMotor.setTargetPosition(ticksLevel1);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.1);
        } else if (level == 2) {
            armMotor.setTargetPosition(ticksLevel2);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.1);
        } else if (level == 3) {
            armMotor.setTargetPosition(ticksLevel3);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.1);
        }


        while (armMotor.isBusy()) {

            op.telemetry.addData("ArmMotor Position", armMotor.getCurrentPosition());
            op.telemetry.update();
        }

        if (level == 1) {
            wristMotor.setTargetPosition(-400);
            wristMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wristMotor.setPower(-0.1);
        } else if (targetLevel == 2 || targetLevel == 3) {
            wristMotor.setTargetPosition(-540);
            wristMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wristMotor.setPower(-0.1);
        }


        while (wristMotor.isBusy()) {
            op.telemetry.addData("WristMotor Position", wristMotor.getCurrentPosition());
            op.telemetry.update();
        }
        if (level == 0) {
            wristMotor.setTargetPosition(0);
            wristMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wristMotor.setPower(0.1);
            while (wristMotor.isBusy()) {
                op.telemetry.addData("WristMotor Position", wristMotor.getCurrentPosition());
                op.telemetry.update();
            }

            armMotor.setTargetPosition(0);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(-0.1);
            while (armMotor.isBusy()) {
                op.telemetry.addData("ArmMotor Position", armMotor.getCurrentPosition());
                op.telemetry.update();
            }
            armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            wristMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            wristMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }
    }

    public void setArmToStartAutonomous() {
        wristMotor.setTargetPosition(0);
        wristMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        wristMotor.setPower(0.1);
        while (wristMotor.isBusy()) {
            op.telemetry.addData("WristMotor Position", wristMotor.getCurrentPosition());
            op.telemetry.update();
        }

        armMotor.setTargetPosition(0);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(-0.1);
        while (armMotor.isBusy()) {
            op.telemetry.addData("ArmMotor Position", wristMotor.getCurrentPosition());
            op.telemetry.update();
        }
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        wristMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        op.sleep(500);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        wristMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }
}
