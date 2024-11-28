package com.LunaGlaze.rainbowcompound.Projects.Items.Tools;

import com.LunaGlaze.rainbowcompound.Core.Tiers.ToolTiers;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;

public class RainbowPickaxe extends PickaxeItem {
    public RainbowPickaxe() {
        super(ToolTiers.RAINBOW, 1, -3f,new Properties().fireResistant().rarity(Rarity.UNCOMMON));
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(2, pAttacker, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        pTarget.addEffect(new MobEffectInstance(MobEffects.GLOWING,7*20,0));
        return true;
    }
}
