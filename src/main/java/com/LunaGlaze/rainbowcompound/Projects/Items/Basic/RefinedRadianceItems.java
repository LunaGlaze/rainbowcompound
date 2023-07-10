package com.LunaGlaze.rainbowcompound.Projects.Items.Basic;

import com.LunaGlaze.rainbowcompound.Core.Group.CreativeModeTabGroup;
import com.simibubi.create.content.legacy.RefinedRadianceItem;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class RefinedRadianceItems extends RefinedRadianceItem {
    public RefinedRadianceItems() {
        super(new Properties().tab(CreativeModeTabGroup.group).rarity(Rarity.UNCOMMON));
    }

    @Override
    public void fillItemCategory(CreativeModeTab pCategory, NonNullList<ItemStack> pItems) {
        if (this.allowdedIn(pCategory)) {
            pItems.add(new ItemStack(this));
        }
    }
}