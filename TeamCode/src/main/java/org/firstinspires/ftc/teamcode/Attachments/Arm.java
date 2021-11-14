package org.firstinspires.ftc.teamcode.Attachments;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {
    DcMotor armMotor = null;
    Servo wristServo = null;
    private LinearOpMode op;

    public Arm(LinearOpMode opMode) {
        this.op = opMode;
        armMotor = op.hardwareMap.dcMotor.get("ArmMotor");
        wristServo = op.hardwareMap.servo.get("WristServo");
    }

    int ticksLevel1;
    int ticksLevel2;
    int ticksLevel3;
    public void deliverFreight(int level) {
        if (level == 1) {
            armMotor.setTargetPosition(ticksLevel1);
        }
        else if (level == 2) {
            armMotor.setTargetPosition(ticksLevel2);
        }
        else {
            armMotor.setTargetPosition(ticksLevel2);
        }
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(-1);
    }

    public void deliverFreight2() {
        armMotor.setTargetPosition(ticksLevel2);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(-1);
    }

    public void deliverFreight3() {

    }
}
