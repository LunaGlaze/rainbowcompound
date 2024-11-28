package com.LunaGlaze.rainbowcompound.Linkage.farmersdelight;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class EnchantedGoldenAppleStew extends ConsumableItem {
    private static final FoodProperties food = (new FoodProperties.Builder())
            .saturationMod(1.8F)
            .nutrition(10)
            .effect(() ->new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 7200, 0), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 7200, 0), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.ABSORPTION, 3600, 3), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.HEALTH_BOOST, 4800, 1), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 0), 1.0F)
            .effect(() ->new MobEffectInstance(ModEffects.COMFORT.get(),3600,0),1.0F)
            .alwaysEat()
            .build();
    public EnchantedGoldenAppleStew() {
        super(new Properties().food(food).rarity(Rarity.EPIC),true);
    }

    public ItemStack getContainerItem(ItemStack itemStack) {
        return new ItemStack(Items.BOWL);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}
