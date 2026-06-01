package com.LunaGlaze.rainbowcompound.Linkage.elytraslot.ElytraLayer;

import com.LunaGlaze.rainbowcompound.Linkage.elytraslot.CuriosModElytraItem;
import com.LunaGlaze.rainbowcompound.Projects.Events.Render.ObsidianiteElytraLayer;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import java.util.concurrent.atomic.AtomicReference;

@OnlyIn(Dist.CLIENT)
public class ObsidianiteElytraLayerAdd extends ObsidianiteElytraLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
    public ObsidianiteElytraLayerAdd(
            RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> rendererIn,
            EntityModelSet modelSet) {
        super(rendererIn, modelSet);
    }

    @Override
    public boolean shouldRender(@NotNull ItemStack stack, @NotNull AbstractClientPlayer entity) {
        if(CuriosApi.getCuriosInventory(entity).isEmpty()){return false;}
        ICuriosItemHandler curiosInventory = CuriosApi.getCuriosInventory(entity).get();
        AtomicReference<Boolean> curioE = new AtomicReference<>(false);
        curiosInventory.getStacksHandler("back").ifPresent(slotInventory -> {
            int slotsNum = slotInventory.getSlots();
            for (int i=0 ; i<slotsNum && !curioE.get() ; i++){
                Item eqCurio = slotInventory.getStacks().getStackInSlot(i).getItem();
                if (eqCurio instanceof CuriosModElytraItem && slotInventory.getRenders().get(i)){
                    curioE.set(true);
                }
            }
        });
        return curioE.get();
    }

    @Override
    public @NotNull ResourceLocation getElytraTexture(@NotNull ItemStack stack, @NotNull AbstractClientPlayer entity) {
        if(CuriosApi.getCuriosInventory(entity).isEmpty()){
            return ResourceLocation.withDefaultNamespace("textures/entity/equipment/wings/elytra.png");
        }
        ICuriosItemHandler curiosInventory = CuriosApi.getCuriosInventory(entity).get();
        final String[] name = new String[1];
        name[0] = null;
        curiosInventory.getStacksHandler("back").ifPresent(slotInventory -> {
            int slotsNum = slotInventory.getSlots();
            for (int i=0 ; i<slotsNum ; i++){
                Item eqCurio = slotInventory.getStacks().getStackInSlot(i).getItem();
                if (eqCurio instanceof CuriosModElytraItem){
                    name[0] = eqCurio.toString();
                }
            }
        });
        if(name[0] !=null){
            return ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID,"textures/entity/" + name[0] + ".png");
        } else return ResourceLocation.withDefaultNamespace("textures/entity/equipment/wings/elytra.png");
    }
}
