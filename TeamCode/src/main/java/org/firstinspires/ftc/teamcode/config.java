package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Config () {
  public static DcMotorEx frontLeft;
  public static DcMotorEx frontRight;
  public static DcMotorEx backLeft;
  public static DcMotorEx backRight;
  public static DcMotorEx vert1;
  public static DcMotorEx vert2;
  public static Servo extendo1;
  public static Servo extendo2;
  try {
    frontLeft = hardwareMap.get(DcMotorEx.class, "fl");
  } catch (Exception e) {
    telemetry.addData("Front left motor failed to initialize. Error", e);
  }
  try {
    frontRight = hardwareMap.get(DcMotorEx.class, "fr");
  } catch (Exception e) {
    telemetry.addData("Front right motor failed to initialize. Error", e);
  }
  try {
    backLeft = hardwareMap.get(DcMotorEx.class, "bl");
  } catch (Exception e) {
    telemetry.addData("Back left motor failed to initialize. Error", e);
  }
  
  try {
    backRight = hardwareMap.get(DcMotorEx.class, "br");
  } catch (Exception e) {
    telemetry.addData("Back right motor failed to initialize. Error", e);
  }
  try {
    vert1 = hardwareMap.get(DcMotorEx.class, "vert1");
  } catch (Exception e) {
    telemetry.addData("Vertical slides motor #1 failed to initialize. Error", e);
  }
  try {
    vert2 = hardwareMap.get(DcMotorEx.class, "vert2");
  } catch (Exception e) {
    telemetry.addData("Vertical slides motor #2 failed to initialize. Error", e);
  }
  try {
    extendo1 = hardwareMap.get(Servo.class, "extendo1");
  } catch (Exception e) {
    telemetry.addData("Extendo servo #1 failed to initialize. Error", e);
  }
  try {
    extendo2 = hardwareMap.get(Servo.class, "extendo2");
  } catch (Exception e) {
    telemetry.addData("Extendo servo #2 failed to initialize. Error", e);
  }
  try {
    wrist1 = hardwareMap.get(Servo.class, "wrist1");
  } catch (Exception e) {
    telemetry.addData("Wrist servo #1 failed to initialize. Error", e);
  }
  try {
    wrist2 = hardwareMap.get(Servo.class, "wrist2");
  } catch (Exception e) {
    telemetry.addData("Wrist servo #2 failed to initialize. Error", e);
  }
  try {
    bucket1 = hardwareMap.get(Servo.class, "bucket1");
  } catch (Exception e) {
    telemetry.addData("Bucket servo #1 failed to initialize. Error", e);
  }
  try {
    bucket2 = hardwareMap.get(Servo.class, "bucket2");
  } catch (Exception e) {
    telemetry.addData("Bucket servo #2 failed to initialize. Error", e);
  }
}

