package com.LunaGlaze.rainbowcompound.Projects.Items.Armors;

import com.LunaGlaze.rainbowcompound.Core.Class.DynamicElytra;
import com.LunaGlaze.rainbowcompound.Core.Class.ObsidianiteElytra;
import com.LunaGlaze.rainbowcompound.Core.Class.RainbowElytra;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ElytraItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LunaUtils.MOD_ID);
    public static final RegistryObject<Item> obsidianiteelytra = ITEMS.register("obsidianite_elytra", ObsidianiteElytra::new);
    public static final RegistryObject<Item> dynamicelytra_radiance = ITEMS.register("dynamic_elytra_radiance",DynamicElytra::new);
    public static final RegistryObject<Item> dynamicelytra_feather = ITEMS.register("dynamic_elytra_feather", DynamicElytra::new);
    public static final RegistryObject<Item> dynamicelytra_fire = ITEMS.register("dynamic_elytra_fire", DynamicElytra::new);
    public static final RegistryObject<Item> dynamicelytra_ice = ITEMS.register("dynamic_elytra_ice",DynamicElytra::new);
    public static final RegistryObject<Item> dynamicelytra_66ccff = ITEMS.register("dynamic_elytra_66ccff",DynamicElytra::new);
    public static final RegistryObject<Item> dynamicelytra_ender = ITEMS.register("dynamic_elytra_ender",DynamicElytra::new);
    public static final RegistryObject<Item> dynamicelytra_slime = ITEMS.register("dynamic_elytra_slime",DynamicElytra::new);
    public static final RegistryObject<Item> dynamicelytra_rainbow = ITEMS.register("dynamic_elytra_rainbow",RainbowElytra::new);
    public static final RegistryObject<Item> dynamicelytra_flandre = ITEMS.register("dynamic_elytra_flandre",RainbowElytra::new);

}
