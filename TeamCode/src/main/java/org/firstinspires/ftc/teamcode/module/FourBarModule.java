package org.firstinspires.ftc.teamcode.module;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.macrobotics.cfcl.robot.Module;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FourBarModule extends Module {

    Set<DcMotor> motors;

    double sensitivity;

    public FourBarModule(HardwareMap h, String... motorNames) {
        super(h);

        motors = Arrays.stream(motorNames)
                .map(name -> getHardwareMap().dcMotor.get(name))
                .collect(Collectors.toSet());

        motors.forEach(motor -> {
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        });
    }

    public void move(double delta) {
        motors.forEach(motor ->
                motor.setTargetPosition(motor.getTargetPosition() + (int)(delta * sensitivity)));
    }

    public void setSensitivity(double nS) {
        sensitivity = nS;
    }
}
