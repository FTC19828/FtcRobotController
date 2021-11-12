package org.firstinspires.ftc.teamcode.Autonomous;


/////package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Attachments.Drivetrain;

@Autonomous(name = "DrivetrainTest", group="Autonomous")

public class DrivetrainTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {




        waitForStart();

        Drivetrain drivetrain = new Drivetrain(this);

        drivetrain.turnDrivetrain(0.5, -90);
    }
}
