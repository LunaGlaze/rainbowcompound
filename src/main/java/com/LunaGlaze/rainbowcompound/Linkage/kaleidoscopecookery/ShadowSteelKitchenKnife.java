package com.LunaGlaze.rainbowcompound.Linkage.kaleidoscopecookery;

import com.LunaGlaze.rainbowcompound.Core.Tiers.ToolTiers;
import com.github.ysbbbbbb.kaleidoscopecookery.item.KitchenKnifeItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ShadowSteelKitchenKnife extends KitchenKnifeItem {
    public ShadowSteelKitchenKnife() {
        super(ToolTiers.Shadowsteeltool, new Properties().rarity(Rarity.UNCOMMON).attributes(createAttributes(ToolTiers.Shadowsteeltool, 0.5f, -1.75f)));
    }

    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(2, (ServerLevel) pAttacker.level(), pAttacker, (i) -> {
            pAttacker.onEquippedItemBroken(i, EquipmentSlot.MAINHAND);
        });
        Level level = pAttacker.level();
        if (pAttacker instanceof Player){
            ExperienceOrb exporb = new ExperienceOrb(level,pAttacker.getX(),pAttacker.getY(),pAttacker.getZ(),1);
            level.addFreshEntity(exporb);
        }
        return true;
    }

    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide && pState.getDestroySpeed(pLevel, pPos) != 0.0F) {
            pStack.hurtAndBreak(1, (ServerLevel) pEntityLiving.level(), pEntityLiving, (i) -> {
                pEntityLiving.onEquippedItemBroken(i, EquipmentSlot.MAINHAND);
            });
        }
        if (pEntityLiving instanceof Player){
            ExperienceOrb exporb = new ExperienceOrb(pLevel,pEntityLiving.getX(),pEntityLiving.getY(),pEntityLiving.getZ(),1);
            pLevel.addFreshEntity(exporb);
        }
        return true;
    }
}
