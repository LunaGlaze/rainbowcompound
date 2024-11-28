package com.LunaGlaze.rainbowcompound.Projects.Items.Foods;

import com.LunaGlaze.rainbowcompound.Core.Registries.BaseRegistry;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FoodsItemRegistry extends BaseRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LunaUtils.MOD_ID);
    public static final RegistryObject<Item> rainbowapple = ITEMS.register("rainbow_apple",RainbowApple::new);
    public static final RegistryObject<Item> honeyedporkchop = ITEMS.register("honeyed_porkchop",HoneyedPorkchop::new);

}
