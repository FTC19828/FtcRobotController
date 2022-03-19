package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Attachments.Carousel;
import org.firstinspires.ftc.teamcode.Attachments.Drivetrain;
import org.firstinspires.ftc.teamcode.Attachments.DuckDetector;
import org.firstinspires.ftc.teamcode.R;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "NewAutonomous", group="Autonomous")

public class NewAutonomous extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot(this);
        DuckDetector duckDetector = new DuckDetector(this);
        int level = duckDetector.getDuckLocation();
        telemetry.addData("level", level);
        telemetry.update();
        level = 3;

        waitForStart();

        robot.moveAutonomousDrivetrainRight(0.5, 30);
        if (level == 3) {
            robot.moveAutonomousDrivetrain(-0.5, -19);
            robot.deliverFreight(3);
            sleep(3000);
        }
        else if (level == 2) {
            robot.moveAutonomousDrivetrain(-0.5, -9.5);
            robot.deliverFreight(2);
            sleep(3000);
            robot.moveAutonomousDrivetrain(0.5, -9.5);
        }
        else {
            robot.moveAutonomousDrivetrain(-0.5, -4);
            robot.deliverFreight(1);
            sleep(3000);
            robot.moveAutonomousDrivetrain(-0.5, -15);
        }
        robot.setArmToStart();
        robot.moveAutonomousDrivetrainLeft(0.5, 48);
        robot.moveAutonomousDrivetrain(0.5, 17);
        robot.turnCarouselAutonomous();
        robot.moveAutonomousDrivetrainRight(0.5, 10);
        robot.turnDrivetrain(0.5, 90);

    }
}