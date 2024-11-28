package com.LunaGlaze.rainbowcompound.Projects.Blocks;

import com.LunaGlaze.rainbowcompound.Core.Tab.RainbowcompoundTab;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlocksItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LunaUtils.MOD_ID);
    public static final RegistryObject<Item> refinedradianceneonitem = ITEMS.register("refined_radiance_neon",() ->
            new BlockItem(BlocksBlockRegistry.refinedradianceneon.get(),new Item.Properties()));
}
