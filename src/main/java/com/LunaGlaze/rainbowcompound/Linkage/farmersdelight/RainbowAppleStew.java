package com.LunaGlaze.rainbowcompound.Linkage.farmersdelight;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class RainbowAppleStew extends ConsumableItem {
    private static final FoodProperties food = (new FoodProperties.Builder())
            .saturationModifier(1.8F)
            .nutrition(10)
            .effect(() ->new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600, 0), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 4800, 0), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.ABSORPTION, 3600, 2), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.HEALTH_BOOST, 4800, 0), 1.0F)
            .effect(() ->new MobEffectInstance(ModEffects.COMFORT,3600,0),1.0F)
            .alwaysEdible()
            .build();
    public RainbowAppleStew() {
        super(new Properties().food(food).rarity(Rarity.EPIC),true);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) { return new ItemStack(Items.BOWL); }
}
