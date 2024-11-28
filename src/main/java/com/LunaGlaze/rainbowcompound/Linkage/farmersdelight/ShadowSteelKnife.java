package com.LunaGlaze.rainbowcompound.Linkage.farmersdelight;

import com.LunaGlaze.rainbowcompound.Core.Tiers.ToolTiers;
import net.minecraft.world.item.Rarity;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class ShadowSteelKnife extends KnifeItem {
    public ShadowSteelKnife() {
        super(ToolTiers.Shadowsteeltool,0.5f,-1.75f,new Properties().rarity(Rarity.UNCOMMON));
    }
}
