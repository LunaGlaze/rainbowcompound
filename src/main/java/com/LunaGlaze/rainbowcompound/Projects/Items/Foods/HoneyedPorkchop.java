package com.LunaGlaze.rainbowcompound.Projects.Items.Foods;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class HoneyedPorkchop extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder())
            .saturationMod(2F)
            .nutrition(9)
            .build();

    public HoneyedPorkchop() {
        super(new Properties().food(food));
    }
}