package com.LunaGlaze.rainbowcompound.Projects.Items.Tools;

import com.LunaGlaze.rainbowcompound.Core.Tiers.ToolTiers;
import net.minecraft.world.item.AxeItem;

public class ObsidianiteAxe  extends AxeItem {
    public ObsidianiteAxe() {
        super(ToolTiers.Obsidianite, 5, -3.1f, new Properties().fireResistant());
    }
}
