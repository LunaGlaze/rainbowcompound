package com.LunaGlaze.rainbowcompound.Projects.Items.Armors;

import com.LunaGlaze.rainbowcompound.Linkage.elytraslot.CuriosDynamicElytra;
import com.LunaGlaze.rainbowcompound.Linkage.elytraslot.CuriosObsidianiteElytra;
import com.LunaGlaze.rainbowcompound.Linkage.elytraslot.CuriosRainbowElytra;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CuriosElytraItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LunaUtils.MOD_ID);
    public static final RegistryObject<Item> obsidianiteelytra = ITEMS.register("obsidianite_elytra", CuriosObsidianiteElytra::new);
    public static final RegistryObject<Item> dynamicelytra_radiance = ITEMS.register("dynamic_elytra_radiance", CuriosDynamicElytra::new);
    public static final RegistryObject<Item> dynamicelytra_feather = ITEMS.register("dynamic_elytra_feather", CuriosDynamicElytra::new);
    public static final RegistryObject<Item> dynamicelytra_fire = ITEMS.register("dynamic_elytra_fire", CuriosDynamicElytra::new);
    public static final RegistryObject<Item> dynamicelytra_ice = ITEMS.register("dynamic_elytra_ice",CuriosDynamicElytra::new);
    public static final RegistryObject<Item> dynamicelytra_66ccff = ITEMS.register("dynamic_elytra_66ccff",CuriosDynamicElytra::new);
    public static final RegistryObject<Item> dynamicelytra_ender = ITEMS.register("dynamic_elytra_ender",CuriosDynamicElytra::new);
    public static final RegistryObject<Item> dynamicelytra_slime = ITEMS.register("dynamic_elytra_slime",CuriosDynamicElytra::new);
    public static final RegistryObject<Item> dynamicelytra_rainbow = ITEMS.register("dynamic_elytra_rainbow", CuriosRainbowElytra::new);
    public static final RegistryObject<Item> dynamicelytra_flandre = ITEMS.register("dynamic_elytra_flandre", CuriosRainbowElytra::new);
}
