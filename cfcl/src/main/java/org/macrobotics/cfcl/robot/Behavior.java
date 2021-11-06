package org.macrobotics.cfcl.robot;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

public abstract class Behavior {
    public @NotNull
    abstract Set<Class<? extends Module>> getRequiredModules();
}
