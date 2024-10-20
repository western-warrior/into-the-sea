package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.subsystems.LinearSlide;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name = "BoomerangTeleop")
public class BoomerangTeleop extends LinearOpMode {
    @Override
    public void runOpMode() {
        Gamepad currGamepad = new Gamepad();
        Gamepad prevGamepad = new Gamepad();
        //init drivetrain
        DriveTrain driveTrain = new DriveTrain(hardwareMap,
                new String[]{"frontRight", "frontLeft", "backRight", "backLeft"},
                org.firstinspires.ftc.teamcode.subsystems.DriveTrain.Reverse.RevLeft,
                "imu",
                new IMU.Parameters(
                        new RevHubOrientationOnRobot(
                                RevHubOrientationOnRobot.LogoFacingDirection.FORWARD,
                                RevHubOrientationOnRobot.UsbFacingDirection.UP
                        )
                ),
                x -> x
        );
        DcMotorEx arm = hardwareMap.get(DcMotorEx.class, "Arm");
        DcMotorEx slides = hardwareMap.get(DcMotorEx.class, "Slides");
        arm.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        slides.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        waitForStart();

        Servo claw;
        Servo wrist;

//        boolean claw_up = false;
        boolean arm_up = false;
        int sample = 0;

        int lift = slides.getCurrentPosition();

        while (opModeIsActive()) {
            prevGamepad.copy(currGamepad);
            currGamepad.copy(gamepad1);

            driveTrain.update(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x, gamepad1.start);
            //arm.update(currGamepad.dpad_up && !prevGamepad.dpad_up, false, false, false);
            //if (gamepad1.dpad_up)
            //foo.setPower(1.0);
            //else foo.setPower(0.0);


            // code goes here!,

            //lift = slides.getCurrentPosition();

                //programs A button for claw
//                if (gamepad1.a){
//                    if (!claw_up) {
//                        claw.setPosition(1);
//                        claw_up = true;
//                    }
//                    else{
//                        claw.setPosition(0);
//                        claw_up = false;
//                    }
//                }

            //checks to see if the arm is up. Then brings it down or takes it down.
            //programs B button for arm
            if (gamepad1.b){
                    arm.setTargetPosition(5);
                    arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

                    arm.setPower(0.015);
                    //wrist.setPosition(1);
//                        claw.setPosition(1);
                    arm_up = true;
//                        claw_up = true;
                }
                if  (gamepad1.left_bumper) {
                    arm.setTargetPosition(0);


                    arm.setPower(0.015);
                    //wrist.setPosition(0.5);
                    arm_up = false;
                    arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

                } else if (gamepad1.right_bumper) {
                    arm.setPower(0.015);
                    arm.setTargetPosition(0);
                    arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
                } else {
                    arm.setPower(0);
                }


            if (gamepad1.x) {
                sample ++;

                    //arm.setDirection(DcMotorEx.Direction.REVERSE);
                    arm.setPower(0.015);
                    arm.setTargetPosition(0);
                    //wrist.setPosition(0);
                arm_up = false;}


            if (gamepad1.y){
                    arm.setTargetPosition(5);
                    arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
                    arm.setPower(0.015);

                    arm_up = true;
                }
                if (gamepad1.dpad_down) {
                    arm.setTargetPosition(0);
                    arm.setPower(0.015);

                    arm_up = false;
                }


            //moves the slides up while right trigger is pressed
            if(gamepad1.right_trigger >= 0.3) {

                if (slides.getCurrentPosition() < 5) {
                    slides.setPower(0.015);
                    slides.setTargetPosition(5);
                    lift = slides.getCurrentPosition();
                }
                slides.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            } else if (gamepad1.left_trigger >= 0.3) {


                if (slides.getCurrentPosition() > 0) {
                    slides.setPower(-0.015);
                    slides.setTargetPosition(0);
                    lift = slides.getCurrentPosition();
                }
                slides.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            } else {
                slides.setTargetPosition(lift);
                slides.setPower(0);
                slides.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            }
        }
    }
}


