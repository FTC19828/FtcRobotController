package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;

@TeleOp
public class OneGPTeleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        Robot robot = new Robot(this);
        waitForStart();

        while (opModeIsActive()) {

            robot.moveTeleopDrivetrain(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            robot.turnCarouselTeleop(gamepad1.dpad_up);
            robot.stopCarouselTeleop(gamepad2.dpad_up);


            robot.turnIntakeForward(gamepad1.right_bumper);
            robot.turnIntakeBackward(gamepad1.left_bumper);
            robot.stopIntake(gamepad1.right_bumper, gamepad1.left_bumper);

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