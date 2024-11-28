package com.LunaGlaze.rainbowcompound.Core.Date.KeyBoard;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
        value = {Dist.CLIENT},
        bus = EventBusSubscriber.Bus.MOD
)
public enum ElytraFlyKey {
    ELYTRA_FLY_KEY("dynamicelytra_fly", 32);

    private KeyMapping keybind;
    private String description;
    private int key;
    private boolean modifiable;

    private ElytraFlyKey(String description, int defaultKey) {
        this.description = "rainbowcompound.key." + description;
        this.key = defaultKey;
        this.modifiable = !description.isEmpty();
    }

    @SubscribeEvent
    public static void register(RegisterKeyMappingsEvent event) {
        ElytraFlyKey[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ElytraFlyKey key = var1[var3];
            key.keybind = new KeyMapping(key.description, key.key, LunaUtils.NAME);
            if (key.modifiable) {
                event.register(key.keybind);
            }
        }

    }

    public KeyMapping getKeybind() {
        return this.keybind;
    }

    public boolean isPressed() {
        return !this.modifiable ? isKeyDown(this.key) : this.keybind.isDown();
    }

    public static boolean isKeyDown(int key) {
        return InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), key);
    }
}
