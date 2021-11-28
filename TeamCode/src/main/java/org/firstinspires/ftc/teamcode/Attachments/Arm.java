package org.firstinspires.ftc.teamcode.Attachments;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {
    DcMotor armMotor = null;
    DcMotor wristMotor = null;
    private LinearOpMode op;

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
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        wristMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        if (level == 1) {
            armMotor.setTargetPosition(ticksLevel1);
        }
        else if (level == 2) {
            armMotor.setTargetPosition(ticksLevel2);
        }
        else {
            armMotor.setTargetPosition(ticksLevel3);
        }
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.1);

        while (armMotor.isBusy()) {

            op.telemetry.addData("ArmMotor Position", armMotor.getCurrentPosition());
            op.telemetry.update();
        }

        if (level == 1) {
            wristMotor.setTargetPosition(-400);
        }
        else {
            wristMotor.setTargetPosition(-540);
        }
        wristMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        wristMotor.setPower(-0.1);

        while (wristMotor.isBusy()) {
            op.telemetry.addData("WristMotor Position", wristMotor.getCurrentPosition());
            op.telemetry.update();
        }
    }

    public void setToStart() {
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
