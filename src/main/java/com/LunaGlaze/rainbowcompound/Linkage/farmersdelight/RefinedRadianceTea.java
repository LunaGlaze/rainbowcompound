package com.LunaGlaze.rainbowcompound.Linkage.farmersdelight;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import javax.annotation.Nullable;
import java.util.List;

public class RefinedRadianceTea extends DrinkableItem {
    private static final FoodProperties food = (new FoodProperties.Builder())
            .saturationMod(0.5F)
            .nutrition(3)
            .effect(() ->new MobEffectInstance(MobEffects.DIG_SPEED, 7200, 0), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.HARM, 1, 0), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.CONFUSION, 80, 0), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.GLOWING, 100, 0), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.NIGHT_VISION, 3600, 0), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.LEVITATION, 400, 0), 1.0F)
            .effect(() ->new MobEffectInstance(MobEffects.POISON, 400, 0), 1.0F)
            .alwaysEat()
            .build();

    public RefinedRadianceTea(){
        super(new Properties().food(food).rarity(Rarity.UNCOMMON));
    }

    public ItemStack getContainerItem() { return new ItemStack(Items.GLASS_BOTTLE); }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced){
            tooltip.add(Component.translatable(LunaUtils.MOD_ID + ".tooltip.chromatictea", new Object[0]).withStyle(ChatFormatting.DARK_AQUA));
    }
}
