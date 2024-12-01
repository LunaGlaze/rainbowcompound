package com.LunaGlaze.rainbowcompound.Linkage.elytraslot.ElytraLayer;

import com.LunaGlaze.rainbowcompound.Linkage.elytraslot.CuriosModElytraItem;
import com.LunaGlaze.rainbowcompound.Projects.Events.Render.ObsidianiteElytraLayer;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.CuriosElytraItemRegistry;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@OnlyIn(Dist.CLIENT)
public class ObsidianiteElytraLayerAdd extends ObsidianiteElytraLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
    public ObsidianiteElytraLayerAdd(
            RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> rendererIn,
            EntityModelSet modelSet) {
        super(rendererIn, modelSet);
    }

    @Override
    public boolean shouldRender(ItemStack stack, AbstractClientPlayer entity) {
        if(entity == null || !CuriosApi.getCuriosInventory(entity).isPresent()){return false;}
        ICuriosItemHandler curiosInventory = CuriosApi.getCuriosInventory(entity).resolve().get();
        AtomicReference<Boolean> curioE = new AtomicReference<>(false);
        curiosInventory.getStacksHandler("back").ifPresent(slotInventory -> {
            int slotsnum = slotInventory.getSlots();
            for (int i=0 ; i<slotsnum && !curioE.get() ; i++){
                Item eqCurio = slotInventory.getStacks().getStackInSlot(i).getItem();
                if (eqCurio instanceof CuriosModElytraItem && slotInventory.getRenders().get(i)){
                    curioE.set(true);
                }
            }
        });
        return curioE.get();
    }

    @Override
    public ResourceLocation getElytraTexture(ItemStack stack, AbstractClientPlayer entity) {
        ICuriosItemHandler curiosInventory = CuriosApi.getCuriosInventory(entity).resolve().get();
        final String[] name = new String[1];
        name[0] = null;
        curiosInventory.getStacksHandler("back").ifPresent(slotInventory -> {
            int slotsnum = slotInventory.getSlots();
            for (int i=0 ; i<slotsnum ; i++){
                Item eqCurio = slotInventory.getStacks().getStackInSlot(i).getItem();
                if (eqCurio instanceof CuriosModElytraItem){
                    name[0] = eqCurio.toString();
                }
            }
        });
        if(name[0] !=null){
            return new ResourceLocation(LunaUtils.MOD_ID,"textures/entity/" + name[0] + ".png");
        }else return null;
    }
}
