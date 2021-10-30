package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.checkerframework.checker.units.qual.C;
import org.firstinspires.ftc.teamcode.Attachments.Carousel;

@TeleOp
public class Teleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        //declare motors
        Carousel carousel = new Carousel(this);
        Drivetrain drivetrain = new Drivetrain(this);
        DcMotor CarouselMotor = hardwareMap.dcMotor.get("CarouselMotor");
        Servo ClawServo = hardwareMap.servo.get("ClawServo");
        ClawServo.setPosition(1);


        waitForStart();

        while (opModeIsActive()) {

            drivetrain.MoveTeleopDrivetrain(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            carousel.turnCarouselTeleop(gamepad1.a);
            carousel.stopCarouselTeleop(gamepad1.a);

            boolean CloseClaw = gamepad1.dpad_left;
            boolean OpenClaw = gamepad1.dpad_right;

            if (CloseClaw) {
                ClawServo.setPosition(0.5);
            }
            if (OpenClaw) {
                ClawServo.setPosition(1);
            }
        }
    }
}