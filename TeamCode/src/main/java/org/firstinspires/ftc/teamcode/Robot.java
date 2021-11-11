package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Attachments.Carousel;
import org.firstinspires.ftc.teamcode.Attachments.Claw;
import org.firstinspires.ftc.teamcode.Attachments.Drivetrain;

public class Robot {

    private LinearOpMode op;
    Carousel carousel = null;
    Claw claw = null;
    Drivetrain drivetrain = null;

    public Robot(LinearOpMode opmode) {
        op = opmode;
        carousel = new Carousel(op);
        Claw claw = new Claw(op);
        Drivetrain drivetrain = new Drivetrain(op);
    }

    public void turnCarouselAutonomous() {
        carousel.turnCarouselAutonomous();
    }
    public void turnCarouselTeleop(boolean CarouselOn) {
        carousel.turnCarouselTeleop(CarouselOn);
    }

    public void stopCarouselTeleop(boolean CarouselOn) {
        carousel.stopCarouselTeleop(CarouselOn);
    }

    public void pickUp() {
        claw.pickUp();
    }

    public void moveTeleopDrivetrain(double y, double x, double rx) {
        drivetrain.moveTeleopDrivetrain(y, x, rx);
    }

    public void moveAutonomousDrivetrain(double power, double inches) {
        drivetrain.moveAutonomousDrivetrain(power, inches);
    }

    public void moveAutonomousDrivetrainLeft(double power, double inches) {
        drivetrain.moveAutonomousDrivetrainLeft(power, inches);
    }

    public void moveAutonomousDrivetrainRight(double power, double inches) {
        drivetrain.moveAutonomousDrivetrainRight(power, inches);
    }
}
