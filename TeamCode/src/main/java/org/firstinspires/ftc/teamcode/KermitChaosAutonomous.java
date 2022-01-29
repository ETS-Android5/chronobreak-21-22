package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.macrobotics.cfcl.math.Transform;
import org.macrobotics.cfcl.math.Vector2;
import org.macrobotics.cfcl.opmode.StepBasedOpMode;
import org.macrobotics.cfcl.opmode.autonomous.step.DriveByTimeStep;

@Autonomous(name = "Kermit Chaos")
public class KermitChaosAutonomous extends StepBasedOpMode<KermitConfig> {
    @Override
    public KermitConfig createRobot() {
        return new KermitConfig(hardwareMap);
    }

    @Override
    public StepQueueBuilder buildSteps() {
        return new StepQueueBuilder()
                .putStep(new DriveByTimeStep(robot, new Transform(new Vector2(0, 1)), 1.0));
    }
}
