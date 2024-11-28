package com.LunaGlaze.rainbowcompound.Projects.Items.Tools;

import com.LunaGlaze.rainbowcompound.Core.Tiers.ToolTiers;
import net.minecraft.world.item.SwordItem;

public class ObsidianiteSword extends SwordItem {
    public ObsidianiteSword() {
        super(ToolTiers.Obsidianite,3,-2.5f,new Properties().fireResistant());
    }
}
