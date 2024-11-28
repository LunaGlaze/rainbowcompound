package com.LunaGlaze.rainbowcompound.Core.Class;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeMod;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static net.minecraftforge.common.ToolActions.AXE_SCRAPE;

public class ScythesItem extends SwordItem {

    private static final UUID GIANT_REACH_MODIFIER = UUID.fromString("8f10172d-392f-4bf4-81bd-9594286a6987");
    private static final UUID GIANT_RANGE_MODIFIER = UUID.fromString("8f10143d-de69-49d7-b745-42beff107ec4");
    protected final float speed;

    public ScythesItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        this.speed = pTier.getSpeed();
    }

    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        if(pState.is(BlockTags.MINEABLE_WITH_HOE)){
            return this.speed;
        } else if (pState.is(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            List<TagKey<Block>> pBlockTags = pState.getTags().toList();
            return !pBlockTags.contains(BlockTags.REPLACEABLE_BY_TREES) && !pBlockTags.contains(BlockTags.FLOWERS) && !pState.is(BlockTags.LEAVES) && !pBlockTags.contains(BlockTags.CROPS) ? 1.0F : 1.5F;
        }
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        if (net.minecraftforge.common.ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction)|
                net.minecraftforge.common.ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction)| toolAction == AXE_SCRAPE ){
            return true;
        }else {
            return false;
        }
    }

    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (pState.getDestroySpeed(pLevel, pPos) != 0.0F) {
            pStack.hurtAndBreak(1, pEntityLiving, (p_43276_) -> {
                p_43276_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> attributeBuilder = ImmutableMultimap.builder();
        attributeBuilder.putAll(super.getDefaultAttributeModifiers(slot));
        attributeBuilder.put(ForgeMod.BLOCK_REACH.get(), new AttributeModifier(GIANT_REACH_MODIFIER, "Reach modifier", 1, AttributeModifier.Operation.ADDITION));
        attributeBuilder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(GIANT_RANGE_MODIFIER, "Range modifier", 1, AttributeModifier.Operation.ADDITION));
        return slot == EquipmentSlot.MAINHAND ? attributeBuilder.build() : super.getDefaultAttributeModifiers(slot);
    }
    
}
