package com.LunaGlaze.rainbowcompound.Linkage.farmersdelight;

import com.LunaGlaze.rainbowcompound.Core.Group.CreativeModeTabGroup;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class GoldenAppleStew extends ConsumableItem {
    private static final FoodProperties food = (new FoodProperties.Builder())
            .saturationMod(1.8F)
            .nutrition(10)
            .effect(() ->new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600, 0), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.ABSORPTION, 3600, 0), 1.0F)
            .effect(() ->new MobEffectInstance(ModEffects.COMFORT.get(),3600,0),1.0F)
            .alwaysEat()
            .build();
    public GoldenAppleStew() {
        super(new Properties().food(food).tab(CreativeModeTabGroup.group).rarity(Rarity.RARE),true);
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return new ItemStack(Items.BOWL);
    }
}
