package com.LunaGlaze.rainbowcompound.Projects.Effect;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EffectRegistry {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, LunaUtils.MOD_ID);

    public static final DeferredHolder<MobEffect, MobEffect> resonance_rainbow = EFFECTS.register("resonance_rainbow",()->
            new ResonanceOfRainbow(MobEffectCategory.BENEFICIAL, 16758465));
}
