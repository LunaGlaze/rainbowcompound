package com.LunaGlaze.rainbowcompound.Projects.Items.Basic;

import com.LunaGlaze.rainbowcompound.Core.Registries.BaseRegistry;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemsItemRegistry extends BaseRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, LunaUtils.MOD_ID);

    public static final DeferredHolder<Item, Item> netherstaringot = ITEMS.register("netherstar_ingot",NetherstarIngot::new);
    public static final DeferredHolder<Item, Item> rainbowcompound = ITEMS.register("rainbow_compound",RainbowCompound::new);
    public static final DeferredHolder<Item, Item> strangecoloredingot = ITEMS.register("strange_colored_ingot",LowGradeMaterial::new);
    public static final DeferredHolder<Item, Item> blazeiteingot = ITEMS.register("blazeite_ingot",LowGradeMaterial::new);
    public static final DeferredHolder<Item, Item> chorusiteingot = ITEMS.register("chorusite_ingot",LowGradeMaterial::new);
    public static final DeferredHolder<Item, Item> enderiteingot = ITEMS.register("enderite_ingot",LowGradeMaterial::new);
    public static final DeferredHolder<Item, Item> frostiteingot = ITEMS.register("frostite_ingot",LowGradeMaterial::new);
    public static final DeferredHolder<Item, Item> glowstoneiteingot = ITEMS.register("glowstoneite_ingot",LowGradeMaterial::new);
    public static final DeferredHolder<Item, Item> slimeiteingot = ITEMS.register("slimeite_ingot",LowGradeMaterial::new);
    public static final DeferredHolder<Item, Item> netherwartiteingot = ITEMS.register("netherwartite_ingot",LowGradeMaterial::new);
    public static final DeferredHolder<Item, Item> warpediteingot = ITEMS.register("warpedite_ingot",LowGradeMaterial::new);
    public static final DeferredHolder<Item, Item> obsidianiteingot = ITEMS.register("obsidianite_ingot",NRFireResistantMaterial::new);
    public static final DeferredHolder<Item, Item> obsidianitestick = ITEMS.register("obsidianite_stick",NRFireResistantMaterial::new);
    public static final DeferredHolder<Item, Item> zincrod = ITEMS.register("zinc_rod",LowGradeMaterial::new);
    public static final DeferredHolder<Item, Item> hauntedmembrane = ITEMS.register("haunted_membrane",LowGradeMaterial::new);
    public static final DeferredHolder<Item, Item> lapissheet = ITEMS.register("lapis_sheet",LowGradeMaterial::new);
    public static final DeferredHolder<Item, Item> integratedcircuit = ITEMS.register("integrated_circuit",LowGradeMaterial::new);
    public static final DeferredHolder<Item, Item> enderquartz = ITEMS.register("ender_quartz",LowGradeMaterial::new);
    public static final DeferredHolder<Item, Item> polishedenderquartz = ITEMS.register("polished_ender_quartz",LowGradeMaterial::new);
    public static final DeferredHolder<Item, Item> shadowsteelsheet = ITEMS.register("shadow_steel_sheet", ShadowSteelItems::new);
    public static final DeferredHolder<Item, Item> refinedradiancesheet = ITEMS.register("refined_radiance_sheet", RefinedRadianceItems::new);
    public static final DeferredHolder<Item, Item> shadowmechanism = ITEMS.register("shadow_mechanism", ShadowSteelItems::new);
    public static final DeferredHolder<Item, Item> radiancemechanism = ITEMS.register("radiance_mechanism", RefinedRadianceItems::new);
    public static final DeferredHolder<Item, Item> shadowresonantassembly = ITEMS.register("shadow_resonant_assembly", ShadowSteelItems::new);
    public static final DeferredHolder<Item, Item> radianceresonantassembly = ITEMS.register("radiance_resonant_assembly", RefinedRadianceItems::new);
    public static final DeferredHolder<Item, Item> obsidianiteupgradekit = ITEMS.register("obsidianite_upgrade_kit",NRFireResistantMaterial::new);
    public static final DeferredHolder<Item, Item> rainbowupgradekit = ITEMS.register("rainbow_upgrade_kit",RainbowCompound::new);
}