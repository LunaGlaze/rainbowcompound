package com.LunaGlaze.rainbowcompound.Projects.Effect;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.UUID;

public class ResonanceOfRainbow extends MobEffect {

    UUID uuid = UUID.fromString("01824268-444A-DB5D-778F-818046107C6A");

    public ResonanceOfRainbow(MobEffectCategory pCategory, int pColor) {
        super(pCategory,pColor);
        this.addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID,uuid.toString()), (double)0.25F, AttributeModifier.Operation.ADD_VALUE)
                .addAttributeModifier(Attributes.ENTITY_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID,uuid.toString()), (double)0.25F, AttributeModifier.Operation.ADD_VALUE)
                .addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID,uuid.toString()), 5.0D, AttributeModifier.Operation.ADD_VALUE)
                .addAttributeModifier(Attributes.ARMOR_TOUGHNESS, ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID,uuid.toString()), 1, AttributeModifier.Operation.ADD_VALUE)
                .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID,uuid.toString()), 0.05, AttributeModifier.Operation.ADD_VALUE);
    }
    public Object getEffectRendererInternal() {
        return null;
    }
}
