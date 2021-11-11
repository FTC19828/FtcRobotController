package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Attachments.Carousel;
import org.firstinspires.ftc.teamcode.Attachments.Drivetrain;

@TeleOp
public class Teleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        Robot robot = new Robot(this);

        waitForStart();

        while (opModeIsActive()) {

            robot.moveTeleopDrivetrain(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            robot.turnCarouselTeleop(gamepad1.a);
            robot.stopCarouselTeleop(gamepad1.a);

           if (gamepad1.b) {
               robot.pickUp();
           }
        }
    }
}