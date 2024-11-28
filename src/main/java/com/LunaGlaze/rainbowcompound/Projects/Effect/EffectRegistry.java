package com.LunaGlaze.rainbowcompound.Projects.Effect;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectRegistry {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, LunaUtils.MOD_ID);

    public static final RegistryObject<MobEffect> resonance_rainbow = EFFECTS.register("resonance_rainbow",()->
            new ResonanceOfRainbow(MobEffectCategory.BENEFICIAL, 16758465));
}
