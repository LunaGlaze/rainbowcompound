package com.LunaGlaze.rainbowcompound.Projects.Items.Tools;

import com.LunaGlaze.rainbowcompound.Core.Tiers.ToolTiers;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ShadowSteelSword extends SwordItem {
    public ShadowSteelSword() {
        super(ToolTiers.Shadowsteel,3,-2f,new Properties().rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced){
        tooltip.add(Component.translatable(LunaUtils.MOD_ID + ".tooltip.shadowstelltoll", new Object[0]).withStyle(ChatFormatting.DARK_PURPLE));
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, (p_43296_) -> {
            p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        Level level = pAttacker.level();
        if (pAttacker instanceof Player){
            ExperienceOrb exporb = new ExperienceOrb(level,pAttacker.getX(),pAttacker.getY(),pAttacker.getZ(),1);
            level.addFreshEntity(exporb);
        }
        return true;
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (pState.getDestroySpeed(pLevel, pPos) != 0.0F) {
            pStack.hurtAndBreak(1, pEntityLiving, (p_43276_) -> {
                p_43276_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }
        if (pEntityLiving instanceof Player){
            ExperienceOrb exporb = new ExperienceOrb(pLevel,pEntityLiving.getX(),pEntityLiving.getY(),pEntityLiving.getZ(),1);
            pLevel.addFreshEntity(exporb);
        }
        return true;
    }
}
