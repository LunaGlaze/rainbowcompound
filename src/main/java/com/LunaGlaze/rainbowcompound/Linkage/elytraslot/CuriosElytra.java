package com.LunaGlaze.rainbowcompound.Linkage.elytraslot;

import com.LunaGlaze.rainbowcompound.Linkage.elytraslot.ElytraLayer.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;

public class CuriosElytra {

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
            attributeInstance.removeModifier(CuriosModElytraItem.MOD_ELYTRA_MODIFIER);

            if (!attributeInstance.hasModifier(CuriosModElytraItem.MOD_ELYTRA_MODIFIER)) {
                CuriosApi.getCuriosHelper()
                        .findEquippedCurio((stack) -> stack.canElytraFly(player), player)
                        .ifPresent(triple -> attributeInstance
                                .addTransientModifier(CuriosModElytraItem.MOD_ELYTRA_MODIFIER));
            }
        }
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
    public static void registerElytraLayer(EntityRenderersEvent event) {
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
