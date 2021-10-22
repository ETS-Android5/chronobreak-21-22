package org.macrobotics.cfcl.robot;

public abstract class Module {
    /**
     * Submodules should override this method to define their own update logic. Examples can be
     * found in the 'modules' package.
     */
    public abstract void update();
}
