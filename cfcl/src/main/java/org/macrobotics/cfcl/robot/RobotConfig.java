package org.macrobotics.cfcl.robot;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public abstract class RobotConfig {
    private final HashMap<String, Module> modules = new HashMap<>();
    private final ArrayList<Behavior> behaviors = new ArrayList<>();

    private final HardwareMap hwMap;

    public RobotConfig(HardwareMap h) {
        h.analogInput.size();
        hwMap = h;
    }

    /**
     * Adds the required hardware modules to the robot.
     *
     * Subclasses should override this to define the modules they want to load. Adding modules
     * anywhere else will probably break stuff, so don't.
     */
    public abstract void addModules();

    /**
     * Initializes the robot and sets up modules/behaviors.
     *
     * Trying to mess with any of the robot methods without calling this will almost always result
     * in Bad Stuff. Don't do it.
     */
    public void init() {
        addModules();
        modules.forEach( (n, m) -> m.init() );
        behaviors.forEach( b -> {} );
    }

    /**
     * Gets a module from the robot config and returns it, or null if the module couldn't be found /
     * was the wrong type.
     * @param cls The class of the module you're expecting.
     * @param name The name of the module you want to get.
     * @param <T> The type of the module you're expecting.
     * @return The module, or null if the module doesn't exist / is the wrong type.
     */
    public <T extends Module> T getModule(@NotNull Class<T> cls, @NotNull String name) {
        Module m = modules.get(name);
        try {
            return cls.isInstance(m) ? cls.cast(m): null;
        } catch (ClassCastException cce) {
            return null;
        }
    }

    public <T extends Behavior> T getBehavior(@NotNull Class<T> cls) {
        try {
            return behaviors.stream().filter(cls::isInstance).map(cls::cast)
                    .findFirst().orElse(null);
        } catch (ClassCastException cce) {
            return null;
        }
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

    public HardwareMap getHardwareMap() {
        return hwMap;
    }
}
