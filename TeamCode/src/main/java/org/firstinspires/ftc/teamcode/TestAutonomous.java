package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.macrobotics.cfcl.math.Transform;
import org.macrobotics.cfcl.math.Vector2;
import org.macrobotics.cfcl.opmode.StepBasedOpMode;
import org.macrobotics.cfcl.opmode.autonomous.step.DriveByTimeStep;
import org.macrobotics.cfcl.opmode.autonomous.step.WaitStep;

@Autonomous()
@Disabled
public class TestAutonomous extends StepBasedOpMode<KermitConfig> {
    @Override
    public KermitConfig createRobot() {
        return new KermitConfig(hardwareMap);
    }

    @Override
    public StepQueueBuilder buildSteps() {
        return new StepQueueBuilder()
                .putStep(new WaitStep(robot, 10))
                .putStep(new DriveByTimeStep(robot, new Transform(new Vector2(0, 1)), 1.0));
    }
}
