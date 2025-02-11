package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Attachments.Arm;
import org.firstinspires.ftc.teamcode.Attachments.Carousel;
import org.firstinspires.ftc.teamcode.Attachments.Drivetrain;
import org.firstinspires.ftc.teamcode.Attachments.Intake;

public class Robot {

    private LinearOpMode op;
    Carousel carousel = null;
//    Claw claw = null;
    Drivetrain drivetrain = null;
    Intake intake = null;
    Arm arm = null;

    public Robot(LinearOpMode opmode) {
        this.op = opmode;
        carousel = new Carousel(op);
//        claw = new Claw(op);
        drivetrain = new Drivetrain(op);
        intake = new Intake(op);
        arm = new Arm(op);
        arm.start();

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

//    public void pickUp() {
//        claw.pickUp();
//    }

    public void moveTeleopDrivetrain(double y, double x, double rx) {
        drivetrain.moveTeleopDrivetrain(y, x, rx);
    }

    public void moveTeleopDrivetrainSlow(double y, double x, double rx) {
        drivetrain.moveTeleopDrivetrainSlow(y, x, rx);
    }

    public void moveTeleopDrivetrainFast(double y, double x, double rx){
        drivetrain.moveTeleopDrivetrainFast(y, x, rx);
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

    public void turnDrivetrain(double power, double angle) {
        drivetrain.turnDrivetrain(power, angle);
    }

    public void turnIntakeForward(boolean intakeOn) {
        intake.turnIntakeForward(intakeOn);
    }

    public void turnIntakeBackward(boolean intakeOn) {
        intake.turnIntakeBackward(intakeOn);
    }

    public void stopIntake(boolean forwardOff, boolean backwardOff) {
        intake.stopIntake(forwardOff, backwardOff);
    }

    public void deliverFreight(int level) {
        arm.setTargetPosition(level);
    }

    public void setArmToStart() {
        arm.setTargetPosition(0);
    }
}


