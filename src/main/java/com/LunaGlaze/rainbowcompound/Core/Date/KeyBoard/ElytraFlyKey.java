package com.LunaGlaze.rainbowcompound.Core.Date.KeyBoard;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public enum ElytraFlyKey {
    ELYTRA_FLY_KEY("dynamicelytra_fly", GLFW.GLFW_KEY_SPACE);
    private KeyMapping keybind;
    private String description;
    private int key;
    private boolean modifiable;

    ElytraFlyKey(String description, int defaultKey) {
        this.description = LunaUtils.MOD_ID + ".key."+ description;
        this.key = defaultKey;
        this.modifiable = !description.isEmpty();
    }

    public static void register() {
        for (ElytraFlyKey key : values()) {
            key.keybind = new KeyMapping(key.description, key.key, LunaUtils.NAME);
            if (!key.modifiable)
                continue;

            ClientRegistry.registerKeyBinding(key.keybind);
        }
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
