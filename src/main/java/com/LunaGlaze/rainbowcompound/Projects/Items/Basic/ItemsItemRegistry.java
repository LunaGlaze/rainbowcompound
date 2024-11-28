package com.LunaGlaze.rainbowcompound.Projects.Items.Basic;

import com.LunaGlaze.rainbowcompound.Core.Registries.BaseRegistry;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ItemsItemRegistry extends BaseRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LunaUtils.MOD_ID);
    public static final RegistryObject<Item> netherstaringot = ITEMS.register("netherstar_ingot",NetherstarIngot::new);
    public static final RegistryObject<Item> rainbowcompound = ITEMS.register("rainbow_compound",RainbowCompound::new);
    public static final RegistryObject<Item> strangecoloredingot = ITEMS.register("strange_colored_ingot",LowGradeMaterial::new);
    public static final RegistryObject<Item> blazeiteingot = ITEMS.register("blazeite_ingot",LowGradeMaterial::new);
    public static final RegistryObject<Item> chorusiteingot = ITEMS.register("chorusite_ingot",LowGradeMaterial::new);
    public static final RegistryObject<Item> enderiteingot = ITEMS.register("enderite_ingot",LowGradeMaterial::new);
    public static final RegistryObject<Item> frostiteingot = ITEMS.register("frostite_ingot",LowGradeMaterial::new);
    public static final RegistryObject<Item> glowstoneiteingot = ITEMS.register("glowstoneite_ingot",LowGradeMaterial::new);
    public static final RegistryObject<Item> slimeiteingot = ITEMS.register("slimeite_ingot",LowGradeMaterial::new);
    public static final RegistryObject<Item> netherwartiteingot = ITEMS.register("netherwartite_ingot",LowGradeMaterial::new);
    public static final RegistryObject<Item> warpediteingot = ITEMS.register("warpedite_ingot",LowGradeMaterial::new);
    public static final RegistryObject<Item> obsidianiteingot = ITEMS.register("obsidianite_ingot",NRFireResistantMaterial::new);
    public static final RegistryObject<Item> obsidianitestick = ITEMS.register("obsidianite_stick",NRFireResistantMaterial::new);
    public static final RegistryObject<Item> hauntedmembrane = ITEMS.register("haunted_membrane",LowGradeMaterial::new);
    public static final RegistryObject<Item> lapissheet = ITEMS.register("lapis_sheet",LowGradeMaterial::new);
    public static final RegistryObject<Item> integratedcircuit = ITEMS.register("integrated_circuit",LowGradeMaterial::new);
    public static final RegistryObject<Item> enderquartz = ITEMS.register("ender_quartz",LowGradeMaterial::new);
    public static final RegistryObject<Item> polishedenderquartz = ITEMS.register("polished_ender_quartz",LowGradeMaterial::new);
    public static final RegistryObject<Item> shadowsteelsheet = ITEMS.register("shadow_steel_sheet", ShadowSteelItems::new);
    public static final RegistryObject<Item> refinedradiancesheet = ITEMS.register("refined_radiance_sheet", RefinedRadianceItems::new);
    public static final RegistryObject<Item> shadowmechanism = ITEMS.register("shadow_mechanism", ShadowSteelItems::new);
    public static final RegistryObject<Item> radiancemechanism = ITEMS.register("radiance_mechanism", RefinedRadianceItems::new);
    public static final RegistryObject<Item> shadowresonantassembly = ITEMS.register("shadow_resonant_assembly", ShadowSteelItems::new);
    public static final RegistryObject<Item> radianceresonantassembly = ITEMS.register("radiance_resonant_assembly", RefinedRadianceItems::new);
    public static final RegistryObject<Item> obsidianiteupgradekit = ITEMS.register("obsidianite_upgrade_kit",NRFireResistantMaterial::new);
    public static final RegistryObject<Item> rainbowupgradekit = ITEMS.register("rainbow_upgrade_kit",RainbowCompound::new);
}