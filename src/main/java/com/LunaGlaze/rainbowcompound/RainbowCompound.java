package com.LunaGlaze.rainbowcompound;

import com.LunaGlaze.rainbowcompound.Core.Curios.Curios;
import com.LunaGlaze.rainbowcompound.Core.Date.LunaConfig;
import com.LunaGlaze.rainbowcompound.Core.Date.KeyBoard.ElytraFlyKey;
import com.LunaGlaze.rainbowcompound.Linkage.createaddition.CCAItemRegistry;
import com.LunaGlaze.rainbowcompound.Linkage.elytraslot.CuriosElytra;
import com.LunaGlaze.rainbowcompound.Linkage.farmersdelight.farmersdelightItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Blocks.BlockRegistryTterrag;
import com.LunaGlaze.rainbowcompound.Projects.Blocks.BlocksBlockRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Blocks.BlocksItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Blocks.EncasedBlock.CasingEncasedBlocks;
import com.LunaGlaze.rainbowcompound.Projects.Effect.EffectRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.ArmorsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.CuriosElytraItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.ElytraItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Basic.ItemsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Foods.FoodsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Props.PropsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.SequencedAssembly.IncompleteItems;
import com.LunaGlaze.rainbowcompound.Projects.Items.Tools.ToolsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.TileEntities.EncasedTileEntities;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("rainbowcompound")
public class RainbowCompound {
    public static boolean isFarmersDelightLoaded = false;
    public static boolean isCuriousElytraLoaded = false;
    public static boolean isCreateCraftAddLoaded = false;
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create("rainbowcompound");

    public RainbowCompound() {
        IEventBus registereventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
        isFarmersDelightLoaded = ModList.get().isLoaded("farmersdelight");
        isCuriousElytraLoaded = ModList.get().isLoaded("curiouselytra");
        isCreateCraftAddLoaded = ModList.get().isLoaded("createaddition");
        onCreate();
        FoodsItemRegistry.ITEMS.register(registereventBus);
        ItemsItemRegistry.ITEMS.register(registereventBus);
        ToolsItemRegistry.ITEMS.register(registereventBus);
        ArmorsItemRegistry.ITEMS.register(registereventBus);
        if (isCuriousElytraLoaded) {
            CuriosElytra.init(registereventBus, forgeEventBus);
            CuriosElytraItemRegistry.ITEMS.register(registereventBus);
        } else {
            ElytraItemRegistry.ITEMS.register(registereventBus);
        }

        PropsItemRegistry.ITEMS.register(registereventBus);
        BlocksBlockRegistry.BLOCKS.register(registereventBus);
        BlocksItemRegistry.ITEMS.register(registereventBus);
        EffectRegistry.EFFECTS.register(registereventBus);
        if (isFarmersDelightLoaded) {
            farmersdelightItemRegistry.ITEMS.register(registereventBus);
        }

        if (isCreateCraftAddLoaded) {
            CCAItemRegistry.ITEMS.register(registereventBus);
        }

        ModLoadingContext.get().registerConfig(Type.COMMON, LunaConfig.COMMON_CONFIG);
        registereventBus.addListener(RainbowCompound::clientInit);
        Curios.init(registereventBus, forgeEventBus);
    }

    public static void clientInit(RegisterKeyMappingsEvent event) {
        ElytraFlyKey.register(event);
    }

    public static void onCreate() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        REGISTRATE.registerEventListeners(modEventBus);
        BlockRegistryTterrag.register();
        IncompleteItems.register();
        CasingEncasedBlocks.register();
        EncasedTileEntities.register();
    }
}