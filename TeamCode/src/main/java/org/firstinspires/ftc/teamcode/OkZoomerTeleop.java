package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.module.FourBarModule;
import org.firstinspires.ftc.teamcode.module.TwoMotorIntakeModule;
import org.macrobotics.cfcl.math.Util;
import org.macrobotics.cfcl.opmode.CFClOpMode;
import org.macrobotics.cfcl.robot.module.MecanumDriveModule;

@TeleOp(name = "Ok Zoomer")
public class OkZoomerTeleop extends CFClOpMode<KermitConfig> {
    @Override
    public KermitConfig createRobot() {
        return new KermitConfig(hardwareMap);
    }

    @Override
    public void update() {
        robot.getModule(MecanumDriveModule.class).setDriveDirection(Util.getGamepadInput(gamepad1));

        robot.getModule(FourBarModule.class).move(-gamepad2.left_stick_y);

        robot.getModule(TwoMotorIntakeModule.class).intake(
                (gamepad1.right_trigger - gamepad1.left_trigger) +
                (gamepad2.right_trigger - gamepad2.left_trigger));
    }
}
