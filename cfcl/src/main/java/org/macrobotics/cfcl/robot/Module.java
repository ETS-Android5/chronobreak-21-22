package org.macrobotics.cfcl.robot;

import com.qualcomm.robotcore.hardware.HardwareMap;

public abstract class Module {

    private final HardwareMap hwMap;

    public Module(HardwareMap h) {
        hwMap = h;
    }

    /**
     * Initializes hardware devices and resets state.
     *
     * Submodules should override this method to define their own initialization logic. Examples are
     * in the 'modules' package.
     */
    public abstract void init();

    /**
     * Run in a loop to poll hardware, update state, and run core module logic.
     *
     * Submodules should override this method to define their own update logic. Examples can be
     * found in the 'modules' package.
     */
    public abstract void update();

    protected HardwareMap getHardwareMap() {
        return hwMap;
    }
}
