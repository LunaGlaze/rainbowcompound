package com.LunaGlaze.rainbowcompound.Mixins;

import com.simibubi.create.AllItems;
import com.simibubi.create.compat.jei.ConversionRecipe;
import com.simibubi.create.compat.jei.category.MysteriousItemConversionCategory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(MysteriousItemConversionCategory.class)
public class JEIMysteriousItemMixin {

    @Final
    private static final List<ConversionRecipe> RECIPES = MysteriousItemConversionCategory.RECIPES;

    static {
		RECIPES.add(ConversionRecipe.create(AllItems.CHROMATIC_COMPOUND.asStack(), AllItems.SHADOW_STEEL.asStack()));
		RECIPES.add(ConversionRecipe.create(AllItems.CHROMATIC_COMPOUND.asStack(), AllItems.REFINED_RADIANCE.asStack()));
    }


}
