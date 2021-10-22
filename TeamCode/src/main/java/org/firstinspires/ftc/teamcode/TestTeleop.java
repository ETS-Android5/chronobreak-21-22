package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.macrobotics.cfcl.robot.RobotConfig;

public class TestTeleop extends OpMode {
    RobotConfig robot = new TestbotConfig();

    @Override
    public void init() {
        robot.init();
    }

    @Override
    public void loop() {
        robot.getModule("drive");
    }
}
