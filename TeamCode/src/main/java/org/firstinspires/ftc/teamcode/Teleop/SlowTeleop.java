package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Attachments.Arm;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp
public class SlowTeleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        Robot robot = new Robot(this);
        Arm arm = new Arm(this);

        waitForStart();

        while (opModeIsActive()) {

            robot.moveTeleopDrivetrain(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            robot.turnCarouselTeleop(gamepad1.a);
            robot.stopCarouselTeleop(gamepad1.a);

//           if (gamepad1.b) {
//               robot.pickUp();
//           }

           robot.turnIntakeForward(gamepad2.x);
           robot.turnIntakeBackward(gamepad2.b);
//           robot.stopIntake(gamepad2.x, gamepad2.b);

            if (gamepad1.y) {
                arm.deliverFreight(3);
                telemetry.addData("Running", null);
                telemetry.update();
            }

            if (gamepad1.x) {
                arm.deliverFreight(2);
            }

            if (gamepad1.b) {
                arm.deliverFreight(1);
            }

            if (gamepad1.right_bumper) {
                arm.setToStart();
            }
        }
    }
}