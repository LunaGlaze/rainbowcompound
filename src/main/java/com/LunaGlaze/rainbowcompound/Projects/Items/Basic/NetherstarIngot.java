package com.LunaGlaze.rainbowcompound.Projects.Items.Basic;

import com.LunaGlaze.rainbowcompound.Core.Group.CreativeModeTabGroup;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SimpleFoiledItem;

public class NetherstarIngot extends SimpleFoiledItem {
    public NetherstarIngot() {
        super(new Properties().tab(CreativeModeTabGroup.group).fireResistant().rarity(Rarity.UNCOMMON));
    }

}