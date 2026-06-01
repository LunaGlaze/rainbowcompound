package com.LunaGlaze.rainbowcompound.Linkage.kaleidoscopecookery;

import com.LunaGlaze.rainbowcompound.Linkage.farmersdelight.*;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class KCItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LunaUtils.MOD_ID);

    public static final RegistryObject<Item> refinedRadianceKitchenKnife = ITEMS.register("refined_radiance_kitchen_knife", RefinedRadianceKitchenKnife::new);
    public static final RegistryObject<Item> shadowSteelKitchenKnife = ITEMS.register("shadow_steel_kitchen_knife", ShadowSteelKitchenKnife::new);
    public static final RegistryObject<Item> obsidianiteKitchenKnife = ITEMS.register("obsidianite_kitchen_knife", ObsidianiteKitchenKnife::new);
    public static final RegistryObject<Item> rainbowKitchenKnife = ITEMS.register("rainbow_kitchen_knife", RainbowKitchenKnife::new);
}
