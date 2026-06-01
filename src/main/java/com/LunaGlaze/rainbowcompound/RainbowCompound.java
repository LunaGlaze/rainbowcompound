package com.LunaGlaze.rainbowcompound;

import com.LunaGlaze.rainbowcompound.Core.Date.KeyBoard.ElytraFlyKey;
import com.LunaGlaze.rainbowcompound.Core.Date.LunaConfig;
import com.LunaGlaze.rainbowcompound.Core.Registries.RegistryManager;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.client.KeyMapping;
import net.minecraft.world.item.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(LunaUtils.MOD_ID)
public class RainbowCompound {
    public static boolean isFarmersDelightLoaded = false;
    public static boolean isCreateCraftAddLoaded = false;
    public static boolean isCuriousElytraLoaded = false;
    public static boolean isKaleidoscopeCookeryLoaded = false;

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(LunaUtils.MOD_ID);

    public RainbowCompound(IEventBus modEventBus, ModContainer modContainer){
        isFarmersDelightLoaded = ModList.get().isLoaded("farmersdelight");
        isCreateCraftAddLoaded = ModList.get().isLoaded("createaddition");
        isCuriousElytraLoaded = ModList.get().isLoaded("caelus");
        isKaleidoscopeCookeryLoaded = ModList.get().isLoaded("kaleidoscope_cookery");

        //onCreate(modEventBus);
        RegistryManager.register(modEventBus);

        ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.COMMON, LunaConfig.COMMON_CONFIG);
    }

    public static void onCreate(IEventBus modEventBus) {

        REGISTRATE.registerEventListeners(modEventBus);
        modEventBus.addListener(RainbowCompound::addCreative);
        //IncompleteItems.register();
    }

    private static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == AllCreativeModeTabs.BASE_CREATIVE_TAB.getKey()) {
            event.accept(new ItemStack(AllItems.CHROMATIC_COMPOUND.get()));
            event.accept(new ItemStack(AllItems.SHADOW_STEEL.get()));
            event.accept(new ItemStack(AllItems.REFINED_RADIANCE.get()));
            event.accept(new ItemStack(AllBlocks.SHADOW_STEEL_CASING.get()));
            event.accept(new ItemStack(AllBlocks.REFINED_RADIANCE_CASING.get()));
        }
    }

    @EventBusSubscriber(modid = LunaUtils.MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            for (ElytraFlyKey key : ElytraFlyKey.values()) {
                key.keybind = new KeyMapping(key.description, key.key, LunaUtils.NAME);
                if (!key.modifiable)
                    continue;
                event.register(key.keybind);
            }
        }
    }
}

