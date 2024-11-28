package com.LunaGlaze.rainbowcompound.Projects.Items.Tools;

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
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class ShadowSteelMattock extends HoeItem {

    public ShadowSteelMattock() {
        super(ToolTiers.Shadowsteeltool, 1, -3f, new Properties().rarity(Rarity.UNCOMMON));
    }

    @SuppressWarnings("removal")
    public InteractionResult useOn(UseOnContext pContext) {
        // 24.11.22 也许是要用onToolUse方法，但是那个方法返回值不是int，先注释掉看看
        // 24.11.23 事实证明注释掉了似乎也不影响运行，管它呢，能跑就完事了
        // int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(pContext);
        // if (hook != 0) return hook > 0 ? InteractionResult.SUCCESS : InteractionResult.FAIL;
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        BlockState blockstate = level.getBlockState(blockpos);
        BlockState toolModifiedState = level.getBlockState(blockpos).getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.HOE_TILL, false);
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of(ctx -> true, changeIntoState(toolModifiedState));
        Optional<BlockState> optional = Optional.ofNullable(blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.AXE_STRIP, false));
        Optional<BlockState> optional1 = optional.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.AXE_SCRAPE, false));
        Optional<BlockState> optional2 = optional.isPresent() || optional1.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.AXE_WAX_OFF, false));
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

                level.setBlock(blockpos, optional3.get(), 11);
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, (p_150686_) -> {
                        p_150686_.broadcastBreakEvent(pContext.getHand());
                    });
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                if (pContext.getClickedFace() == Direction.DOWN) {
                    return InteractionResult.PASS;
                } else {
                    BlockState blockstate1 = blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.SHOVEL_FLATTEN, false);
                    BlockState blockstate2 = null;
                    if (blockstate1 != null && level.isEmptyBlock(blockpos.above())) {
                        level.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                        blockstate2 = blockstate1;
                    } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT)) {
                        if (!level.isClientSide()) {
                            level.levelEvent((Player)null, 1009, blockpos, 0);
                        }

                        CampfireBlock.dowse(pContext.getPlayer(), level, blockpos, blockstate);
                        blockstate2 = blockstate.setValue(CampfireBlock.LIT, Boolean.valueOf(false));
                    }

                    if (blockstate2 != null) {
                        if (!level.isClientSide) {
                            level.setBlock(blockpos, blockstate2, 11);
                            if (player != null) {
                                pContext.getItemInHand().hurtAndBreak(1, player, (p_43122_) -> {
                                    p_43122_.broadcastBreakEvent(pContext.getHand());
                                });
                            }
                        }

                        return InteractionResult.sidedSuccess(level.isClientSide);
                    } else {
                        return InteractionResult.PASS;
                    }
                }
            }
        } else {
            Predicate<UseOnContext> predicate = pair.getFirst();
            Consumer<UseOnContext> consumer = pair.getSecond();
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

                    level.setBlock(blockpos, optional3.get(), 11);
                    if (player != null) {
                        itemstack.hurtAndBreak(1, player, (p_150686_) -> {
                            p_150686_.broadcastBreakEvent(pContext.getHand());
                        });
                    }

                    return InteractionResult.sidedSuccess(level.isClientSide);
                } else {
                    if (pContext.getClickedFace() == Direction.DOWN) {
                        return InteractionResult.PASS;
                    } else {
                        BlockState blockstate1 = blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.SHOVEL_FLATTEN, false);
                        BlockState blockstate2 = null;
                        if (blockstate1 != null && level.isEmptyBlock(blockpos.above())) {
                            level.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                            blockstate2 = blockstate1;
                        } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT)) {
                            if (!level.isClientSide()) {
                                level.levelEvent((Player)null, 1009, blockpos, 0);
                            }

                            CampfireBlock.dowse(pContext.getPlayer(), level, blockpos, blockstate);
                            blockstate2 = blockstate.setValue(CampfireBlock.LIT, Boolean.valueOf(false));
                        }

                        if (blockstate2 != null) {
                            if (!level.isClientSide) {
                                level.setBlock(blockpos, blockstate2, 11);
                                if (player != null) {
                                    pContext.getItemInHand().hurtAndBreak(1, player, (p_43122_) -> {
                                        p_43122_.broadcastBreakEvent(pContext.getHand());
                                    });
                                }
                            }

                            return InteractionResult.sidedSuccess(level.isClientSide);
                        } else {
                            return InteractionResult.PASS;
                        }
                    }
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
        tooltip.add(Component.translatable(LunaUtils.MOD_ID + ".tooltip.shadowstelltoll", new Object[0]).withStyle(ChatFormatting.DARK_PURPLE));
    }

    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(2, pAttacker, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
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
