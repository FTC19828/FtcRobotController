package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Attachments.Carousel;
import org.firstinspires.ftc.teamcode.Attachments.Drivetrain;

@Autonomous(name = "SideClawAutonomous2", group="Autonomous")

public class SideClawAutonomous2 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();

        Drivetrain drivetrain = new Drivetrain(this);
        Carousel carousel = new Carousel(this);

        drivetrain.moveAutonomousDrivetrainRight(0.5, 48);
        drivetrain.moveAutonomousDrivetrain( 0.2, 40);
        drivetrain.moveAutonomousDrivetrainLeft(0.5, 7);
        drivetrain.moveAutonomousDrivetrain(-0.2, -39);
        drivetrain.moveAutonomousDrivetrainRight(0.2, 26);
        carousel.turnCarouselAutonomous();
    }
}