package com.LunaGlaze.rainbowcompound.Core.Group;

import com.LunaGlaze.rainbowcompound.Projects.Items.Basic.ItemsItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class RainbowCompoundGroup extends CreativeModeTab {
    public RainbowCompoundGroup() {
        super("rainbowcompound_group");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemsItemRegistry.rainbowcompound.get());
    }
}
