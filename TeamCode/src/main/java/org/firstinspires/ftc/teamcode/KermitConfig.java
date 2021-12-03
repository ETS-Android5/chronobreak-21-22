package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.module.FourBarModule;
import org.macrobotics.cfcl.behavior.EncoderDriveBehavior;
import org.macrobotics.cfcl.module.MecanumDriveModule;
import org.macrobotics.cfcl.robot.RobotConfig;

public class KermitConfig extends RobotConfig {
    public KermitConfig(HardwareMap h) {
        super(h);
    }

    @Override
    public void addModules() {
        addModule(new MecanumDriveModule(getHardwareMap(), "left_front_drive",
                "right_front_drive", "left_back_drive", "right_back_drive"));
        addModule(new FourBarModule(getHardwareMap(), "left_arm", "right_arm"));
    }
}
