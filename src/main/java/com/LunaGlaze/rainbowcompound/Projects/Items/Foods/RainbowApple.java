package com.LunaGlaze.rainbowcompound.Projects.Items.Foods;

import com.LunaGlaze.rainbowcompound.Core.Group.CreativeModeTabGroup;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class RainbowApple extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder())
            .saturationMod(1.5F)
            .nutrition(3)
            .effect(() ->new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 0), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 4000, 0), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.ABSORPTION, 2400, 2), 1.0F)
            .alwaysEat()
            .build();
    public RainbowApple() {
        super(new Properties().food(food).tab(CreativeModeTabGroup.group).rarity(Rarity.EPIC));
    }
}
