package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.module.FourBarModule;
import org.firstinspires.ftc.teamcode.module.TwoMotorIntakeModule;
import org.macrobotics.cfcl.robot.behavior.EncoderDriveBehavior;
import org.macrobotics.cfcl.robot.module.MecanumDriveModule;
import org.macrobotics.cfcl.robot.Behavior;
import org.macrobotics.cfcl.robot.Module;
import org.macrobotics.cfcl.robot.RobotConfig;

import java.util.Collection;

public class KermitConfig extends RobotConfig {
    public KermitConfig(HardwareMap h) {
        super(h);
    }

    @Override
    public void addModules(Collection<Module> modules) {
        modules.add(new MecanumDriveModule(getHardwareMap(), "left_front_drive",
                "right_front_drive", "left_back_drive", "right_back_drive"));
        getModule(MecanumDriveModule.class).reverseRight();

        modules.add(new FourBarModule(getHardwareMap(), true,
                "left_arm", "right_arm"));

        modules.add(new TwoMotorIntakeModule(getHardwareMap(),
                "left_intake", "right_intake"));
        getModule(TwoMotorIntakeModule.class).setSpeed(0.6);
    }

    @Override
    public void addBehaviours(Collection<Behavior> behaviors) {
        behaviors.add(new EncoderDriveBehavior(getModule(MecanumDriveModule.class)));
    }
}
