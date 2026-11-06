package com.LunaGlaze.rainbowcompound;

import com.LunaGlaze.rainbowcompound.Core.Date.KeyBoard.ElytraFlyKey;
import com.LunaGlaze.rainbowcompound.Core.Date.LunaConfig;
import com.LunaGlaze.rainbowcompound.Core.Registries.RegistryManager;
import com.LunaGlaze.rainbowcompound.Linkage.createaddition.CCABlockRegistryTterrag;
import com.LunaGlaze.rainbowcompound.Linkage.createaddition.CCAItemRegistry;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.client.KeyMapping;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
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

        RegistryManager.register(modEventBus);
        onCreate(modEventBus);

        ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.COMMON, LunaConfig.COMMON_CONFIG);
    }

    public static void onCreate(IEventBus modEventBus) {

        REGISTRATE.registerEventListeners(modEventBus);
        modEventBus.addListener(RainbowCompound::addCreative);
        if (isCreateCraftAddLoaded) {
            CCABlockRegistryTterrag.register();
        }
        //IncompleteItems.register();
    }
    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }

    private static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == AllCreativeModeTabs.BASE_CREATIVE_TAB.getKey()) {
            addIfAbsent(event, AllItems.CHROMATIC_COMPOUND.get());
            addIfAbsent(event, AllItems.SHADOW_STEEL.get());
            addIfAbsent(event, AllItems.REFINED_RADIANCE.get());
            addIfAbsent(event, AllBlocks.SHADOW_STEEL_CASING.get());
            addIfAbsent(event, AllBlocks.REFINED_RADIANCE_CASING.get());
        }
    }

    private static void addIfAbsent(BuildCreativeModeTabContentsEvent event, ItemLike item) {
        ItemStack stack = new ItemStack(item);
        if (!event.getParentEntries().contains(stack) && !event.getSearchEntries().contains(stack)) {
            event.accept(item);
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

