package com.LunaGlaze.rainbowcompound.Linkage.kaleidoscopecookery;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class KCItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, LunaUtils.MOD_ID);

    public static final DeferredHolder<Item, Item> refinedRadianceKitchenKnife = ITEMS.register("refined_radiance_kitchen_knife", RefinedRadianceKitchenKnife::new);
    public static final DeferredHolder<Item, Item> shadowSteelKitchenKnife = ITEMS.register("shadow_steel_kitchen_knife", ShadowSteelKitchenKnife::new);
    public static final DeferredHolder<Item, Item> obsidianiteKitchenKnife = ITEMS.register("obsidianite_kitchen_knife", ObsidianiteKitchenKnife::new);
    public static final DeferredHolder<Item, Item> rainbowKitchenKnife = ITEMS.register("rainbow_kitchen_knife", RainbowKitchenKnife::new);
}
