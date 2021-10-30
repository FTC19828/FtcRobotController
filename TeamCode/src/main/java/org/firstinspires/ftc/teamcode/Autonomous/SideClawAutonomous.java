package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.checkerframework.checker.units.qual.C;
import org.firstinspires.ftc.teamcode.Attachments.Carousel;
import org.firstinspires.ftc.teamcode.Drivetrain;

@Autonomous(name = "SideClawAutonomous", group="Autonomous")

public class SideClawAutonomous extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();

        Drivetrain drivetrain = new Drivetrain(this);
        Carousel carousel = new Carousel(this);

        drivetrain.moveAutonomousDrivetrain( 0.2, 40);
        drivetrain.moveAutonomousDrivetrainLeft(0.5, 7);
        drivetrain.moveAutonomousDrivetrain(-0.2, -39);
        drivetrain.moveAutonomousDrivetrainRight(0.2, 27);
        carousel.turnCarouselAutonomous();

    }
}
