package com.LunaGlaze.rainbowcompound.Projects.Items.Basic;

import com.LunaGlaze.rainbowcompound.Core.Group.CreativeModeTabGroup;
import net.minecraft.world.item.Item;

public class NRFireResistantMaterial extends Item {
    public NRFireResistantMaterial() {
        super(new Properties().tab(CreativeModeTabGroup.group).fireResistant());
    }
}
