package com.LunaGlaze.rainbowcompound.Projects.Blocks;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlocksItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, LunaUtils.MOD_ID);
    public static final DeferredHolder<Item, Item> refinedradianceneonitem = ITEMS.register("refined_radiance_neon",() ->
            new BlockItem(BlocksBlockRegistry.refinedradianceneon.get(),new Item.Properties()));
}
