package com.LunaGlaze.rainbowcompound.Projects.Blocks;

import com.simibubi.create.content.decoration.encasing.CasingBlock;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;

public class OverchargedCasing extends CasingBlock {
    public OverchargedCasing(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    @Override
    public void fillItemCategory(CreativeModeTab pCategory, NonNullList<ItemStack> pItems) {
        if (ModList.get().isLoaded("createaddition"))
            super.fillItemCategory(pCategory, pItems);
    }
}
