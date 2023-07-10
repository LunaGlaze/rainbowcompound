package com.LunaGlaze.rainbowcompound.Mixins;

import com.LunaGlaze.rainbowcompound.Projects.Events.Render.ObsidianiteElytraLayer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public abstract class ElytraLayerRendererMixin<T extends LivingEntity, M extends EntityModel<T>> {
    @Shadow
    public abstract boolean addLayer(RenderLayer<T, M> pLayer);

    @Inject(method = "<init>", at = @At("RETURN"))
    private void newRenderer(EntityRendererProvider.Context context, EntityModel pModel, float pShadowRadius, CallbackInfo ci) {
        addLayer(new ObsidianiteElytraLayer<>((LivingEntityRenderer<T, M>) (Object) this, context.getModelSet()));
    }
}
