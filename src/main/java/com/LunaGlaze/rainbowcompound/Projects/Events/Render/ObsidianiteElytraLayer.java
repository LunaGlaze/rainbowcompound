package com.LunaGlaze.rainbowcompound.Projects.Events.Render;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import com.LunaGlaze.rainbowcompound.Core.Class.ModElytraItem;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ObsidianiteElytraLayer<T extends LivingEntity, M extends EntityModel<T>> extends ElytraLayer<T, M> {

    private final ElytraModel<T> elytraModel;

    public ObsidianiteElytraLayer(RenderLayerParent<T, M> renderIn, EntityModelSet root) {
        super(renderIn, root);
        this.elytraModel = new ElytraModel<>(root.bakeLayer(ModelLayers.ELYTRA));
    }

    @Override
    public boolean shouldRender(ItemStack stack, T entity) {
        return (stack.getItem() instanceof ModElytraItem);
    }

    @Override
    public ResourceLocation getElytraTexture(ItemStack stack,  T entity) {
        String name = stack.getItem().toString();
        return new ResourceLocation(LunaUtils.MOD_ID,"textures/entity/"+name+".png");
    }
}
