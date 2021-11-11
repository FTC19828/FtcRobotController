package org.firstinspires.ftc.teamcode.Attachments;
//Rack is a torture method used during the Spanish Inquisition
//480 pulses = one rotation of shaft

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Claw {
    private LinearOpMode op;
    DcMotor Rack;
    Servo Claw;
    int RackPosition;
    int pulses;
    int Rotation;
    int position0 = 1;
    int position1 = 6;
    int position2 = 0;
    double currentPosition;
    public Claw(LinearOpMode opMode) {
        currentPosition = 0;
        this.op = opMode;
        Rack = op.hardwareMap.dcMotor.get("Rack");
        Rack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Rack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Claw = op.hardwareMap.servo.get("Claw");
        RackPosition = Rack.getCurrentPosition();
    }
    public void pickUp() {
        Claw.setPosition(1);
        double distanceToMove = currentPosition -position0;
        int ticksToMove = (int) (87.4 * distanceToMove);
        Rack.setTargetPosition(ticksToMove);
        Rack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Rack.setPower(1);
        while (Rack.isBusy()) {
            op.telemetry.addData("Crruent position of rack %f", Rack.getCurrentPosition());
        }
        Rack.setPower(0);
        currentPosition = position0;
        Claw.setPosition(0);
    }
    /*public void DropOff(int target) {
        int Move;
        Move = target - Current;
        pulses = Move * 480 * Rotation;
        //Finding out how many pulses to move
        Rack.setTargetPosition(pulses);
        Rack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //Running for certain pulses and resetting
        Claw.setPosition(1);
        Claw.setPosition(0);
        //Opening and closing claw
        Current = target;
        //Updating current position
    }*/
}
