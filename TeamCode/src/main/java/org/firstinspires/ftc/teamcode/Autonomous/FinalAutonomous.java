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


        robot.moveAutonomousDrivetrain(-0.5, -6);
        robot.turnDrivetrain(0.5, -90);
        robot.moveAutonomousDrivetrain(0.5, 15.75);
        robot.turnCarouselAutonomous();
        robot.moveAutonomousDrivetrain(-0.5, -44);
        robot.turnDrivetrain(0.5, 90);
        robot.turnIntakeForward(true);

        if (level == 3) {
            robot.moveAutonomousDrivetrain(-0.5, -14.25);
            robot.deliverFreight(3);
        }
        else {
            robot.moveAutonomousDrivetrain(-0.5, -6);
            robot.deliverFreight(2);
        }
        robot.stopIntake(false, false);
        robot.setArmToStart();
        robot.turnDrivetrain(0.5, 90);
         if (level == 3) {
            robot.moveAutonomousDrivetrainLeft(0.5, 20.5);
        }
        else {
            robot.moveAutonomousDrivetrainLeft(0.5, 14);
        }
        robot.moveAutonomousDrivetrain(1, 55);

    }
}