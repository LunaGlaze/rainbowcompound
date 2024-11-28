package com.LunaGlaze.rainbowcompound;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;

public class LunaUtils {
    public static final String MOD_ID = "rainbowcompound";
    public static final String NAME = "Rainbow Compound";

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static boolean isFarmersDelightLoaded =  ModList.get().isLoaded("farmersdelight");
    public static boolean isCuriosLoaded =  ModList.get().isLoaded("curios");
    public static boolean isCaelusLoaded =  ModList.get().isLoaded("caelus");

}
