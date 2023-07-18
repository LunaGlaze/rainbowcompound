package com.LunaGlaze.rainbowcompound.Projects.Items.Tools;

import com.LunaGlaze.rainbowcompound.Core.Group.CreativeModeTabGroup;
import com.LunaGlaze.rainbowcompound.Core.Tiers.ToolTiers;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolActions;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class ShadowSteelMattock extends HoeItem {

    public ShadowSteelMattock() {
        super(ToolTiers.Shadowsteeltool, 1, -3f, new Properties().tab(CreativeModeTabGroup.group).rarity(Rarity.UNCOMMON));
    }

    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState toolModifiedState = level.getBlockState(blockpos).getToolModifiedState(pContext, ToolActions.HOE_TILL, false);
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of((ctx) -> {
            return true;
        }, changeIntoState(toolModifiedState));
        Player player = pContext.getPlayer();
        BlockState blockstate = level.getBlockState(blockpos);
        Optional<BlockState> optional = Optional.ofNullable(blockstate.getToolModifiedState(pContext, ToolActions.AXE_STRIP, false));
        Optional<BlockState> optional1 = optional.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(pContext, ToolActions.AXE_SCRAPE, false));
        Optional<BlockState> optional2 = !optional.isPresent() && !optional1.isPresent() ? Optional.ofNullable(blockstate.getToolModifiedState(pContext, ToolActions.AXE_WAX_OFF, false)) : Optional.empty();
        ItemStack itemstack = pContext.getItemInHand();
        Optional<BlockState> optional3 = Optional.empty();
        if (pair == null) {
            if (optional.isPresent()) {
                level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                optional3 = optional;
            } else if (optional1.isPresent()) {
                level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3005, blockpos, 0);
                optional3 = optional1;
            } else if (optional2.isPresent()) {
                level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3004, blockpos, 0);
                optional3 = optional2;
            }

            if (optional3.isPresent()) {
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
                }

                level.setBlock(blockpos, (BlockState)optional3.get(), 11);
                level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, (BlockState)optional3.get()));
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, (p_150686_) -> {
                        p_150686_.broadcastBreakEvent(pContext.getHand());
                    });
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        } else {
            Predicate<UseOnContext> predicate = (Predicate)pair.getFirst();
            Consumer<UseOnContext> consumer = (Consumer)pair.getSecond();
            if (predicate.test(pContext)) {
                level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!level.isClientSide) {
                    consumer.accept(pContext);
                    if (player != null) {
                        pContext.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> {
                            p_150845_.broadcastBreakEvent(pContext.getHand());
                        });
                    }
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                if (optional.isPresent()) {
                    level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                    optional3 = optional;
                } else if (optional1.isPresent()) {
                    level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.levelEvent(player, 3005, blockpos, 0);
                    optional3 = optional1;
                } else if (optional2.isPresent()) {
                    level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.levelEvent(player, 3004, blockpos, 0);
                    optional3 = optional2;
                }

                if (optional3.isPresent()) {
                    if (player instanceof ServerPlayer) {
                        CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
                    }

                    level.setBlock(blockpos, (BlockState)optional3.get(), 11);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, (BlockState)optional3.get()));
                    if (player != null) {
                        itemstack.hurtAndBreak(1, player, (p_150686_) -> {
                            p_150686_.broadcastBreakEvent(pContext.getHand());
                        });
                    }

                    return InteractionResult.sidedSuccess(level.isClientSide);
                } else {
                    return InteractionResult.PASS;
                }
            }
        }
    }


    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        if(pState.is(BlockTags.MINEABLE_WITH_HOE)){
            return this.speed;
        } else if (pState.is(BlockTags.MINEABLE_WITH_AXE)) {
            return this.speed;
        } else if (pState.is(BlockTags.MINEABLE_WITH_SHOVEL)) {
            return this.speed;
        }else {return 1.0F;}
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        if(net.minecraftforge.common.ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction) |
                net.minecraftforge.common.ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction)|
                net.minecraftforge.common.ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction)){
            return true;
        }else {
            return false;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced){
        tooltip.add(Component.translatable(LunaUtils.MOD_ID + ".tooltip.shadowstelltoll").withStyle(ChatFormatting.DARK_PURPLE));
    }

    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(2, pAttacker, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        Level level = pAttacker.getLevel();
        if (pAttacker instanceof Player){
            ExperienceOrb exporb = new ExperienceOrb(level,pAttacker.getX(),pAttacker.getY(),pAttacker.getZ(),1);
            level.addFreshEntity(exporb);
        }
        return true;
    }

    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide && pState.getDestroySpeed(pLevel, pPos) != 0.0F) {
            pStack.hurtAndBreak(1, pEntityLiving, (p_40992_) -> {
                p_40992_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }
        if (pEntityLiving instanceof Player){
            ExperienceOrb exporb = new ExperienceOrb(pLevel,pEntityLiving.getX(),pEntityLiving.getY(),pEntityLiving.getZ(),1);
            pLevel.addFreshEntity(exporb);
        }
        return true;
    }
}
