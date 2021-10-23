package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Drivetrain {

    DcMotor LeftFront = null;
    DcMotor LeftBack = null;
    DcMotor RightFront = null;
    DcMotor RightBack = null;



    private LinearOpMode op;
    public Drivetrain(LinearOpMode opmode){
        this.op = opmode;
         LeftFront = op.hardwareMap.dcMotor.get("LeftFront");
         LeftBack = op.hardwareMap.dcMotor.get("LeftBack");
         RightFront = op.hardwareMap.dcMotor.get("RightFront");
         RightBack = op.hardwareMap.dcMotor.get("RightBack");
    }

    public void MoveTeleopDrivetrain(double y, double x, double rx) {
        double denominator = 2;
        double LeftFrontPower = (y + x + rx) / denominator;
        double LeftBackPower = (y - x + rx) / denominator;
        double RightFrontPower = (y - x - rx) / denominator;
        double RightBackPower = (y + x - rx) / denominator;

        String display = "" + y + "\t" + x + "\t" + rx;
        String powerDisplay = "" + LeftFrontPower + "\t" + RightFrontPower + "\t" + LeftBackPower + "\t" + RightBackPower;
//        telemetry.addData("Values:  ", display);
//        telemetry.addData("Power:  ", powerDisplay);
//        telemetry.update();

        LeftFront.setPower(LeftFrontPower);
        LeftBack.setPower(LeftBackPower);
        RightFront.setPower(RightFrontPower);
        RightBack.setPower(RightBackPower);
    }
}
