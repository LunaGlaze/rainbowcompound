package com.LunaGlaze.rainbowcompound.Core.Tiers;

import com.LunaGlaze.rainbowcompound.Projects.Items.Basic.ItemsItemRegistry;
import com.simibubi.create.AllItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public enum ToolTiers implements Tier {
    Obsidianite(TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("incorrect_for_diamond_tool")), 2048, 9.0F, 3.75F, 15, () -> {
        return Ingredient.of(Items.OBSIDIAN);
    }),
    RAINBOW(TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("incorrect_for_netherite_tool")), 3072, 12.0F, 5.0F , 25, () -> {
        return Ingredient.of(ItemsItemRegistry.rainbowcompound.get());
    }),
    Shadowsteel(TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("incorrect_for_diamond_tool")),2303,10.0F,4F,15,() -> {
        return Ingredient.of(AllItems.SHADOW_STEEL.get());
    }),
    Shadowsteeltool(TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("incorrect_for_diamond_tool")),2303,10.0F,3.5F,15,() -> {
        return Ingredient.of(AllItems.SHADOW_STEEL.get());
    }),
    RefinedRadiance(TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("incorrect_for_diamond_tool")),2303,10.0F,3.5F,15,() -> {
        return Ingredient.of(AllItems.REFINED_RADIANCE.get());
    });
    private final TagKey<Block> incorrects;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ToolTiers(TagKey<Block> incorrects,int pUses, float pSpeed, float pDamage, int pEnchantmentValue, Supplier<Ingredient> pRepairIngredient) {
        this.incorrects = incorrects;
        this.uses = pUses;
        this.speed = pSpeed;
        this.damage = pDamage;
        this.enchantmentValue = pEnchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrects;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
