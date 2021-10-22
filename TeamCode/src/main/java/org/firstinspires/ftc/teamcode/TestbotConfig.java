package org.firstinspires.ftc.teamcode;

import org.macrobotics.cfcl.behavior.EncoderDriveBehavior;
import org.macrobotics.cfcl.module.MecanumDriveModule;
import org.macrobotics.cfcl.robot.RobotConfig;

public class TestbotConfig extends RobotConfig {
    public TestbotConfig() {
        addModule("drive", new MecanumDriveModule());

        addBehavior(new EncoderDriveBehavior());
    }
}
