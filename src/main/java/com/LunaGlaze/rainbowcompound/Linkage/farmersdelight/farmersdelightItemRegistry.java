package com.LunaGlaze.rainbowcompound.Linkage.farmersdelight;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class farmersdelightItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LunaUtils.MOD_ID);
    public static final RegistryObject<Item> shadowsteelknife = ITEMS.register("shadow_steel_knife",ShadowSteelKnife::new);
    public static final RegistryObject<Item> refinedradianceknife = ITEMS.register("refined_radiance_knife",RefinedRadianceKnife::new);
    public static final RegistryObject<Item> obsidianiteknife = ITEMS.register("obsidianite_knife",ObsidianiteKnife::new);
    public static final RegistryObject<Item> rainbowknife = ITEMS.register("rainbow_knife",RainbowKnife::new);
    public static final RegistryObject<Item> goldenapplestew = ITEMS.register("golden_apple_stew",GoldenAppleStew::new);
    public static final RegistryObject<Item> rainbowapplestew = ITEMS.register("rainbow_apple_stew",RainbowAppleStew::new);
    public static final RegistryObject<Item> enchantedgoldenapplestew = ITEMS.register("enchanted_golden_apple_stew",EnchantedGoldenAppleStew::new);
    public static final RegistryObject<Item> shadowsteeltea = ITEMS.register("shadow_steel_tea",ShadowSteelTea::new);
    public static final RegistryObject<Item> refinedradiancetea = ITEMS.register("refined_radiance_tea",RefinedRadianceTea::new);

}
