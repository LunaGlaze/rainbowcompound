package com.LunaGlaze.rainbowcompound.Projects.Items.Basic;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class NetherstarIngot extends Item {
    public NetherstarIngot() {
        super(new Properties().fireResistant().rarity(Rarity.UNCOMMON));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}