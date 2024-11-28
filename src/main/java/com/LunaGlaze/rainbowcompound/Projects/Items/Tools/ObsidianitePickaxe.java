package com.LunaGlaze.rainbowcompound.Projects.Items.Tools;

import com.LunaGlaze.rainbowcompound.Core.Tiers.ToolTiers;
import net.minecraft.world.item.PickaxeItem;

public class ObsidianitePickaxe extends PickaxeItem {
    public ObsidianitePickaxe() {
        super(ToolTiers.Obsidianite, 0, -3f,new Properties().fireResistant());
    }
}
