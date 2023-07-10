package com.LunaGlaze.rainbowcompound.Linkage.elytraslot.ElytraLayer;

import com.LunaGlaze.rainbowcompound.Projects.Events.Render.ObsidianiteElytraLayer;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.CuriosElytraItemRegistry;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class ObsidianiteElytraLayerAdd extends ObsidianiteElytraLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
    public ObsidianiteElytraLayerAdd(
            RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> rendererIn,
            EntityModelSet modelSet) {
        super(rendererIn, modelSet);
    }

    @Override
    public boolean shouldRender(ItemStack stack, AbstractClientPlayer entity) {
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio1 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.obsidianiteelytra.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio2 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_radiance.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio3 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_feather.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio4 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_fire.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio5 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_ice.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio6 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_66ccff.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio7 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_ender.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio8 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_slime.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio9 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_rainbow.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio10 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_flandre.get(), entity);
        return eqCurio1.isPresent() ||eqCurio2.isPresent() ||eqCurio3.isPresent() ||eqCurio4.isPresent() ||
                eqCurio5.isPresent() ||eqCurio6.isPresent() ||eqCurio7.isPresent() ||eqCurio8.isPresent() ||
                eqCurio9.isPresent() ||eqCurio10.isPresent();
    }

    @Override
    public ResourceLocation getElytraTexture(ItemStack stack, AbstractClientPlayer entity) {
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio1 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.obsidianiteelytra.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio2 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_radiance.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio3 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_feather.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio4 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_fire.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio5 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_ice.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio6 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_66ccff.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio7 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_ender.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio8 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_slime.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio9 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_rainbow.get(), entity);
        Optional<ImmutableTriple<String, Integer, ItemStack>> eqCurio10 =
                CuriosApi.getCuriosHelper().findEquippedCurio(CuriosElytraItemRegistry.dynamicelytra_flandre.get(), entity);


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
