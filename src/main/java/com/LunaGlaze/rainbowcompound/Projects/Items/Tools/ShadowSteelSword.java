package com.LunaGlaze.rainbowcompound.Projects.Items.Tools;

import com.LunaGlaze.rainbowcompound.Core.Tiers.ToolTiers;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ShadowSteelSword extends SwordItem {
    public ShadowSteelSword() {
        super(ToolTiers.Shadowsteel, new Properties().rarity(Rarity.UNCOMMON).attributes(createAttributes(ToolTiers.Shadowsteel, 3, -2f)));
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced){
        tooltip.add(Component.translatable(LunaUtils.MOD_ID + ".tooltip.shadowstelltoll", new Object[0]).withStyle(ChatFormatting.DARK_PURPLE));
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        ServerLevel serverlevel = (ServerLevel) pAttacker.level();
        pStack.hurtAndBreak(2, (ServerLevel) pAttacker.level(), pAttacker, (i) -> {
            pAttacker.onEquippedItemBroken(i, EquipmentSlot.MAINHAND);
        });
        if (pAttacker instanceof Player) {
            ExperienceOrb exporb = new ExperienceOrb(serverlevel,pAttacker.getX(),pAttacker.getY(),pAttacker.getZ(),1);
            serverlevel.addFreshEntity(exporb);
        }
        return true;
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (pState.getDestroySpeed(pLevel, pPos) != 0.0F) {
            pStack.hurtAndBreak(1, (ServerLevel) pEntityLiving.level(), pEntityLiving, (i) -> {
                pEntityLiving.onEquippedItemBroken(i, EquipmentSlot.MAINHAND);
            });
        }
        if (pEntityLiving instanceof Player) {
            ExperienceOrb exporb = new ExperienceOrb(pLevel,pEntityLiving.getX(),pEntityLiving.getY(),pEntityLiving.getZ(),1);
            pLevel.addFreshEntity(exporb);
        }
        return true;
    }
}
