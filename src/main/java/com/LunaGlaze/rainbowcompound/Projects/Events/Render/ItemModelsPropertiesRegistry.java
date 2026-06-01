package com.LunaGlaze.rainbowcompound.Projects.Events.Render;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import com.LunaGlaze.rainbowcompound.Projects.Items.Tools.ToolsItemRegistry;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = LunaUtils.MOD_ID, value = Dist.CLIENT)
public class ItemModelsPropertiesRegistry {
    @SubscribeEvent
    public static void propertyOverrideRegistry(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemProperties.register(ToolsItemRegistry.obsidianitebow.get(), ResourceLocation.withDefaultNamespace("pull"), (pItemStack, pClientLevel, pLivingEntity, pSeed) -> {
                if (pLivingEntity == null) {
                    return 0.0F;
                } else {
                    return pLivingEntity.getUseItem() != pItemStack ? 0.0F : (float)(pItemStack.getUseDuration(pLivingEntity) - pLivingEntity.getUseItemRemainingTicks()) / 20.0F;
                }
            });
            ItemProperties.register(ToolsItemRegistry.obsidianitebow.get(), ResourceLocation.withDefaultNamespace("pulling"), (pItemStack, pClientLevel, pLivingEntity, pSeed) -> pLivingEntity != null && pLivingEntity.isUsingItem() && pLivingEntity.getUseItem() == pItemStack ? 1.0F : 0.0F);
        });
    }
}