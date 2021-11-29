package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Attachments.Carousel;
import org.firstinspires.ftc.teamcode.Attachments.Drivetrain;
import org.firstinspires.ftc.teamcode.R;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "FinalAutonomous", group="Autonomous")

public class FinalAutonomous extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();

        Robot robot = new Robot(this);

        robot.moveAutonomousDrivetrain(-0.5, -6);
        robot.turnDrivetrain(0.5, -90);
        robot.moveAutonomousDrivetrain(0.5, 15.75);
        robot.turnCarouselAutonomous();
        robot.moveAutonomousDrivetrain(-0.5, -46);
        robot.turnDrivetrain(0.5, 90);
        robot.moveAutonomousDrivetrain(-0.5, -15);
        robot.deliverFreight(3);
        robot.setArmToStart();
        robot.turnDrivetrain(0.5, 90);
        robot.moveAutonomousDrivetrainLeft(0.5, 22);
        robot.moveAutonomousDrivetrain(0.5, 53);
    }
}