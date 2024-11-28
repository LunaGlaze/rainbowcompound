package com.LunaGlaze.rainbowcompound.Linkage.farmersdelight;

import com.LunaGlaze.rainbowcompound.Core.Tiers.ToolTiers;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vectorwing.farmersdelight.common.item.KnifeItem;

import javax.annotation.Nullable;
import java.util.List;


public class RefinedRadianceKnife extends KnifeItem {
    public RefinedRadianceKnife() {
        super(ToolTiers.RefinedRadiance,0.5f,-2f,new Properties().rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced){
        tooltip.add(Component.translatable(LunaUtils.MOD_ID + ".tooltip.refinedradiancetool", new Object[0]).withStyle(ChatFormatting.AQUA));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, (user) -> {
            user.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,4*20,0));
        return true;
    }
}
