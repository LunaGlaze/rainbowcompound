package com.LunaGlaze.rainbowcompound.Projects.Items.Foods;

import com.LunaGlaze.rainbowcompound.Core.Registries.BaseRegistry;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FoodsItemRegistry extends BaseRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, LunaUtils.MOD_ID);
    public static final DeferredHolder<Item, Item> rainbowapple = ITEMS.register("rainbow_apple",RainbowApple::new);
    public static final DeferredHolder<Item, Item> honeyedporkchop = ITEMS.register("honeyed_porkchop",HoneyedPorkchop::new);

}
