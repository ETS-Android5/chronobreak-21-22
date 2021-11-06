package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.macrobotics.cfcl.math.Transform;
import org.macrobotics.cfcl.math.Vector2;
import org.macrobotics.cfcl.module.MecanumDriveModule;
import org.macrobotics.cfcl.robot.RobotConfig;

@TeleOp()
public class TestTeleop extends OpMode {

    RobotConfig robot;

    @Override
    public void init() {
        robot = new TestbotConfig(hardwareMap);
        robot.init();
        robot.getModule(MecanumDriveModule.class).setSpeed(0.5);
    }

    @Override
    public void loop() {
        Transform tr = new Transform(new Vector2(gamepad1.left_stick_x, -gamepad1.left_stick_y),
                gamepad1.right_stick_x);
        robot.getModule(MecanumDriveModule.class).setDriveDirection(tr);

        telemetry.addData("Transform: ", tr);
    }
}
