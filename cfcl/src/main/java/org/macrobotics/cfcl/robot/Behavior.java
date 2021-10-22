package org.macrobotics.cfcl.robot;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class Behavior {
    public @NotNull abstract List<Class<? extends Module>> getRequiredModules();
}
