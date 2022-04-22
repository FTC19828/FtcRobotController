package org.firstinspires.ftc.teamcode.Attachments;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

public class Intake {
    DcMotor intakeMotor;
    private LinearOpMode op;

    public Intake(LinearOpMode opMode) {
        this.op = opMode;
        intakeMotor = op.hardwareMap.dcMotor.get("IntakeMotor");
    }

    public void turnIntakeForward(boolean intakeOn) {
        if (intakeOn) {
            op.telemetry.addData("setting power", null);
            op.telemetry.update();
            intakeMotor.setPower(-1);
        }
    }

    public void turnIntakeBackward(boolean intakeOn) {
        if (intakeOn) {
            intakeMotor.setPower(1);
        }
    }
    public void stopIntake(boolean forwardOff, boolean backwardOff) {
        if (!forwardOff && !backwardOff) {
            intakeMotor.setPower(0);
        }
    }
 }
