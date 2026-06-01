package com.LunaGlaze.rainbowcompound.Core.Client.Renderer;

import com.LunaGlaze.rainbowcompound.Core.Class.ModElytraItem;
import com.LunaGlaze.rainbowcompound.Linkage.elytraslot.CuriosModElytraItem;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.CuriosElytraItemRegistry;
import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@OnlyIn(Dist.CLIENT)
public class ModElytraLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private static final Map<ModElytraItem, ResourceLocation> TEXTURE_MAP = ImmutableMap.<ModElytraItem, ResourceLocation>builder()
            .put(CuriosElytraItemRegistry.obsidianite_elytra.get(), ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID, "textures/entity/obsidianite_elytra.png"))
            .put(CuriosElytraItemRegistry.dynamicelytra_rainbow.get(), ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID, "textures/entity/rainbow_elytra.png"))
            .put(CuriosElytraItemRegistry.dynamicelytra_66ccff.get(), ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID, "textures/entity/dynamic_elytra_66ccff.png"))
            .put(CuriosElytraItemRegistry.dynamicelytra_ender.get(), ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID, "textures/entity/dynamic_elytra_ender.png"))
            .put(CuriosElytraItemRegistry.dynamicelytra_feather.get(), ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID, "textures/entity/dynamic_elytra_feather.png"))
            .put(CuriosElytraItemRegistry.dynamicelytra_fire.get(), ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID, "textures/entity/dynamic_elytra_fire.png"))
            .put(CuriosElytraItemRegistry.dynamicelytra_flandre.get(), ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID, "textures/entity/dynamic_elytra_flandre.png"))
            .put(CuriosElytraItemRegistry.dynamicelytra_ice.get(), ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID, "textures/entity/dynamic_elytra_ice.png"))
            .put(CuriosElytraItemRegistry.dynamicelytra_radiance.get(), ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID, "textures/entity/dynamic_elytra_radiance.png"))
            .put(CuriosElytraItemRegistry.dynamicelytra_slime.get(), ResourceLocation.fromNamespaceAndPath(LunaUtils.MOD_ID, "textures/entity/dynamic_elytra_slime.png"))
            .build();

    private final ElytraModel<T> elytraModel;

    public ModElytraLayer(RenderLayerParent<T, M> layerParent, EntityModelSet modelSet) {
        super(layerParent);
        this.elytraModel = new ElytraModel<>(modelSet.bakeLayer(ModelLayers.ELYTRA));
    }

    @Override
    public void render(PoseStack poseStack,
                       MultiBufferSource buffer,
                       int packedLight,
                       T entity,
                       float limbSwing,
                       float limbSwingAmount,
                       float partialTick,
                       float ageInTicks,
                       float netHeadYaw,
                       float headPitch) {
        ItemStack elytra = getCuriosItem(entity);
        AtomicBoolean notRender = new AtomicBoolean(false);
        CuriosApi.getCuriosInventory(entity).flatMap(handler -> handler.findFirstCurio(stack -> stack.getItem() instanceof CuriosModElytraItem)).ifPresent(curio -> {
            if (!curio.slotContext().visible()) notRender.set(true);
        });
        if (notRender.get()) return;
        if (!elytra.isEmpty() && elytra.getItem() instanceof CuriosModElytraItem item) {
            poseStack.pushPose();
            poseStack.translate(0.0D, 0.0D, 0.125D);
            this.getParentModel().copyPropertiesTo(this.elytraModel);
            this.elytraModel.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(buffer, RenderType.armorCutoutNoCull(TEXTURE_MAP.get(item)), elytra.hasFoil());
            this.elytraModel.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }
    }

    private static ItemStack getCuriosItem(LivingEntity entity) {
        Optional<ICuriosItemHandler> curios = CuriosApi.getCuriosInventory(entity);
        if (curios.isPresent()) {
            Optional<SlotResult> firstCurio = curios.get().findFirstCurio(stack -> stack.getItem() instanceof CuriosModElytraItem);
            if (firstCurio.isPresent()) return firstCurio.get().stack();
        }
        ItemStack itemBySlot = entity.getItemBySlot(EquipmentSlot.CHEST);
        return itemBySlot.getItem() instanceof CuriosModElytraItem ? itemBySlot : ItemStack.EMPTY;
    }
}
