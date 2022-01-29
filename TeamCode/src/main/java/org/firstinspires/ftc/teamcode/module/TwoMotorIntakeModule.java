package org.firstinspires.ftc.teamcode.module;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.macrobotics.cfcl.robot.Module;

public class TwoMotorIntakeModule extends Module {

    private final DcMotor left, right;

    public double speed = 1;

    public TwoMotorIntakeModule(HardwareMap h, String lm, String rm) {
        super(h);

        left = getHardwareMap().dcMotor.get(lm);
        right = getHardwareMap().dcMotor.get(rm);

        left.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void intake(double s) {
        left.setPower(s * speed);
        right.setPower(s * speed);
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
