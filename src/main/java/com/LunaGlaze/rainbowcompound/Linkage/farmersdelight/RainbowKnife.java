package com.LunaGlaze.rainbowcompound.Linkage.farmersdelight;

import com.LunaGlaze.rainbowcompound.Core.Tiers.ToolTiers;
import net.minecraft.world.item.Rarity;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class RainbowKnife extends KnifeItem {
    public RainbowKnife() {
        super(ToolTiers.RAINBOW,0.5f,-2f,new Properties().fireResistant().rarity(Rarity.UNCOMMON));
    }
}
