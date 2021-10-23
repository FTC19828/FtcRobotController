package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Attachments.Carousel;

@Autonomous(name = "CarouselTest ", group="Autonomous")

public class CarouselTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        Carousel carousel = new Carousel(this);
        carousel.turnCarouselAutonomous();
    }
}
