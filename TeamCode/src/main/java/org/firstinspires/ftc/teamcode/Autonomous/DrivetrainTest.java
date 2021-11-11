package org.firstinspires.ftc.teamcode.Autonomous;


/////package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Drivetrain;

@Autonomous(name = "DrivetrainTest", group="Autonomous")

public class DrivetrainTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {




        waitForStart();

        Drivetrain drivetrain = new Drivetrain(this);

        drivetrain.moveAutonomousDrivetrainLeft( 0.5, 538);

    }
}
