package com.LunaGlaze.rainbowcompound.Projects.Items.Armors;

import com.LunaGlaze.rainbowcompound.Linkage.elytraslot.CuriosDynamicElytra;
import com.LunaGlaze.rainbowcompound.Linkage.elytraslot.CuriosObsidianiteElytra;
import com.LunaGlaze.rainbowcompound.Linkage.elytraslot.CuriosRainbowElytra;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CuriosElytraItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LunaUtils.MOD_ID);
    public static final DeferredItem<CuriosObsidianiteElytra> obsidianite_elytra = ITEMS.register("obsidianite_elytra", CuriosObsidianiteElytra::new);
    public static final DeferredItem<CuriosDynamicElytra> dynamicelytra_radiance = ITEMS.register("dynamic_elytra_radiance", CuriosDynamicElytra::new);
    public static final DeferredItem<CuriosDynamicElytra> dynamicelytra_feather = ITEMS.register("dynamic_elytra_feather", CuriosDynamicElytra::new);
    public static final DeferredItem<CuriosDynamicElytra> dynamicelytra_fire = ITEMS.register("dynamic_elytra_fire", CuriosDynamicElytra::new);
    public static final DeferredItem<CuriosDynamicElytra> dynamicelytra_ice = ITEMS.register("dynamic_elytra_ice",CuriosDynamicElytra::new);
    public static final DeferredItem<CuriosDynamicElytra> dynamicelytra_66ccff = ITEMS.register("dynamic_elytra_66ccff",CuriosDynamicElytra::new);
    public static final DeferredItem<CuriosDynamicElytra> dynamicelytra_ender = ITEMS.register("dynamic_elytra_ender",CuriosDynamicElytra::new);
    public static final DeferredItem<CuriosDynamicElytra> dynamicelytra_slime = ITEMS.register("dynamic_elytra_slime",CuriosDynamicElytra::new);
    public static final DeferredItem<CuriosRainbowElytra> dynamicelytra_rainbow = ITEMS.register("dynamic_elytra_rainbow", CuriosRainbowElytra::new);
    public static final DeferredItem<CuriosRainbowElytra> dynamicelytra_flandre = ITEMS.register("dynamic_elytra_flandre", CuriosRainbowElytra::new);
}
