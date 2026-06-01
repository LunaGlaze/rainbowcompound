package com.LunaGlaze.rainbowcompound.Core.Date.KeyBoard;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public enum ElytraFlyKey {
    ELYTRA_FLY_KEY("dynamicelytra_fly", GLFW.GLFW_KEY_SPACE);
    public KeyMapping keybind;
    public String description;
    public int key;
    public boolean modifiable;

    ElytraFlyKey(String description, int defaultKey) {
        this.description = LunaUtils.MOD_ID + ".key."+ description;
        this.key = defaultKey;
        this.modifiable = !description.isEmpty();
    }

    public KeyMapping getKeybind() {
        return keybind;
    }


    public boolean isPressed() {
        if (!modifiable)
            return isKeyDown(key);
        return keybind.isDown();
    }

    public static boolean isKeyDown(int key) {
        return InputConstants.isKeyDown(Minecraft.getInstance()
                .getWindow()
                .getWindow(), key);
    }

}
