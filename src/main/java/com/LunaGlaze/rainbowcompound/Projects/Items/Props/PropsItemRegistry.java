package com.LunaGlaze.rainbowcompound.Projects.Items.Props;

import com.LunaGlaze.rainbowcompound.Core.Registries.BaseRegistry;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PropsItemRegistry extends BaseRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LunaUtils.MOD_ID);

    public static final RegistryObject<Item> homemagicmirror = ITEMS.register("home_magic_mirror",HomeMagicMirror::new);
    public static final RegistryObject<Item> shadowring = ITEMS.register("shadow_ring", ShadowRing::new);
    public static final RegistryObject<Item> radiancering = ITEMS.register("radiance_ring", RadianceRing::new);

}
