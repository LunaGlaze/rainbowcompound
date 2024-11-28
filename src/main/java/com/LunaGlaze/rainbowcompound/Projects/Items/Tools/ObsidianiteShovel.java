package com.LunaGlaze.rainbowcompound.Projects.Items.Tools;

import com.LunaGlaze.rainbowcompound.Core.Tiers.ToolTiers;
import net.minecraft.world.item.ShovelItem;

public class ObsidianiteShovel extends ShovelItem {
    public ObsidianiteShovel() {
        super(ToolTiers.Obsidianite, -0.5f, -3f, new Properties().fireResistant());

    }
}
