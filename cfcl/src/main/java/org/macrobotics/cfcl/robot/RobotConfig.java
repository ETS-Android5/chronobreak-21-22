package org.macrobotics.cfcl.robot;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class RobotConfig {
    private HashMap<String, Module> modules;
    private ArrayList<Behavior> behaviors;

    /**
     * Initializes the robot and sets up modules/behaviors.
     *
     * Trying to mess with any of the robot methods without calling this will almost always result
     * in Bad Stuff. Don't do it.
     */
    public void init() {

    }

    @SuppressWarnings("unchecked")
    public <T extends Module> T getModule(@NotNull String name) {
        Module m = modules.get(name);
        return (T) m;
    }

    @SuppressWarnings("unchecked")
    public <T extends Behavior> T getBehavior(@NotNull Class<T> cls) {
        return (T) behaviors.stream().filter(cls::isInstance)
                .findFirst().orElse(null);
    }

    /**
     * Used by subclasses to add modules to themselves.
     * @param name The module's reference name.
     * @param mod The module to add.
     */
    protected void addModule(@NotNull String name, @NotNull Module mod) {
        modules.put(name, mod);
    }

    /**
     * Used by subclasses to add behaviors to themselves.
     * @param bhv The behavior to add.
     */
    protected void addBehavior(@NotNull Behavior bhv) {
        behaviors.add(bhv);
    }
}
