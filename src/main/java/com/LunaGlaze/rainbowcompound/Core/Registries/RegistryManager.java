package com.LunaGlaze.rainbowcompound.Core.Registries;

import com.LunaGlaze.rainbowcompound.Core.ArmorMaterials.CRCArmorMaterials;
import com.LunaGlaze.rainbowcompound.Core.Tab.RainbowcompoundTab;
import com.LunaGlaze.rainbowcompound.Linkage.createaddition.CCAItemRegistry;
import com.LunaGlaze.rainbowcompound.Linkage.farmersdelight.FarmersDelightItemsRegistry;
import com.LunaGlaze.rainbowcompound.Linkage.kaleidoscopecookery.KCItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Blocks.BlocksBlockRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Blocks.BlocksItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Effect.EffectRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.ArmorsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.CuriosElytraItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Basic.ItemsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Foods.FoodsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Props.PropsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.SequencedAssembly.IncompleteItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Tools.ToolsItemRegistry;
import com.LunaGlaze.rainbowcompound.RainbowCompound;
import net.neoforged.bus.api.IEventBus;

public class RegistryManager {

    public static void register(IEventBus modEventBus) {
        CRCArmorMaterials.register(modEventBus);
        ArmorsItemRegistry.ITEMS.register(modEventBus);
        BlocksBlockRegistry.BLOCKS.register(modEventBus);
        BlocksItemRegistry.ITEMS.register(modEventBus);
        EffectRegistry.EFFECTS.register(modEventBus);
        FoodsItemRegistry.ITEMS.register(modEventBus);
        IncompleteItemRegistry.ITEMS.register(modEventBus);
        ItemsItemRegistry.ITEMS.register(modEventBus);
        PropsItemRegistry.ITEMS.register(modEventBus);
        ToolsItemRegistry.ITEMS.register(modEventBus);

        // Caelus
        if (RainbowCompound.isCuriousElytraLoaded) {
            CuriosElytraItemRegistry.ITEMS.register(modEventBus);
        }

        // Create Crafts and additions Linkage
        if (RainbowCompound.isCreateCraftAddLoaded) {
            CCAItemRegistry.ITEMS.register(modEventBus);
        }

        // Farmer's Delight Linkage
        if (RainbowCompound.isFarmersDelightLoaded) {
            FarmersDelightItemsRegistry.ITEMS.register(modEventBus);
        }

        // Kaleidoscope Cookery Linkage
        if(RainbowCompound.isKaleidoscopeCookeryLoaded) {
            KCItemRegistry.ITEMS.register(modEventBus);
        }

        RainbowcompoundTab.REGISTRY.register(modEventBus);
    }
}
