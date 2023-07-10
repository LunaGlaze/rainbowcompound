package com.LunaGlaze.rainbowcompound.Projects.Items.Basic;

import com.LunaGlaze.rainbowcompound.Core.Group.CreativeModeTabGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class RainbowCompound extends Item {
    public RainbowCompound() {
        super(new Properties().tab(CreativeModeTabGroup.group).fireResistant().rarity(Rarity.UNCOMMON));
    }
}