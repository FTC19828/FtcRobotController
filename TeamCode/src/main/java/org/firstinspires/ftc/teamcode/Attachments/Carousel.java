package org.firstinspires.ftc.teamcode.Attachments;
//This is a change-Ayaan

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Carousel {
// nitya's change
    private LinearOpMode op;

    DcMotor CarouselMotor = null;

    public Carousel(LinearOpMode opMode) {
        this.op = opMode;
        CarouselMotor = op.hardwareMap.dcMotor.get("CarouselMotor");
        CarouselMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void turnCarouselAutonomous(){
        CarouselMotor.setPower(-0.5);
        this.op.sleep(3000);
        CarouselMotor.setPower(0);
    }
    public void turnCarouselTeleop(boolean CarouselOn){
        if (CarouselOn) {
            CarouselMotor.setPower(-0.5);
        }
    }
    public void stopCarouselTeleop(boolean CarouselOn) {
        if (!CarouselOn) {
            CarouselMotor.setPower(0);
        }
    }
    //something
}
//abc
