package com.LunaGlaze.rainbowcompound.Linkage.farmersdelight;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FarmersDelightItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, LunaUtils.MOD_ID);

    public static final DeferredHolder<Item, Item> obsidianiteknife = ITEMS.register("obsidianite_knife",ObsidianiteKnife::new);
    public static final DeferredHolder<Item, Item> refinedradianceknife = ITEMS.register("refined_radiance_knife",RefinedRadianceKnife::new);
    public static final DeferredHolder<Item, Item> shadowsteelknife = ITEMS.register("shadow_steel_knife",ShadowSteelKnife::new);
    public static final DeferredHolder<Item, Item> rainbowknife = ITEMS.register("rainbow_knife",RainbowKnife::new);
    public static final DeferredHolder<Item, Item> goldenapplestew = ITEMS.register("golden_apple_stew",GoldenAppleStew::new);
    public static final DeferredHolder<Item, Item> enchantedgoldenapplestew = ITEMS.register("enchanted_golden_apple_stew",EnchantedGoldenAppleStew::new);
    public static final DeferredHolder<Item, Item> rainbowapplestew = ITEMS.register("rainbow_apple_stew",RainbowAppleStew::new);
    public static final DeferredHolder<Item, Item> shadowsteeltea = ITEMS.register("shadow_steel_tea",ShadowSteelTea::new);
    public static final DeferredHolder<Item, Item> refinedradiancetea = ITEMS.register("refined_radiance_tea",RefinedRadianceTea::new);

}
