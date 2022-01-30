package org.firstinspires.ftc.teamcode.Attachments;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

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

         LeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
         LeftBack.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void moveTeleopDrivetrain(double y, double x, double rx) {
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

    public void moveTeleopDrivetrainFast(double y, double x, double rx) {
        double LeftFrontPower = (y + x + rx);
        double LeftBackPower = (y - x + rx);
        double RightFrontPower = (y - x - rx);
        double RightBackPower = (y + x - rx);

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

    public void moveTeleopDrivetrainSlow(double y, double x, double rx) {
        double denominator = 5;
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

    public void moveAutonomousDrivetrain(double power, double inches) {

        LeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LeftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (inches*45.3);

        LeftFront.setTargetPosition(ticks);
        LeftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LeftFront.setPower(power);

        RightFront.setTargetPosition(ticks);
        RightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RightFront.setPower(power);

        LeftBack.setTargetPosition(ticks);
        LeftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LeftBack.setPower(power);

        RightBack.setTargetPosition(ticks);
        RightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RightBack.setPower(power);

        while (LeftFront.isBusy() || RightFront.isBusy() || LeftBack.isBusy() || RightBack.isBusy()) {

            op.telemetry.addData("LeftFront Position", LeftFront.getCurrentPosition());
            op.telemetry.addData("RightFront Position", RightFront.getCurrentPosition());
            op.telemetry.addData("LeftBack Position", LeftBack.getCurrentPosition());
            op.telemetry.addData("RightBack Position", RightBack.getCurrentPosition());
            op.telemetry.update();
        }
    }

    public void moveAutonomousDrivetrainLeft(double power, double inches) {

        int ticks = (int) (inches*51.2);

        LeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LeftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        LeftFront.setTargetPosition(-ticks);
        LeftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LeftFront.setPower(-power);

        RightFront.setTargetPosition(ticks);
        RightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RightFront.setPower(power);

        LeftBack.setTargetPosition(ticks);
        LeftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LeftBack.setPower(power);

        RightBack.setTargetPosition(-ticks);
        RightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RightBack.setPower(-power);

        while (LeftFront.isBusy() || RightFront.isBusy() || LeftBack.isBusy() || RightBack.isBusy() ) {

            op.telemetry.addData("LeftFront Position", LeftFront.getCurrentPosition());
            op.telemetry.addData("RightFront Position", RightFront.getCurrentPosition());
            op.telemetry.addData("LeftBack Position", LeftBack.getCurrentPosition());
            op.telemetry.addData("RightBack Position", RightBack.getCurrentPosition());
            op.telemetry.update();
        }
    }

    public void moveAutonomousDrivetrainRight(double power, double inches) {

        LeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LeftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (inches*51.2);

        LeftFront.setTargetPosition(ticks);
        LeftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LeftFront.setPower(power);

        RightFront.setTargetPosition(-ticks);
        RightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RightFront.setPower(-power);

        LeftBack.setTargetPosition(-ticks);
        LeftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LeftBack.setPower(-power);

        RightBack.setTargetPosition(ticks);
        RightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RightBack.setPower(power);

        while (LeftFront.isBusy() || RightFront.isBusy() || LeftBack.isBusy() || RightBack.isBusy() ) {

            op.telemetry.addData("LeftFront Position", LeftFront.getCurrentPosition());
            op.telemetry.addData("RightFront Position", RightFront.getCurrentPosition());
            op.telemetry.addData("LeftBack Position", LeftBack.getCurrentPosition());
            op.telemetry.addData("RightBack Position", RightBack.getCurrentPosition());
            op.telemetry.update();
        }
    }

    public void turnDrivetrain (double power, double angle) {

        LeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LeftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (angle*9.85);

            LeftFront.setTargetPosition(ticks);
            LeftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LeftBack.setTargetPosition(ticks);
            LeftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RightFront.setTargetPosition(-ticks);
            RightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RightBack.setTargetPosition(-ticks);
            RightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            if (angle > 0) {
                LeftFront.setPower(power);
                LeftBack.setPower(power);
                RightFront.setPower(-power);
                RightBack.setPower(-power);
            }

            else if (angle < 0) {
                LeftFront.setPower(-power);
                LeftBack.setPower(-power);
                RightFront.setPower(power);
                RightBack.setPower(power);
            }

            while (LeftFront.isBusy() || RightFront.isBusy() || LeftBack.isBusy() || RightBack.isBusy() ) {

                op.telemetry.addData("LeftFront Position", LeftFront.getCurrentPosition());
                op.telemetry.addData("RightFront Position", RightFront.getCurrentPosition());
                op.telemetry.addData("LeftBack Position", LeftBack.getCurrentPosition());
                op.telemetry.addData("RightBack Position", RightBack.getCurrentPosition());
                op.telemetry.update();
            }
        }
    }

