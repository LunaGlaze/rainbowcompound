package com.LunaGlaze.rainbowcompound.Projects.Items.Tools;

import com.LunaGlaze.rainbowcompound.Core.Registries.BaseRegistry;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ToolsItemRegistry extends BaseRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LunaUtils.MOD_ID);
    public static final RegistryObject<Item> obsidianitebow = ITEMS.register("obsidianite_bow",ObsidianiteBow::new);
    public static final RegistryObject<Item> obsidianitesword = ITEMS.register("obsidianite_sword",ObsidianiteSword::new);
    public static final RegistryObject<Item> obsidianitepickaxe = ITEMS.register("obsidianite_pickaxe",ObsidianitePickaxe::new);
    public static final RegistryObject<Item> obsidianiteaxe = ITEMS.register("obsidianite_axe",ObsidianiteAxe::new);
    public static final RegistryObject<Item> obsidianiteshovel = ITEMS.register("obsidianite_shovel",ObsidianiteShovel::new);
    public static final RegistryObject<Item> obsidianitehoe = ITEMS.register("obsidianite_hoe",ObsidianiteHoe::new);
    public static final RegistryObject<Item> rainbowsword = ITEMS.register("rainbow_sword", RainbowSword::new);
    public static final RegistryObject<Item> rainbowpickaxe = ITEMS.register("rainbow_pickaxe", RainbowPickaxe::new);
    public static final RegistryObject<Item> rainbowaxe = ITEMS.register("rainbow_axe", RainbowAxe::new);
    public static final RegistryObject<Item> rainbowshovel = ITEMS.register("rainbow_shovel", RainbowShovel::new);
    public static final RegistryObject<Item> rainbowhoe = ITEMS.register("rainbow_hoe", RainbowHoe::new);
    public static final RegistryObject<Item> shadowsteelsword = ITEMS.register("shadow_steel_sword",ShadowSteelSword::new);
    public static final RegistryObject<Item> shadowsteelpickaxe = ITEMS.register("shadow_steel_pickaxe",ShadowSteelPickaxe::new);
    public static final RegistryObject<Item> shadowsteelaxe = ITEMS.register("shadow_steel_axe",ShadowSteelAxe::new);
    public static final RegistryObject<Item> shadowsteelshovel = ITEMS.register("shadow_steel_shovel",ShadowSteelShovel::new);
    public static final RegistryObject<Item> shadowsteelmattock = ITEMS.register("shadow_steel_mattock",ShadowSteelMattock::new);
    public static final RegistryObject<Item> refinedradiancescythes = ITEMS.register("refined_radiance_scythes",RefinedRadianceScythes::new);


}