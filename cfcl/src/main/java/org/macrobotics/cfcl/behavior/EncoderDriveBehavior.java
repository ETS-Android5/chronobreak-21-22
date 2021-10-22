package org.macrobotics.cfcl.behavior;

import org.jetbrains.annotations.NotNull;
import org.macrobotics.cfcl.module.DriveModule;
import org.macrobotics.cfcl.robot.Behavior;
import org.macrobotics.cfcl.robot.Module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EncoderDriveBehavior extends Behavior {
    @Override
    public @NotNull List<Class<? extends Module>> getRequiredModules() {
        return new ArrayList<>(Collections.singleton(DriveModule.class));
    }
}
