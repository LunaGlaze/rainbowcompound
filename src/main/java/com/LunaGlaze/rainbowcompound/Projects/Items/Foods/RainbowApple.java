package com.LunaGlaze.rainbowcompound.Projects.Items.Foods;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class RainbowApple extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder())
            .saturationMod(1.5F)
            .nutrition(3)
            .effect(() ->new MobEffectInstance(MobEffects.REGENERATION, 400, 2), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 2), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.ABSORPTION, 7200, 2), 1.0F)
            .alwaysEat()
            .build();
    public RainbowApple() {
        super(new Properties().food(food).rarity(Rarity.EPIC));
    }
}
