package com.LunaGlaze.rainbowcompound.Core.Tiers;

import com.LunaGlaze.rainbowcompound.Core.Date.LunaConfig;
import com.LunaGlaze.rainbowcompound.Projects.Items.Basic.ItemsItemRegistry;
import com.simibubi.create.AllItems;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ToolTiers implements Tier {
    Obsidianite(3, 2048, 9.0F, 3.75F, 15, () -> {
        return Ingredient.of(Items.OBSIDIAN);
    }),
    RAINBOW(5, 3072, 12.0F, 5.0F + LunaConfig.RAINBOW_TOOL_Damage.get(), 25, () -> {
        return Ingredient.of(ItemsItemRegistry.rainbowcompound.get());
    }),
    Shadowsteel(3,2303,10.0F,3.5F,15,() -> {
        return Ingredient.of(AllItems.SHADOW_STEEL.get());
    }),
    Shadowsteeltool(3,2303,10.0F,3F,15,() -> {
        return Ingredient.of(AllItems.SHADOW_STEEL.get());
    }),
    RefinedRadiance(3,2303,10.0F,3F,15,() -> {
        return Ingredient.of(AllItems.REFINED_RADIANCE.get());
    });
    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ToolTiers(int pLevel, int pUses, float pSpeed, float pDamage, int pEnchantmentValue, Supplier<Ingredient> pRepairIngredient) {
        this.level = pLevel;
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
    public int getLevel() {
        return this.level;
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
