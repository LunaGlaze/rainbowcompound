package com.LunaGlaze.rainbowcompound.Projects.Items.Basic;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class RainbowCompound extends Item {
    public RainbowCompound() {
        super(new Properties().fireResistant().rarity(Rarity.UNCOMMON));
    }
}