package com.LunaGlaze.rainbowcompound.Linkage.createaddition;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class OverchargedAlloy extends Item {
    public OverchargedAlloy() {
        super(new Properties().rarity(Rarity.UNCOMMON));
    }

    @Override
    public boolean isFoil(@NotNull ItemStack stack) {
        return true;
    }
}
