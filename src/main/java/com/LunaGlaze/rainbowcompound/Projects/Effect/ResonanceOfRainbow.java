package com.LunaGlaze.rainbowcompound.Projects.Effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.ForgeMod;

import java.util.UUID;

public class ResonanceOfRainbow extends MobEffect {

    UUID uuid = UUID.fromString("01824268-444A-DB5D-778F-818046107C6A");

    public ResonanceOfRainbow(MobEffectCategory pCategory, int pColor) {
        super(pCategory,pColor);
        this.addAttributeModifier(ForgeMod.BLOCK_REACH.get(), String.valueOf(uuid), (double)0.25F, AttributeModifier.Operation.ADDITION)
                .addAttributeModifier(ForgeMod.ENTITY_REACH.get(), String.valueOf(uuid), (double)0.25F, AttributeModifier.Operation.ADDITION)
                .addAttributeModifier(Attributes.MAX_HEALTH, String.valueOf(uuid), 5.0D, AttributeModifier.Operation.ADDITION)
                .addAttributeModifier(Attributes.ARMOR_TOUGHNESS, String.valueOf(uuid), 1, AttributeModifier.Operation.ADDITION)
                .addAttributeModifier(Attributes.MOVEMENT_SPEED, String.valueOf(uuid), 0.05, AttributeModifier.Operation.ADDITION);
    }
    public Object getEffectRendererInternal() {
        return null;
    }
}
