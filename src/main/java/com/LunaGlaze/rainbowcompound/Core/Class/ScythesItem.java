package com.LunaGlaze.rainbowcompound.Core.Class;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;

import java.util.List;

import static net.neoforged.neoforge.common.ItemAbilities.AXE_SCRAPE;

public class ScythesItem extends SwordItem {
    protected final float speed;

    public ScythesItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pProperties.attributes(ScythesItem.createAttributes(pTier, pAttackDamageModifier, pAttackSpeedModifier, 1, 1)));
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
    public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ItemAbility itemAbility) {
        if (ItemAbilities.DEFAULT_HOE_ACTIONS.contains(itemAbility) |
                ItemAbilities.DEFAULT_SWORD_ACTIONS.contains(itemAbility) | itemAbility == AXE_SCRAPE ){
            return true;
        }else {
            return false;
        }
    }

    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (pState.getDestroySpeed(pLevel, pPos) != 0.0F) {
            pStack.hurtAndBreak(1, (ServerLevel) pLevel, pEntityLiving, (i) -> pEntityLiving.onEquippedItemBroken(i ,EquipmentSlot.MAINHAND));
        }

        return true;
    }

    public static ItemAttributeModifiers createAttributes(Tier tier, float attackDamage, float attackSpeed, float blockInteractionRange, float entityInteractionRange) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(
                                BASE_ATTACK_DAMAGE_ID, (double)((float)attackDamage + tier.getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)attackSpeed, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.BLOCK_INTERACTION_RANGE,
                        new AttributeModifier(ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID, "base_block_interaction_range"), (double)blockInteractionRange, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ENTITY_INTERACTION_RANGE,
                        new AttributeModifier(ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID, "base_entity_interaction_range"), (double)entityInteractionRange, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }
}
