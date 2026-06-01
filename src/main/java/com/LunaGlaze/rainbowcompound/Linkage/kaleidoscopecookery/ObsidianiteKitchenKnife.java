package com.LunaGlaze.rainbowcompound.Linkage.kaleidoscopecookery;

import com.LunaGlaze.rainbowcompound.Core.Tiers.ToolTiers;
import com.github.ysbbbbbb.kaleidoscopecookery.item.KitchenKnifeItem;

public class ObsidianiteKitchenKnife extends KitchenKnifeItem {
    public ObsidianiteKitchenKnife() {
        super(ToolTiers.Obsidianite, new Properties().fireResistant().attributes(createAttributes(ToolTiers.Obsidianite, 0.5f, -2.2f)));
    }
}
