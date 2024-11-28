package com.LunaGlaze.rainbowcompound.Linkage.elytraslot.ElytraLayer;

import com.LunaGlaze.rainbowcompound.Linkage.elytraslot.CuriosModElytraItem;
import com.LunaGlaze.rainbowcompound.Projects.Events.Render.ObsidianiteElytraLayer;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.CuriosElytraItemRegistry;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class ObsidianiteElytraLayerAdd
        extends ObsidianiteElytraLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {

    public ObsidianiteElytraLayerAdd(
            RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> rendererIn,
            EntityModelSet modelSet) {
        super(rendererIn, modelSet);
    }

    @Override
    public boolean shouldRender(ItemStack stack, AbstractClientPlayer entity) {
        Optional<SlotResult> eqCurio1 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.obsidianiteelytra.get());
        Optional<SlotResult> eqCurio2 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_radiance.get());
        Optional<SlotResult> eqCurio3 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_feather.get());
        Optional<SlotResult> eqCurio4 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_fire.get());
        Optional<SlotResult> eqCurio5 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_ice.get());
        Optional<SlotResult> eqCurio6 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_66ccff.get());
        Optional<SlotResult> eqCurio7 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_ender.get());
        Optional<SlotResult> eqCurio8 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_slime.get());
        Optional<SlotResult> eqCurio9 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_rainbow.get());
        Optional<SlotResult> eqCurio10 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_flandre.get());
        return eqCurio1.isPresent() ||eqCurio2.isPresent() ||eqCurio3.isPresent() ||eqCurio4.isPresent() ||
                eqCurio5.isPresent() ||eqCurio6.isPresent() ||eqCurio7.isPresent() ||eqCurio8.isPresent() ||
                eqCurio9.isPresent() ||eqCurio10.isPresent() || stack.getItem() instanceof CuriosModElytraItem;
    }

    @Override
    public ResourceLocation getElytraTexture(ItemStack stack, AbstractClientPlayer entity) {
        Optional<SlotResult> eqCurio1 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.obsidianiteelytra.get());
        Optional<SlotResult> eqCurio2 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_radiance.get());
        Optional<SlotResult> eqCurio3 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_feather.get());
        Optional<SlotResult> eqCurio4 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_fire.get());
        Optional<SlotResult> eqCurio5 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_ice.get());
        Optional<SlotResult> eqCurio6 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_66ccff.get());
        Optional<SlotResult> eqCurio7 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_ender.get());
        Optional<SlotResult> eqCurio8 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_slime.get());
        Optional<SlotResult> eqCurio9 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_rainbow.get());
        Optional<SlotResult> eqCurio10 =
                CuriosApi.getCuriosHelper().findFirstCurio(entity, CuriosElytraItemRegistry.dynamicelytra_flandre.get());


        if(eqCurio1.isPresent()){
            return new ResourceLocation(LunaUtils.MOD_ID,"textures/entity/obsidianite_elytra.png");
        } else if(eqCurio2.isPresent()){
            return new ResourceLocation(LunaUtils.MOD_ID,"textures/entity/dynamic_elytra_radiance.png");
        } else if (eqCurio3.isPresent()) {
            return new ResourceLocation(LunaUtils.MOD_ID,"textures/entity/dynamic_elytra_feather.png");
        } else if (eqCurio4.isPresent()) {
            return new ResourceLocation(LunaUtils.MOD_ID,"textures/entity/dynamic_elytra_fire.png");
        } else if (eqCurio5.isPresent()) {
            return new ResourceLocation(LunaUtils.MOD_ID,"textures/entity/dynamic_elytra_ice.png");
        } else if (eqCurio6.isPresent()) {
            return new ResourceLocation(LunaUtils.MOD_ID,"textures/entity/dynamic_elytra_66ccff.png");
        } else if (eqCurio7.isPresent()) {
            return new ResourceLocation(LunaUtils.MOD_ID,"textures/entity/dynamic_elytra_ender.png");
        } else if (eqCurio8.isPresent()) {
            return new ResourceLocation(LunaUtils.MOD_ID,"textures/entity/dynamic_elytra_slime.png");
        } else if (eqCurio9.isPresent()) {
            return new ResourceLocation(LunaUtils.MOD_ID,"textures/entity/dynamic_elytra_rainbow.png");
        } else if (eqCurio10.isPresent()) {
            return new ResourceLocation(LunaUtils.MOD_ID,"textures/entity/dynamic_elytra_flandre.png");
        }else return  new ResourceLocation(LunaUtils.MOD_ID,"textures/entity/obsidianite_elytra.png");
    }
}
