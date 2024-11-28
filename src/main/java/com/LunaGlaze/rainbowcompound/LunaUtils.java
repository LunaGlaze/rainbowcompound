package com.LunaGlaze.rainbowcompound;

import com.LunaGlaze.rainbowcompound.Core.Registries.BaseRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;

public class LunaUtils {
    public static final String MOD_ID = "rainbowcompound";
    public static final String NAME = "Rainbow Compound";

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static RegistryObject<Item>[] getItemRegistries(Class registryClass) {
        Field[] fields = registryClass.getDeclaredFields();
        RegistryObject<Item>[] result = new RegistryObject[fields.length - 1];
        try {
            for (int i = 1; i < fields.length; i++) {
                result[i - 1] = (RegistryObject<Item>) fields[i].get(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public interface HideInTab {}

}
