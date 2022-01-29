package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.module.FourBarModule;
import org.firstinspires.ftc.teamcode.module.TwoMotorIntakeModule;
import org.macrobotics.cfcl.math.Transform;
import org.macrobotics.cfcl.math.Util;
import org.macrobotics.cfcl.math.Vector2;
import org.macrobotics.cfcl.robot.module.MecanumDriveModule;
import org.macrobotics.cfcl.robot.RobotConfig;

@TeleOp()
@Disabled
public class TestTeleop extends OpMode {

    RobotConfig robot;

    @Override
    public void init() {
        robot = new KermitConfig(hardwareMap);
        robot.init();
        robot.getModule(MecanumDriveModule.class).setSpeed(1);
    }

    @Override
    public void loop() {
        Transform tr = new Transform(new Vector2(gamepad1.left_stick_x, -gamepad1.left_stick_y),
                gamepad1.right_stick_x);
        robot.getModule(MecanumDriveModule.class).setDriveDirection(tr);

        robot.getModule(FourBarModule.class).move(
                Util.toInt(gamepad1.dpad_down) - Util.toInt(gamepad1.dpad_up));

        robot.getModule(TwoMotorIntakeModule.class).intake(
                gamepad1.right_trigger - gamepad1.left_trigger);
    }
}
