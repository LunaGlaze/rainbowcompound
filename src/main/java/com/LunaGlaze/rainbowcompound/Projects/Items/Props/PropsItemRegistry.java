package com.LunaGlaze.rainbowcompound.Projects.Items.Props;

import com.LunaGlaze.rainbowcompound.Core.Registries.BaseRegistry;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import com.LunaGlaze.rainbowcompound.RainbowCompound;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PropsItemRegistry extends BaseRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, LunaUtils.MOD_ID);

    public static final DeferredHolder<Item, Item> homemagicmirror = ITEMS.register("home_magic_mirror",HomeMagicMirror::new);
    public static final DeferredHolder<Item, Item> shadowring = ITEMS.register("shadow_ring", ShadowRing::new);
    public static final DeferredHolder<Item, Item> radiancering = ITEMS.register("radiance_ring", RadianceRing::new);

}
