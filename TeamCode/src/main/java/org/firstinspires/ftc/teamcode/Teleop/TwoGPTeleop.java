package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.checkerframework.checker.units.qual.A;
import org.firstinspires.ftc.teamcode.Attachments.Arm;
import org.firstinspires.ftc.teamcode.Attachments.Carousel;
import org.firstinspires.ftc.teamcode.Attachments.Drivetrain;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp
public class TwoGPTeleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        Robot robot = new Robot(this);
        waitForStart();

        while (opModeIsActive()) {

            robot.moveTeleopDrivetrain(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
//
            if (gamepad1.right_bumper) {
                robot.moveTeleopDrivetrainFast(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
            }
            robot.turnCarouselTeleop(gamepad2.a);
            robot.stopCarouselTeleop(gamepad2.a);

            robot.turnIntakeForward(gamepad2.right_bumper);
            robot.turnIntakeBackward(gamepad2.left_bumper);
            robot.stopIntake(gamepad2.right_bumper, gamepad2.left_bumper);

            if (gamepad1.y) {
                robot.turnIntakeForward(true);
                robot.deliverFreight(3);
                robot.stopIntake(false, false);
            }

            if (gamepad1.x) {
                robot.turnIntakeForward(true);
                robot.deliverFreight(2);
                robot.stopIntake(false, false);
            }

            if (gamepad1.b) {
                robot.turnIntakeForward(true);
                robot.deliverFreight(4);
                robot.stopIntake(false, false);
            }

            if (gamepad1.a) {
                robot.turnIntakeBackward(true);
                robot.setArmToStart();
                robot.stopIntake(false, false);
            }
        }
    }
}
