package com.LunaGlaze.rainbowcompound.Projects.Items.Tools;

import com.LunaGlaze.rainbowcompound.Core.Tiers.ToolTiers;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class ShadowSteelMattock extends HoeItem {

    public ShadowSteelMattock() {
        super(ToolTiers.Shadowsteeltool, new Properties().rarity(Rarity.UNCOMMON).attributes(createAttributes(ToolTiers.Shadowsteeltool, 1, -3f)));
    }

    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        BlockState shovelModifiedState = blockstate.getToolModifiedState(context, ItemAbilities.SHOVEL_FLATTEN, false);
        Player player = context.getPlayer();
        ItemStack itemstack = context.getItemInHand();
        // 斧
        if (player != null && context.getHand().equals(InteractionHand.MAIN_HAND) && player.getOffhandItem().is(Items.SHIELD) && !player.isSecondaryUseActive()) {
            return InteractionResult.PASS;
        } else {
            Optional<BlockState> optional = Optional.ofNullable(blockstate.getToolModifiedState(context, ItemAbilities.AXE_STRIP, false));
            if (optional.isPresent()) {
                level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
                }
                if (!level.isClientSide()) {
                    level.setBlock(blockpos, optional.get(), 11);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional.get()));
                }
            } else {
                Optional<BlockState> optional1 = Optional.ofNullable(blockstate.getToolModifiedState(context, ItemAbilities.AXE_SCRAPE, false));
                if (optional1.isPresent()) {
                    level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    if (player instanceof ServerPlayer) {
                        CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
                    }
                    if (!level.isClientSide()) {
                        level.levelEvent(player, 3005, blockpos, 0);
                        level.setBlock(blockpos, optional1.get(), 11);
                        level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional1.get()));
                    }
                } else {
                    Optional<BlockState> optional2 = Optional.ofNullable(blockstate.getToolModifiedState(context, ItemAbilities.AXE_WAX_OFF, false));
                    if (optional2.isPresent()) {
                        level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                        if (player instanceof ServerPlayer) {
                            CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
                        }
                        if (!level.isClientSide()) {
                            level.levelEvent(player, 3004, blockpos, 0);
                            level.setBlock(blockpos, optional2.get(), 11);
                            level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional2.get()));
                        }
                    } else { // 锄
                        Optional<BlockState> optional3 = Optional.ofNullable(blockstate.getToolModifiedState(context, ItemAbilities.HOE_TILL, false));
                        if (optional3.isPresent()) {
                            level.playSound(player, blockpos , SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                            if (!level.isClientSide()) {
                                level.setBlock(blockpos, optional3.get(), 11);
                                level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional3.get()));
                            }
                        } else { // 铲
                            Optional<BlockState> optional4 = Optional.ofNullable(blockstate.getToolModifiedState(context, ItemAbilities.SHOVEL_DOUSE, false));
                            if (optional4.isPresent() && level.getBlockState(blockpos.above()).isAir()) {
                                level.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                                if (!level.isClientSide()) {
                                    level.setBlock(blockpos, optional4.get(), 11);
                                    level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional4.get()));
                                }
                            } else {
                                Optional<BlockState> optional5 =Optional.ofNullable(blockstate.getToolModifiedState(context, ItemAbilities.SHOVEL_DOUSE, false));
                                if (optional5.isPresent() && !level.isClientSide()) {
                                    level.levelEvent(null, 1009, blockpos, 0);
                                    level.setBlock(blockpos, optional5.get(), 11);
                                    level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional5.get()));
                                } else {
                                    return InteractionResult.PASS;
                                }
                            }
                        }
                    }
                }
            }
            if (player != null) {
                context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }
    }

    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        if(pState.is(BlockTags.MINEABLE_WITH_HOE) || pState.is(BlockTags.MINEABLE_WITH_AXE) || pState.is(BlockTags.MINEABLE_WITH_SHOVEL)){
            return super.getDestroySpeed(pStack, pState);
        } else { return 1.0F; }
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_HOE_ACTIONS.contains(itemAbility) ||
                ItemAbilities.DEFAULT_AXE_ACTIONS.contains(itemAbility) ||
                ItemAbilities.DEFAULT_SHOVEL_ACTIONS.contains(itemAbility);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced){
        tooltip.add(Component.translatable(LunaUtils.MOD_ID + ".tooltip.shadowstelltoll", new Object[0]).withStyle(ChatFormatting.DARK_PURPLE));
    }

    public boolean hurtEnemy(ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        pStack.hurtAndBreak(2, (ServerLevel) pAttacker.level(), pAttacker, (i) -> {
            pAttacker.onEquippedItemBroken(i, EquipmentSlot.MAINHAND);
        });
        Level level = pAttacker.level();
        if (pAttacker instanceof Player){
            ExperienceOrb expOrb = new ExperienceOrb(level,pAttacker.getX(),pAttacker.getY(),pAttacker.getZ(),1);
            level.addFreshEntity(expOrb);
        }
        return true;
    }

    public boolean mineBlock(@NotNull ItemStack pStack, Level pLevel, @NotNull BlockState pState, @NotNull BlockPos pPos, @NotNull LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide && pState.getDestroySpeed(pLevel, pPos) != 0.0F) {
            pStack.hurtAndBreak(1, (ServerLevel) pEntityLiving.level(), pEntityLiving, (i) -> {
                pEntityLiving.onEquippedItemBroken(i, EquipmentSlot.MAINHAND);
            });
        }
        if (pEntityLiving instanceof Player){
            ExperienceOrb expOrb = new ExperienceOrb(pLevel,pEntityLiving.getX(),pEntityLiving.getY(),pEntityLiving.getZ(),1);
            pLevel.addFreshEntity(expOrb);
        }
        return true;
    }
}
