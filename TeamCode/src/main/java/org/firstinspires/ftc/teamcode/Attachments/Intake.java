package org.firstinspires.ftc.teamcode.Attachments;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

public class Intake {
    CRServo intakeServo1;
    CRServo intakeServo2;
    private LinearOpMode op;

    public Intake(LinearOpMode opMode) {
        this.op = opMode;
        intakeServo1 = op.hardwareMap.crservo.get("IntakeServo1");
        intakeServo2 = op.hardwareMap.crservo.get("IntakeServo2");
    }

    public void turnIntakeForward(boolean intakeOn) {
        if (intakeOn) {
            op.telemetry.addData("setting power", null);
            op.telemetry.update();
            intakeServo1.setPower(-1);
            intakeServo2.setPower(1);
        }
    }

    public void turnIntakeBackward(boolean intakeOn) {
        if (intakeOn) {
            intakeServo1.setPower(1);
            intakeServo2.setPower(-1);
        }
    }
    public void stopIntake(boolean forwardOff, boolean backwardOff) {
        if (!forwardOff && !backwardOff) {
            intakeServo1.setPower(0);
            intakeServo2.setPower(0);
        }
    }
 }
