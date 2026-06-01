package com.LunaGlaze.rainbowcompound.Core.Tab;

import com.LunaGlaze.rainbowcompound.Linkage.createaddition.CCAItemRegistry;
import com.LunaGlaze.rainbowcompound.Linkage.farmersdelight.FarmersDelightItemRegistry;
import com.LunaGlaze.rainbowcompound.Linkage.kaleidoscopecookery.KCItemRegistry;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import com.LunaGlaze.rainbowcompound.Projects.Blocks.BlocksItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.ArmorsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.CuriosElytraItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Basic.ItemsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Foods.FoodsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Props.PropsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Tools.ToolsItemRegistry;
import com.LunaGlaze.rainbowcompound.RainbowCompound;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RainbowcompoundTab {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LunaUtils.MOD_ID);
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> MOD_TAB = REGISTRY.register("rainbowcompound_group", () -> CreativeModeTab.builder()
            .icon(() -> (new ItemStack(ItemsItemRegistry.rainbowcompound.get())))
            .title(Component.translatable("itemGroup.rainbowcompound_group"))
            .displayItems((parameters, output) -> {
                // Basics
                ItemsItemRegistry.ITEMS.getEntries().stream().map(Supplier::get).forEach(output::accept);
                // Blocks
                BlocksItemRegistry.ITEMS.getEntries().stream().map(Supplier::get).forEach(output::accept);
                // Foods
                FoodsItemRegistry.ITEMS.getEntries().stream().map(Supplier::get).forEach(output::accept);
                // Props
                PropsItemRegistry.ITEMS.getEntries().stream().map(Supplier::get).forEach(output::accept);
                // Tools
                ToolsItemRegistry.ITEMS.getEntries().stream().map(Supplier::get).forEach(output::accept);
                // Armors
                ArmorsItemRegistry.ITEMS.getEntries().stream().map(Supplier::get).forEach(output::accept);

                // Caelus
                if (RainbowCompound.isCuriousElytraLoaded) {
                    CuriosElytraItemRegistry.ITEMS.getEntries().stream().map(Supplier::get).forEach(output::accept);
                }

                // Create Additions Linkage
                if (RainbowCompound.isCreateCraftAddLoaded) {
                    CCAItemRegistry.ITEMS.getEntries().stream().map(Supplier::get).forEach(output::accept);
                    //output.accept(new ItemStack(CCABlockRegistryTterrag.OVERCHARGED_CASING));
                }
                // Farmers' Delight Linkage
                if (RainbowCompound.isFarmersDelightLoaded) {
                    FarmersDelightItemRegistry.ITEMS.getEntries().stream().map(Supplier::get).forEach(output::accept);
                }
                // Kaleidoscope Cookery Linkage
                if (RainbowCompound.isKaleidoscopeCookeryLoaded) {
                    KCItemRegistry.ITEMS.getEntries().stream().map(Supplier::get).forEach(output::accept);
                }
                //Create Hide Items
                output.accept(new ItemStack((ItemLike) AllItems.REFINED_RADIANCE));
                output.accept(new ItemStack((ItemLike) AllItems.SHADOW_STEEL));
                output.accept(new ItemStack(AllBlocks.REFINED_RADIANCE_CASING));
                output.accept(new ItemStack(AllBlocks.SHADOW_STEEL_CASING));
            })
            .build()
    );
}
