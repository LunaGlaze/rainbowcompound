package com.LunaGlaze.rainbowcompound.Linkage.elytraslot;

import com.LunaGlaze.rainbowcompound.Linkage.elytraslot.ElytraLayer.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;
import top.theillusivec4.caelus.api.CaelusApi;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class CuriosElytra {

    private static final AttributeModifier MOD_ELYTRA_MODIFIER = new AttributeModifier(
            UUID.fromString("92b506f3-0a87-4989-a203-2ed4c7b4c1fd"), "CRC Elytra modifier", 1.0D,
            AttributeModifier.Operation.ADDITION);
    public static void init(IEventBus modEventBus, IEventBus forgeEventBus) {
        modEventBus.addListener(CuriosElytra::onCommonSetup);

        if(FMLEnvironment.dist.isClient()) modEventBus.addListener(CuriosElytra::registerElytraLayer);
    }

    private static void onCommonSetup(FMLCommonSetupEvent event){
        MinecraftForge.EVENT_BUS.addListener(CuriosElytra::playerTick);
        MinecraftForge.EVENT_BUS.addGenericListener(ItemStack.class, CuriosElytra::attachCapabilities);
    }

    private static void playerTick(final TickEvent.PlayerTickEvent evt) {
        Player player = evt.player;
        AttributeInstance attributeInstance =
                player.getAttribute(CaelusApi.getInstance().getFlightAttribute());

        if (attributeInstance != null) {
            if(player.isFallFlying() && attributeInstance.hasModifier(MOD_ELYTRA_MODIFIER) && !hasElytra(player)){
                attributeInstance.removeModifier(MOD_ELYTRA_MODIFIER);
            }

            if (!attributeInstance.hasModifier(MOD_ELYTRA_MODIFIER)) {
                if (player.isFallFlying() && !hasElytra(player)){
                    attributeInstance.removeModifier(MOD_ELYTRA_MODIFIER);
                }else if(hasElytra(player)){
                    attributeInstance.addTransientModifier(MOD_ELYTRA_MODIFIER);
                }
            }
        }
    }
    public static boolean hasElytra(LivingEntity entity) {
        ICuriosItemHandler curiosInventory = CuriosApi.getCuriosInventory(entity).resolve().get();
        AtomicBoolean hasrlytras = new AtomicBoolean(false);
        curiosInventory.getStacksHandler("back").ifPresent(slotInventory -> {
            int slotsnum = slotInventory.getSlots();
            for (int i=0 ; i<slotsnum ; i++){
                ItemStack stack = slotInventory.getStacks().getStackInSlot(i);
                if(stack.canElytraFly(entity) || stack.getItem() instanceof CuriosModElytraItem){
                    hasrlytras.set(true);
                }
            }
        });
        return hasrlytras.get();
    }

    private static void attachCapabilities(final AttachCapabilitiesEvent<ItemStack> evt) {
        ItemStack stack = evt.getObject();

        if (stack.getItem() instanceof CuriosModElytraItem) {
            final LazyOptional<ICurio> elytraCurio = LazyOptional.of(() -> (CuriosModElytraItem) stack.getItem());
            evt.addCapability(CuriosCapability.ID_ITEM, new ICapabilityProvider() {

                @Nonnull
                @Override
                public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap,
                                                         @Nullable Direction side) {
                    return CuriosCapability.ITEM.orEmpty(cap, elytraCurio);
                }
            });
            evt.addListener(elytraCurio::invalidate);
        }
    }

    @OnlyIn(Dist.CLIENT)
    private static void registerElytraLayer(EntityRenderersEvent event) {
        if(event instanceof EntityRenderersEvent.AddLayers addLayersEvent){
            EntityModelSet entityModels = addLayersEvent.getEntityModels();
            addLayersEvent.getSkins().forEach(s -> {
                LivingEntityRenderer<? extends Player, ? extends EntityModel<? extends Player>> livingEntityRenderer = addLayersEvent.getSkin(s);
                if(livingEntityRenderer instanceof PlayerRenderer playerRenderer){
                    playerRenderer.addLayer(new ObsidianiteElytraLayerAdd(playerRenderer, entityModels));
                }
            });
        }
    }

}
