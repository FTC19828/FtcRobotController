package org.firstinspires.ftc.teamcode.Attachments;

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
        CarouselMotor.setPower(2);
        this.op.sleep(3000);
        CarouselMotor.setPower(0);
    }
    public void turnCarouselTeleop(boolean CarouselOn){
        if (CarouselOn) {
            CarouselMotor.setPower(2);
        }
    }
    public void stopCarouselTeleop(boolean CarouselOn) {
        if (!CarouselOn) {
            CarouselMotor.setPower(0);
        }
    }
}
