package com.LunaGlaze.rainbowcompound;

import com.LunaGlaze.rainbowcompound.Core.Curios.Curios;
import com.LunaGlaze.rainbowcompound.Core.Date.KeyBoard.ElytraFlyKey;
import com.LunaGlaze.rainbowcompound.Core.Date.LunaConfig;
import com.LunaGlaze.rainbowcompound.Core.Tab.RainbowcompoundTab;
import com.LunaGlaze.rainbowcompound.Linkage.createaddition.CCAItemRegistry;
import com.LunaGlaze.rainbowcompound.Linkage.elytraslot.CuriosElytra;
import com.LunaGlaze.rainbowcompound.Linkage.farmersdelight.farmersdelightItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Effect.EffectRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.ArmorsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.CuriosElytraItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Basic.ItemsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Foods.FoodsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Props.PropsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.SequencedAssembly.IncompleteItems;
import com.LunaGlaze.rainbowcompound.Projects.Items.Tools.ToolsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Blocks.BlocksBlockRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Blocks.BlocksItemRegistry;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.client.KeyMapping;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LunaUtils.MOD_ID)
public class RainbowCompound {

    public static boolean isFarmersDelightLoaded = false;
    public static boolean isCreateCraftAddLoaded = false;

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(LunaUtils.MOD_ID);

    public RainbowCompound(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        isFarmersDelightLoaded = ModList.get().isLoaded("farmersdelight");
        isCreateCraftAddLoaded = ModList.get().isLoaded("createaddition");

        onCreate(modEventBus);
        FoodsItemRegistry.ITEMS.register(modEventBus);
        ItemsItemRegistry.ITEMS.register(modEventBus);
        ToolsItemRegistry.ITEMS.register(modEventBus);
        ArmorsItemRegistry.ITEMS.register(modEventBus);
        PropsItemRegistry.ITEMS.register(modEventBus);
        BlocksBlockRegistry.BLOCKS.register(modEventBus);
        BlocksItemRegistry.ITEMS.register(modEventBus);
        EffectRegistry.EFFECTS.register(modEventBus);

        // 饰品栏鞘翅待修复
        CuriosElytra.init(modEventBus, forgeEventBus);
        CuriosElytraItemRegistry.ITEMS.register(modEventBus);
        RainbowcompoundTab.isCuriousElytraLoaded = true;

        if(isFarmersDelightLoaded) {
            farmersdelightItemRegistry.ITEMS.register(modEventBus);
            RainbowcompoundTab.isFarmersDelightLoaded = true;
        }
        if(isCreateCraftAddLoaded) {
            CCAItemRegistry.ITEMS.register(modEventBus);
            RainbowcompoundTab.isCreateCraftAddLoaded = true;
        }

        RainbowcompoundTab.REGISTRY.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, LunaConfig.COMMON_CONFIG);

        Curios.init(modEventBus, forgeEventBus);
    }
    public static void onCreate(IEventBus modEventBus) {

        REGISTRATE.registerEventListeners(modEventBus);
        modEventBus.addListener(RainbowCompound::addCreative);
        IncompleteItems.register();
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

    @Mod.EventBusSubscriber(modid = LunaUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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