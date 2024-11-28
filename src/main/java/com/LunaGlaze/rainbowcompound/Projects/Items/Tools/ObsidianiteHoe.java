package com.LunaGlaze.rainbowcompound.Projects.Items.Tools;

import com.LunaGlaze.rainbowcompound.Core.Tiers.ToolTiers;
import net.minecraft.world.item.HoeItem;

public class ObsidianiteHoe extends HoeItem {
    public ObsidianiteHoe() {
        super(ToolTiers.Obsidianite, -3, -3f, new Properties().fireResistant());
    }
}
