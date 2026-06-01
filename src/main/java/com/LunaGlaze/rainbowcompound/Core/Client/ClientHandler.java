package com.LunaGlaze.rainbowcompound.Core.Client;

import com.LunaGlaze.rainbowcompound.Core.Client.Renderer.ModElytraLayer;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = LunaUtils.MOD_ID, value = Dist.CLIENT)
public class ClientHandler {
    @SubscribeEvent
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void addLayers(EntityRenderersEvent.AddLayers event) {
        if (event.getSkin(PlayerSkin.Model.WIDE) instanceof LivingEntityRenderer renderer) {
            renderer.addLayer(new ModElytraLayer(renderer, event.getEntityModels()));
        }
        if (event.getSkin(PlayerSkin.Model.SLIM) instanceof LivingEntityRenderer renderer) {
            renderer.addLayer(new ModElytraLayer(renderer, event.getEntityModels()));
        }
        if (event.getRenderer(EntityType.ARMOR_STAND) instanceof LivingEntityRenderer renderer) {
            renderer.addLayer(new ModElytraLayer(renderer, event.getEntityModels()));
        }
    }
}
