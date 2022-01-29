package org.firstinspires.ftc.teamcode.module;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.macrobotics.cfcl.robot.Module;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FourBarModule extends Module {

    public Set<DcMotor> motors;

    double sensitivity = 20;

    public FourBarModule(HardwareMap h, boolean invertOdd, String... motorNames) {
        super(h);

        motors = Arrays.stream(motorNames)
                .map(name -> getHardwareMap().dcMotor.get(name))
                .collect(Collectors.toSet());

        AtomicInteger i = new AtomicInteger();
        motors.forEach(motor -> {
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor.setTargetPosition(0);
            motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor.setPower(1);

            if (invertOdd && i.incrementAndGet() % 2 == 1) {
                motor.setDirection(DcMotorSimple.Direction.REVERSE);
            }
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
