package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.macrobotics.cfcl.behavior.EncoderDriveBehavior;
import org.macrobotics.cfcl.module.MecanumDriveModule;
import org.macrobotics.cfcl.robot.RobotConfig;

public class TestbotConfig extends RobotConfig {
    public TestbotConfig(HardwareMap h) {
        super(h);
    }

    @Override
    public void addModules() {
        addModule("drive", new MecanumDriveModule(getHardwareMap(), "left_front_drive",
                "right_front_drive", "left_back_drive", "right_back_drive"));

        addBehavior(new EncoderDriveBehavior());
    }
}
