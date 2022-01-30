package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Attachments.Carousel;
import org.firstinspires.ftc.teamcode.Attachments.Drivetrain;
import org.firstinspires.ftc.teamcode.Attachments.DuckDetector;
import org.firstinspires.ftc.teamcode.R;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "FinalAutonomous", group="Autonomous")

public class FinalAutonomous extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        Robot robot = new Robot(this);
        DuckDetector duckDetector = new DuckDetector(this);
        int level = duckDetector.getDuckLocation();
        telemetry.addData("level", level);
        telemetry.update();

        waitForStart();


        robot.moveAutonomousDrivetrain(-0.5, -3);
        robot.moveAutonomousDrivetrainLeft(0.5, 16);
        robot.turnCarouselAutonomous();
        robot.moveAutonomousDrivetrainRight(0.5, 2);
        robot.turnDrivetrain(0.5, -90);
        robot.moveAutonomousDrivetrain(-0.5, -44);
        robot.turnDrivetrain(0.5, 90);
        robot.turnIntakeForward(true);

        if (level == 3) {
            robot.moveAutonomousDrivetrain(-0.5, -14.25);
            robot.deliverFreight(3);
            sleep(3000);
        }
        else if (level == 2) {
            robot.moveAutonomousDrivetrain(-0.5, -7);
            robot.deliverFreight(2);
            sleep(3000);
        }

        else {
            robot.moveAutonomousDrivetrain(-0.5, -3);
            robot.deliverFreight(1);
            sleep(3000);
        }

        robot.stopIntake(false, false);
        robot.setArmToStart();
        robot.turnDrivetrain(0.5, 90);
         if (level == 3) {
            robot.moveAutonomousDrivetrainLeft(0.5, 21.5);
        }
        else if (level == 2){
            robot.moveAutonomousDrivetrainLeft(0.5, 15);
        }
        else {
            robot.moveAutonomousDrivetrainLeft(0.5, 11);
         }
        robot.moveAutonomousDrivetrain(1, 55);

    }
}