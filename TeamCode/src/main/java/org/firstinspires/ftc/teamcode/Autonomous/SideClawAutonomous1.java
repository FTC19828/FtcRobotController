package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Attachments.Carousel;
import org.firstinspires.ftc.teamcode.Attachments.Drivetrain;

@Autonomous(name = "SideClawAutonomous1", group="Autonomous")

public class SideClawAutonomous1 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();

        Drivetrain drivetrain = new Drivetrain(this);
        Carousel carousel = new Carousel(this);

        drivetrain.moveAutonomousDrivetrain( 0.2, 40);
        drivetrain.moveAutonomousDrivetrainLeft(0.5, 7);
        drivetrain.moveAutonomousDrivetrain(-0.2, -39);
        drivetrain.moveAutonomousDrivetrainRight(0.2, 26);
        carousel.turnCarouselAutonomous();

    }
}
