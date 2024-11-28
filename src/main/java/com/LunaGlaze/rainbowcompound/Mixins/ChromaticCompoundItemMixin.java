package com.LunaGlaze.rainbowcompound.Mixins;


import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.AllItems;
import com.simibubi.create.Create;
import com.simibubi.create.content.legacy.ChromaticCompoundItem;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ChromaticCompoundItem.class)
public abstract class ChromaticCompoundItemMixin {

    /**
     * @author
     * @reason
     */
    @Overwrite
    public void fillItemCategory(CreativeModeTab pCategory, NonNullList<ItemStack> pItems) {
        if (pCategory == AllCreativeModeTabs.BASE_CREATIVE_TAB) {
            pItems.add(new ItemStack(AllItems.CHROMATIC_COMPOUND.get()));
            pItems.add(new ItemStack(AllItems.SHADOW_STEEL.get()));
            pItems.add(new ItemStack(AllItems.REFINED_RADIANCE.get()));
            pItems.add(new ItemStack(AllBlocks.SHADOW_STEEL_CASING.get()));
            pItems.add(new ItemStack(AllBlocks.REFINED_RADIANCE_CASING.get()));
        }
    }
}
